package net.xiaoyu233.mcfdef.util;

import java.io.*;

public class IOUtils {
    public static void copyDir(File src, File dest) throws IOException {
        //判断源目录是不是一个目录
        if (!src.isDirectory()) {
            //如果不是目录那就不复制
            return;
        }
        //创建目标目录的File对象
        //如果目的目录不存在
        if (!dest.exists()) {
            //创建目的目录
            dest.mkdir();
        }
        //获取源目录下的File对象列表
        File[] files = src.listFiles();
        for (File file : files) {
            //拼接新的fromDir(fromFile)和toDir(toFile)的路径
            File strFrom = new File(src + File.separator + file.getName());
            File strTo = new File(dest + File.separator + file.getName());
            //判断File对象是目录还是文件
            //判断是否是目录
            if (file.isDirectory()) {
                //递归调用复制目录的方法
                copyDir(strFrom, strTo);
            }
            //判断是否是文件
            if (file.isFile()) {
                //递归调用复制文件的方法
                copyFile(strFrom, strTo);
            }
        }
    }

    public static void copyFile(File resource, File target) throws IOException {
        // 输入流 --> 从一个目标读取数据
        // 输出流 --> 向一个目标写入数据
        // 文件输入流并进行缓冲
        FileInputStream inputStream = new FileInputStream(resource);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        // 文件输出流并进行缓冲
        FileOutputStream outputStream = new FileOutputStream(target);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        // 缓冲数组
        // 大文件 可将 1024 * 2 改大一些，但是 并不是越大就越快
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        // 刷新输出缓冲流
        bufferedOutputStream.flush();
        //关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        outputStream.close();
    }

    public static void deleteDir(File dirPath) {
        if (!dirPath.isFile()) {
            File[] files = dirPath.listFiles();
            if (files != null) {
                for (File value : files) {
                    deleteDir(value.getAbsoluteFile());
                }
            }
        }
        dirPath.delete();
    }
}
