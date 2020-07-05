package net.xiaoyu233.mcfdef.service.minecraft_server;

import javax.crypto.Mac;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class MinecraftServer {
    private final Process mcServerProcess;
    private final Scanner logInput;
    private final Scanner errInput;
    private final OutputStreamWriter commandOutput;
    private final ArrayList<Consumer<ChatMessage>> chatMsgListeners = new ArrayList<>();
    public static MinecraftServer launch(File serverJar,String vmArgs,String serverArgs) throws IOException {
        String javaHome = System.getProperty("java.home");
        Process process = Runtime.getRuntime().exec(javaHome + "\\bin\\java.exe "  + vmArgs + " -jar " + serverJar.getAbsolutePath()  + " " + serverArgs);
        return new MinecraftServer(process);
    }
    private MinecraftServer(Process mcServerProcess){
        this.mcServerProcess = mcServerProcess;
        this.commandOutput = new OutputStreamWriter(mcServerProcess.getOutputStream());
        this.logInput =  new Scanner(mcServerProcess.getInputStream());
        this.errInput = new Scanner(mcServerProcess.getErrorStream());
    }

    public void addChatMsgListener(Consumer<ChatMessage> listener){
        this.chatMsgListeners.add(listener);
    }

    public void removeChatMsgListener(int index){
        this.chatMsgListeners.remove(index);
    }

    public void removeChatMsgListener(Consumer<ChatMessage> listener){
        this.chatMsgListeners.remove(listener);
    }

    public void sendCommand(String command) throws IOException {
        this.commandOutput.write(command);
        this.commandOutput.write("\n");
        this.commandOutput.flush();
    }

    public void reload() throws IOException {
        this.sendCommand("reload");
    }

    public void tick(){
        while (logInput.hasNextLine()){
            String log = logInput.nextLine();
            System.out.println(log);
            try {
                ChatMessage message = ChatMessage.parse(log);
                for (Consumer<ChatMessage> chatMsgListener : this.chatMsgListeners) {
                    chatMsgListener.accept(message);
                }
            }catch (Exception e){
                System.err.println("Cannot parse chat message: \"" + log + " \"" + "\n   cause by:");
                e.printStackTrace();
            }
        }
        while (errInput.hasNextLine()){
            String log = errInput.nextLine();
            System.err.println(log);
            try {
                ChatMessage message = ChatMessage.parse(log);
                for (Consumer<ChatMessage> chatMsgListener : this.chatMsgListeners) {
                    chatMsgListener.accept(message);
                }
            }catch (Exception e){
                System.err.println("Cannot parse chat message: \"" + log + " \"" + "\n   cause by:");
                e.printStackTrace();
            }
        }
    }



    public boolean isAlive(){
        return mcServerProcess.isAlive();
    }

    public void destroy(){
        this.mcServerProcess.destroy();
    }

    public void destroyForcibly(){
        this.mcServerProcess.destroyForcibly();
    }
}
