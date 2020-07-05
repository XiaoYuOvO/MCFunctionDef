package net.xiaoyu233.mcfdef.compile;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.xiaoyu233.mcfdef.compile.managers.FunctionManager;
import net.xiaoyu233.mcfdef.def.Namespace;
import sun.jvm.hotspot.utilities.BitMap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MCFDefProject {
    public int compilerVersion;
    public File outDir;
    public File srcDir;
    private boolean deleteOldFiles;
    public Map<String,String> compileArgs = new HashMap<>();
    public MCFDefProject(File srcDir,File outDir){
        this.srcDir = srcDir;
        this.outDir = outDir;
    }
    public static MCFDefProject deserialize(File projectFile) throws IOException {
        Reader reader = new FileReader(projectFile);
        MCFDefProject project = new Gson().fromJson(reader,(new TypeToken<MCFDefProject>(){}).getType());
        reader.close();
        project.deleteOldFiles = Boolean.parseBoolean(project.compileArgs.get("deleteOldFiles"));
        return project;
    }

    public boolean isDeleteOldFiles() {
        return deleteOldFiles;
    }

    public void setCompilerVersion(int compilerVersion) {
        this.compilerVersion = compilerVersion;
    }

    public int getCompilerVersion() {
        return compilerVersion;
    }

    public File getOutDir() {
        return outDir;
    }

    public File getSrcDir() {
        return srcDir;
    }

    public void setCompileArgs(String key,String value) {
        if (compileArgs.containsKey(key)) {

            this.compileArgs.replace(key,value);
        }else {
            this.compileArgs.put(key,value);
        }
    }

    public String getCompileArg(String key){
        return this.compileArgs.get(key);
    }

    public void serialize(File out) throws IOException {
        if (!out.getParentFile().exists()) if (!out.getParentFile().mkdirs()) throw new IOException("Cannot create dir: " + out.getParentFile().getAbsolutePath());
        if (!out.exists()) if (!out.createNewFile()) throw new IOException("Cannot create file: " + out.getAbsolutePath());
        FileWriter fileWriter = new FileWriter(out);
        new Gson().newBuilder().setPrettyPrinting().create().toJson(this,(new TypeToken<MCFDefProject>(){}).getType(),fileWriter);
        fileWriter.close();
    }
}
