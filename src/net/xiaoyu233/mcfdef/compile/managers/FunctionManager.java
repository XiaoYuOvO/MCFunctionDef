package net.xiaoyu233.mcfdef.compile.managers;

import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;

import java.util.*;

public class FunctionManager {
    private Map<String, MCFunction> fileName2func = new HashMap<>();
    private Map<String, MCFunction> name2func = new HashMap<>();
    public void addFunction(String name,String fileName,MCFunction def){
        this.fileName2func.put(fileName,def);
        this.name2func.put(name,def);
    }

    public Collection<MCFunction> getAllFunctions(){
        return name2func.values();
    }

    public MCFunction getMCFunctionDefFromName(String name){
        return name2func.get(name);
    }

    public MCFunction getMCFunctionDefFromFileName(String fileName){
        return fileName2func.get(fileName);
    }

    public MCFunction getMCFunctionDef(String fileNameOrName){
        MCFunction result = name2func.get(fileNameOrName);
        return result == null ? fileName2func.get(fileNameOrName) : result;
    }
}
