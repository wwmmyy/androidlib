package com.lidroid.xutils.file;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;
/**
 * 连接网络并获取服务器返回信息
 *  
 *
 */
public class FileUtils { 


    //获取文件格式名称
    public static String getFileType(String url) {
        int i = url.lastIndexOf(".");
        return url.substring(i + 1);
    }

    //获取文件格式名称
    static String getFileName(String url) {
        int i = url.lastIndexOf("/");
        return url.substring(i + 1);
    } 
    /**
     * 根据文件类型打开文件
     */
    public static  boolean OpenFile(Context context, String fileName, String filetype) {
        try {
            if (filetype.equalsIgnoreCase("xls")) {
                Intent it = FileOpenIntent.getExcelFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("dwg")) {
                Intent it = FileOpenIntent.getCADFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("doc")) {
                Intent it = FileOpenIntent.getWordFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("docx")) {
                Intent it = FileOpenIntent.getDocxFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("pdf")) {
                Intent it = FileOpenIntent.getPdfFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("bmp") || filetype.equalsIgnoreCase("jpg")
                    || filetype.equalsIgnoreCase("jpeg") || filetype.equalsIgnoreCase("gif")
                    || filetype.equalsIgnoreCase("png")) {
                Intent it = FileOpenIntent.getImageFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("html")) {
                Intent it = FileOpenIntent.getHtmlFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("txt")) {
                Intent it = FileOpenIntent.getTextFileIntent(fileName, false);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("mp3")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("wma")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("wav")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("ppt")) {
                Intent it = FileOpenIntent.getPptFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("pptx")) {
                Intent it = FileOpenIntent.getPptFileIntent(fileName);
                context.startActivity(it);
            } else {
                Looper.prepare();
                Toast.makeText(context, "暂时找不到打开该文件格式的程序", 1).show();
                Looper.loop();
                return false;
            }
            return true;
        } catch (Exception e) {
            Looper.prepare();
            Toast.makeText(context, "程序异常，暂时找不到打开该文件格式的程序", 1).show();
            Looper.loop();
            return false;
        }
    }
    
    /**
     * 系统退出时删除打开的缓存文件
     */
    public static void deleteTempFile(String filepath) {
        File dir = new File(filepath);
        if (dir.exists()) {

            File[] files = dir.listFiles();
            try {
                for (File file3 : files) {
                    boolean flag = file3.delete();
                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     * 根据文件类型打开文件
     */
    public static  boolean OpenWebFile(Context context, String fileName, String filetype) {
        try {
            if (filetype.equalsIgnoreCase("xls")) {
                Intent it = FileOpenIntent.getExcelFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("dwg")) {
                Intent it = FileOpenIntent.getCADFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("doc")) {
                Intent it = FileOpenIntent.getWordFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("docx")) {
                Intent it = FileOpenIntent.getDocxFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("pdf")) {
                Intent it = FileOpenIntent.getPdfFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("bmp") || filetype.equalsIgnoreCase("jpg")
                    || filetype.equalsIgnoreCase("jpeg") || filetype.equalsIgnoreCase("gif")
                    || filetype.equalsIgnoreCase("png")) {
                Intent it = FileOpenIntent.getImageFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("html")) {
                Intent it = FileOpenIntent.getHtmlFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("txt")) {
                Intent it = FileOpenIntent.getTextFileIntent(fileName, false);
                context.startActivity(it);
            }else if (filetype.equalsIgnoreCase("mp4")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("mp3")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("wma")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("wav")) {
                Intent it = FileOpenIntent.getAudioFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("ppt")) {
                Intent it = FileOpenIntent.getPptFileIntent(fileName);
                context.startActivity(it);
            } else if (filetype.equalsIgnoreCase("pptx")) {
                Intent it = FileOpenIntent.getPptFileIntent(fileName);
                context.startActivity(it);
            } else {
//                Looper.prepare();
                Toast.makeText(context, "暂时找不到打开该文件格式的程序", 1).show();
//                Looper.loop();
                return false;
            }
            return true;
        } catch (Exception e) {
//            Looper.prepare();
            Toast.makeText(context, "程序异常，暂时找不到打开该文件格式的程序", 1).show();
//            Looper.loop();
            return false;
        }
    }
    
    
    
    
    
    

}
