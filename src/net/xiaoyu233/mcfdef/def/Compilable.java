package net.xiaoyu233.mcfdef.def;

import java.util.ArrayList;
import java.util.List;

public interface Compilable {
    void addFuncDefUse(MCFunctionDef def);
    String getName();
    String getFileName();
    List<String> getUsedFunctionDefString();

    ArrayList<MCFunctionDef> getUsedFunctionDefs();
}
