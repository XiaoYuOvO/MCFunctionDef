package net.xiaoyu233.mcfdef.compile.handler;

import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;

import java.io.File;
import java.util.List;

public interface CompilationStatsHandler {
    void onStartCompileNamespace(List<File> toCompileFunctions, List<File> toCompileDefs, String src);
    void onFunctionCompiled(MCFunction function);
    void onFunctionDefCompiled(MCFunctionDef functionDef);
    void onFunctionParsed(MCFunction function);
    void onFunctionDefParsed(MCFunctionDef functionDef);
    void onCompileFinished();
    void onFunctionFileWrote(File functionFile);
}
