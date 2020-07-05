package net.xiaoyu233.mcfdef.def;

import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import net.xiaoyu233.mcfdef.def.member.function.FunctionToken;
import net.xiaoyu233.mcfdef.def.member.function.IFunction;

import java.util.*;

public class MCFunctionDef implements Compilable{
    private final ArrayList<FunctionToken> definedFunctionTokens = new ArrayList<>();
    private final ArrayList<String> usedFunctionDefStr = new ArrayList<>();
    private final ArrayList<MCFunctionDef> usedFunctionDef = new ArrayList<>();
    private final Map<FunctionToken,IFunction> definedFunctionDefs = new HashMap<>();
    private final String name;
    private final String fileName;
    private boolean isGlobal;
    public MCFunctionDef(String fileName){
        if (fileName.startsWith(".\\")){
            fileName = fileName.substring(2);
        }
        this.fileName = fileName;
        this.name = fileName.substring(fileName.lastIndexOf("\\") + 1,fileName.lastIndexOf("."));
        this.usedFunctionDef.add(this);
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }

    @Override
    public void addFuncDefUse(MCFunctionDef def) {
        this.usedFunctionDef.add(def);
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public List<String> getUsedFunctionDefString() {
        return this.usedFunctionDefStr;
    }

    public IFunction getDefinedFunction(FunctionToken token){
        return definedFunctionDefs.get(token);
    }

    public Collection<IFunction> getAllDefinedFunction() {
        return definedFunctionDefs.values();
    }

    public void addMCFunctionDefUse(String mcf){
        this.usedFunctionDefStr.add(mcf);
    }

    public ArrayList<MCFunctionDef> getUsedFunctionDefs() {
        return usedFunctionDef;
    }

    public void addFunctionDef(IFunction functionDef) throws FunctionCompileException {
        FunctionToken token = functionDef.getToken();
        if (!definedFunctionTokens.contains(token)){
            definedFunctionTokens.add(token);
            this.definedFunctionDefs.put(token,functionDef);
        }else {
            throw new FunctionCompileException("Target function has been defined:" + token.toString(),this);
        }
    }
}
