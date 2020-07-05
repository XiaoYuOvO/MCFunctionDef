package net.xiaoyu233.mcfdef.def;

import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MCFunction implements Compilable{
    private boolean isCompiled = false;
    private ArrayList<MCFunctionDef> usedFunctionDefs = new ArrayList<>();
    private ArrayList<String> usedFunctionDefString = new ArrayList<>();
    private String name;
    private String fileName;
    private String callName;
    private LinkedList<Instruction> content = new LinkedList<>();
    private boolean isExecPerTick;
    private boolean isExecOnLoad;
    public boolean isCompiled() {
        return isCompiled;
    }

    public void setCompiled(boolean compiled) {
        isCompiled = compiled;
    }


    public void setExecOnLoad(boolean execOnLoad) {
        isExecOnLoad = execOnLoad;
    }

    public void setExecPerTick(boolean execPerTick) {
        isExecPerTick = execPerTick;
    }

    public boolean isExecOnLoad() {
        return isExecOnLoad;
    }

    public boolean isExecPerTick() {
        return isExecPerTick;
    }
    public MCFunction(String fileName){
        if (fileName.startsWith(".\\")){
            fileName = fileName.substring(2);
        }
        fileName = fileName.replace("\\","/");
        this.fileName = fileName;
        this.name = fileName.substring(fileName.lastIndexOf("\\") + 1,fileName.lastIndexOf("."));
        this.callName = fileName.substring(0,fileName.lastIndexOf("."));
        if (!callName.equals(callName.toLowerCase())){
            throw new FunctionCompileException("Function path cannot contains Caps letter",this);
        }
    }

    public String getCallName() {
        return callName;
    }

    public void addIfStatement(IfStatement ifStatement) {
        content.add(ifStatement);
    }
    public void addCommand(Command command){
        content.add(command);
    }

    public void addFuncDefUse(MCFunctionDef functionDef){
        this.usedFunctionDefs.add(functionDef);
    }

    public void addFuncDefUseString(String functionDef){
        this.usedFunctionDefString.add(functionDef);
    }

    public LinkedList<Instruction> getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getUsedFunctionDefString() {
        return usedFunctionDefString;
    }

    public ArrayList<MCFunctionDef> getUsedFunctionDefs() {
        return usedFunctionDefs;
    }

    public void addFunctionUsage(Instruction usage){
        this.content.add(usage);
    }

    public String getFileName() {
        return fileName;
    }
}
