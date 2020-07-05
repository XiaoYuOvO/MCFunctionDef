package net.xiaoyu233.mcfdef.service.minecraft_server;

import net.xiaoyu233.mcfdef.compile.handler.CompilationStatsHandler;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MCServerCompileStatsHandler implements CompilationStatsHandler {
    private MinecraftServer server;
    private long startTime;

    public MCServerCompileStatsHandler(MinecraftServer server){
        this.server = server;
    }
    @Override
    public void onStartCompileNamespace(List<File> toCompileFunctions, List<File> toCompileDefs, String src) {
        sendLogMsg(("Start compile function files in " + src + "( "+ toCompileFunctions.size() + " MCFunction(s) ; " + toCompileDefs.size() + " MCFunctionDef(s)"+ ")").replace("\\","\\\\"));
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onFunctionCompiled(MCFunction function) {
        sendLogMsg(("Compiled Function " + function.getFileName()).replace("\\","\\\\"));
    }

    @Override
    public void onFunctionDefCompiled(MCFunctionDef functionDef) {

    }

    @Override
    public void onFunctionParsed(MCFunction function) {
        sendLogMsg(("Parsed Function " + function.getFileName()).replace("\\","\\\\"));
    }

    @Override
    public void onFunctionDefParsed(MCFunctionDef functionDef) {
        sendLogMsg(("Parsed FunctionDef " + functionDef.getFileName()).replace("\\","\\\\"));
    }

    @Override
    public void onCompileFinished() {
        sendLogMsg("Compilation finished,time used:" + (System.currentTimeMillis() - startTime + "ms"));
    }

    @Override
    public void onFunctionFileWrote(File functionFile) {
        sendLogMsg(("Write file:" + functionFile.getPath()).replace("\\","\\\\"));
    }

    private void sendLogMsg(String msg){
        try {
            server.sendCommand("tellraw @a [{\"text\":\"[MCFDef Compiler]\",\"color\":\"rest\"},{\"color\":\"rest\",\"text\":\"" + msg + "\"}]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
