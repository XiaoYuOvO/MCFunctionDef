package net.xiaoyu233.mcfdef.compile.managers;

import com.sun.istack.internal.NotNull;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefinitionManager {
    private final Map<String, MCFunctionDef> fileName2Def = new HashMap<>();
    private final Map<String, MCFunctionDef> name2Def = new HashMap<>();
    public void addDefinition(String name,String fileName,MCFunctionDef def){
        this.fileName2Def.put(fileName,def);
        this.name2Def.put(name,def);
    }

    public MCFunctionDef getMCFunctionDef(String fileNameOrName){
        MCFunctionDef result = name2Def.get(fileNameOrName);
        return result == null ? fileName2Def.get(fileNameOrName) : result;
    }

    public void merge(DefinitionManager manager){
           this.fileName2Def.putAll(manager.fileName2Def);
           this.name2Def.putAll(manager.name2Def);
    }

    public Collection<MCFunctionDef> getAllDef(){
        return fileName2Def.values();
    }
}
