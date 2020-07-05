package net.xiaoyu233.mcfdef.compile;

import net.xiaoyu233.mcfdef.compile.managers.DefinitionManager;
import net.xiaoyu233.mcfdef.compile.managers.FunctionManager;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;
import net.xiaoyu233.mcfdef.def.Namespace;
import net.xiaoyu233.mcfdef.def.member.function.impl.ExecuteUnderFunction;
import net.xiaoyu233.mcfdef.def.member.function.impl.SysoutFunction;

public class BuiltinFunctions {
    public static void addBuiltinFunctions(Namespace namespace) throws FunctionCompileException {
        DefinitionManager definitionManager = namespace.getLocalDefinitionManager();
        MCFunctionDef systemDef = new MCFunctionDef("builtin\\System.mcfdef");
        systemDef.addFunctionDef(new SysoutFunction());
        MCFunctionDef utilDef = new MCFunctionDef("builtin\\Util.mcfdef");
        utilDef.addFunctionDef(new ExecuteUnderFunction(namespace));
        addFunctionDef(definitionManager,utilDef);
        addFunctionDef(definitionManager,systemDef);
    }

    private static void addFunctionDef(DefinitionManager definitionManager,MCFunctionDef def){
        definitionManager.addDefinition(def.getName(), def.getFileName(), def);
    }
}
