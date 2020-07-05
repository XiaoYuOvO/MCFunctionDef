package net.xiaoyu233.mcfdef.util;

public class StringUtil {
    public static String trimQuote(String raw){
        if (raw.startsWith("\"")){
            raw = raw.substring(1);
        }
        if (raw.endsWith("\"")){
            raw = raw.substring(0,raw.length()-1);
        }
        return raw;
    }
}
