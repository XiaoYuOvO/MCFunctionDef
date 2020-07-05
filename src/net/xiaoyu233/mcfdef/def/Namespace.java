package net.xiaoyu233.mcfdef.def;

import net.xiaoyu233.mcfdef.compile.managers.DefinitionManager;
import net.xiaoyu233.mcfdef.compile.managers.FunctionManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Namespace {
    private FunctionManager localFunctionManager = new FunctionManager();
    private DefinitionManager localDefinitionManager= new DefinitionManager();
    private List<MCFunction> tickFunctions = new ArrayList<>();
    private List<MCFunction> loadFunctions = new ArrayList<>();
    private List<File> resourceFileDirs = new ArrayList<>();
    private String name;
    private File root;
    private int ifGeneratedIndex = 0;
    public Namespace(File packRoot,String name){
        this.name = name;
        this.root = new File(new File(packRoot,"data"),name);
    }

    public int getIfGeneratedIndex() {
        return ifGeneratedIndex++;
    }

    public String getName() {
        return name;
    }

    public File getFunctionDir() {
        return new File(root,"functions");
    }

    public File getNamespaceDir() {
        return root;
    }

    public void addResourceDir(File dir){
        this.resourceFileDirs.add(dir);
    }

    public List<File> getResourceFileDirs() {
        return resourceFileDirs;
    }

    public DefinitionManager getLocalDefinitionManager() {
        return localDefinitionManager;
    }

    public FunctionManager getLocalFunctionManager() {
        return localFunctionManager;
    }

    public List<MCFunction> getLoadFunctions() {
        return loadFunctions;
    }

    public List<MCFunction> getTickFunctions() {
        return tickFunctions;
    }
}
