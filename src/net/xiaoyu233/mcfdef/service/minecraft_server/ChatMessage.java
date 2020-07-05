package net.xiaoyu233.mcfdef.service.minecraft_server;

public class ChatMessage {
    private String sender = "";
    private String time = "";
    private String content = "";
    private String type = "";
    private String thread = "";
    private ChatMessage(){

    }
    //[22:25:14] [Server thread/INFO]: [Server] 1
    public static ChatMessage parse(String raw){
        ChatMessage result = new ChatMessage();
        try {
            String[] infoAndMsg = raw.split("]:", 2);
            String info = infoAndMsg[0];
            String[] timeAndThread = info.split("\\]");
            String time = timeAndThread[0].substring(1);
            String[] threadAndType = timeAndThread[1].substring(2).split("/");
            String thread = threadAndType[0];
            String type = threadAndType[1];
            String msg = infoAndMsg[1];
            String[] senderAndMsg = msg.trim().split(" ", 2);
            String sender = senderAndMsg[0].replace(":", "");
            if (sender.contains("<")) {
                sender = sender.substring(1, sender.length() - 1);
            }
            String content = senderAndMsg[1].replace("]", "");
            result.time = time;
            result.thread = thread;
            result.sender = sender;
            result.content = content;
            result.type = type;
        }catch (Exception ignored){}
        return result;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getThread() {
        return thread;
    }
}
