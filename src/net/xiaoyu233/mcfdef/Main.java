package net.xiaoyu233.mcfdef;

import net.xiaoyu233.mcfdef.compile.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FunctionCompileException {
        boolean genProject = false;
        String first = args[0];
        if (first.equals("--genProject")){
            genProject = true;
        }else {
            if (!first.equals("--build")) {
                throw new IllegalArgumentException("Must specific --build or --genProject at first");
            }
        }
        if (genProject){
            File projectDir = null,outDir = null;
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                if (arg.equals("--genProject")){
                    projectDir = new File(args[i+1]);
                }
                if (arg.equals("--outDir")){
                    outDir = new File(args[i+1]);
                }
            }
            if (outDir == null){
                throw new IllegalArgumentException("Must specific out dir.Usage: --genProject [Project Dir] --outDir [Output Dir]");
            }
            if (!projectDir.exists()){
                throw new IllegalArgumentException("Cannot find dir:" +  projectDir.getPath());
            }
            MCFDefProject project = new MCFDefProject(projectDir,outDir);
            File outputProject = new File(projectDir,"mcfdef.json");
            project.setCompileArgs("pend_if","newFile");
            project.setCompileArgs("pend_function","defFirst");
            project.setCompilerVersion(MCFDefCompiler.COMPILER_VERSION_NUM);
            project.serialize(outputProject);
            System.out.println("MCFDef project generated to " + outputProject.getAbsolutePath());
        }else {
            if (args.length<2){
                throw new IllegalArgumentException("Must specific project file.Usage: --build [Project File(json file)]");
            }
            String projectFileStr = args[1];
            File projectFile = new File(projectFileStr);
            if (!projectFile.exists()){
                throw new IllegalArgumentException("Cannot find project file:" + projectFileStr);
            }
            MCFDefCompiler compiler = new MCFDefCompiler(MCFDefProject.deserialize(projectFile));
            compiler.compile();
        }

    }

}
