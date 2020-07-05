package net.xiaoyu233.mcfdef.compile.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryWalker {
    private ArrayList<File> mcfDefFiles = new ArrayList<>();
    private ArrayList<File> mcFunctionFiles = new ArrayList<>();
    private final File root;
    public DirectoryWalker(File root) throws IOException {
        this.root = root;
        System.setProperty("user.dir",root.getCanonicalPath());
    }

    public void walk(File path) throws IOException {
       walk0(path);
        String srcString = path.getCanonicalPath();
        System.setProperty("user.dir",srcString);
    }

    private void walk0(File path){
        if (path.isDirectory()){
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()){
                        walk0(file);
                    }else {
                        String name = file.getName();
                        if (name.endsWith(".mcfdef")){
                            mcfDefFiles.add(new File("." + file.getPath().replace(root.getPath(),"")));
                        }else if (name.endsWith("mcfunction")){
                            mcFunctionFiles.add(new File("." + file.getPath().replace(root.getPath(),"")));
                        }
                    }
                }
            }
        }
    }

    public ArrayList<File> getMcfDefFiles() {
        return mcfDefFiles;
    }

    public ArrayList<File> getMcFunctionFiles() {
        return mcFunctionFiles;
    }
}
