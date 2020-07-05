package net.xiaoyu233.mcfdef.compile.io;

import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FunctionWriter {
    public static void writeToFile(File target, MCFunction function) throws IOException {
        if (!target.getParentFile().exists()) {
            if (!target.getParentFile().mkdirs()) throw new IOException("Cannot create the dir: " + target.getParent());
        }
        if (!target.exists()){
            if (!target.createNewFile()) throw new IOException("Cannot create the file: " + target.getAbsolutePath());
        }
        try (FileWriter writer = new FileWriter(target)) {
            for (Instruction instruction : function.getContent()) {
                writer.write(instruction.getRaw());
                writer.write("\n");
            }
        };
    }
}
