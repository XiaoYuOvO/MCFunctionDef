package net.xiaoyu233.mcfdef.service.minecraft_server;

import net.xiaoyu233.mcfdef.compile.MCFDefCompiler;
import net.xiaoyu233.mcfdef.compile.MCFDefProject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MCServerCompilingService {
    public static void main(String[] args) throws IOException {
        String jarPath = null,vmArgs = null,serverArgs = null,projectFileStr = null;
        for (int i = 0, argsLength = args.length; i < argsLength; i++) {
            String arg = args[i];
            switch (arg) {
                case "--serverJar":
                    jarPath = args[i + 1];
                    break;
                case "--serverArgs":
                    serverArgs = args[i + 1];
                    break;
                case "--vmArgs":
                    vmArgs = args[i + 1];
                    break;
                case "--projectFile":
                    projectFileStr = args[i + 1];
                    break;
            }
        }
        if (jarPath == null|| projectFileStr == null){
            System.err.println("Invalid Argument:");
            System.err.println("    Usage: MCServerCompilingService --serverJar [server jar path] --projectFile [mcfdef project file(json)](--vmArgs [server jvm args] --serverArgs [MC server args] )");
            System.exit(1);
        }
        File jarFile = new File(jarPath),projectFile = new File(projectFileStr);
        checkArgument(jarFile.exists(),"Cannot find server jar file");
        checkArgument(jarFile.isFile(),"Server jar file isn't a file");
        vmArgs = vmArgs == null ?  "" : vmArgs;
        serverArgs = serverArgs == null ?  "" : serverArgs;
        MinecraftServer server = MinecraftServer.launch(jarFile,vmArgs,serverArgs);

        new Thread(()->{
            Scanner sysIn = new Scanner(System.in);
            while (sysIn.hasNextLine()){
                try {
                    server.sendCommand(sysIn.nextLine());
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }).start();
        server.addChatMsgListener((chatMessage -> {
            if (chatMessage.getContent().equals("mcfdef.rebuild")){
                try {
                    MCFDefCompiler compiler = new MCFDefCompiler(MCFDefProject.deserialize(projectFile));
                    compiler.addStatsHandler(new MCServerCompileStatsHandler(server));
                    compiler.addErrorHandler(new MCServerCompileErrorHandler(server));
                    compiler.compile();
                    server.reload();
                } catch (IOException e) {
                    e.printStackTrace();
                    printErrorMsg(server,e.getMessage());
                }
            }
        }));
        Runtime.getRuntime().addShutdownHook(new Thread(server::destroy));

        while (server.isAlive()){
            server.tick();

        }
    }

    private static void checkArgument(boolean predicate,String msg){
        if (!predicate){
            throw new IllegalArgumentException(msg);
        }
    }

    public static void printErrorMsg(MinecraftServer server,String msg) {
        try {
            server.sendCommand("tellraw @a [{\"text\":\"[MCFDef Compiler]\",\"color\":\"rest\"},{\"color\":\"red\",\"text\":\"Error in compiling functions: " + msg + "\"}]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
