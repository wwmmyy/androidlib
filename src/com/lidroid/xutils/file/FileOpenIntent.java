package com.lidroid.xutils.file;

/**
 * 获取打开某个文件的intent
 */
import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.webkit.MimeTypeMap;

// 自定义android Intent类，

// 可用于获取打开以下文件的intent

// PDF,PPT,WORD,EXCEL,CHM,HTML,TEXT,AUDIO,VIDEO

// 示例:

// 这个不行，可能是因为PDF.apk程序没有权限访问其它APK里的asset资源文件,又或者是路径写错?

// Intent it = getPdfFileIntent("file:///android_asset/helphelp.pdf");

// 下面这些都OK

// Intent it = getHtmlFileIntent("/mnt/sdcard/tutorial.html");//SD卡主目录

// Intent it = getHtmlFileIntent("/sdcard/tutorial.html");//SD卡主目录,这样也可以

// Intent it = getHtmlFileIntent("/system/etc/tutorial.html");//系统内部的etc目录

// Intent it = getPdfFileIntent("/system/etc/helphelp.pdf");

// Intent it = getWordFileIntent("/system/etc/help.doc");

// Intent it = getExcelFileIntent("/mnt/sdcard/Book1.xls")

// Intent it = getPptFileIntent("/mnt/sdcard/download/Android_PPT.ppt");//SD卡的download目录下

// Intent it = getVideoFileIntent("/mnt/sdcard/ice.avi");

// Intent it = getAudioFileIntent("/mnt/sdcard/ren.mp3");

// Intent it = getImageFileIntent("/mnt/sdcard/images/001041580.jpg");

// Intent it = getTextFileIntent("/mnt/sdcard/hello.txt",false);

// startActivity( it );

// 资源来自：http://blog.csdn.net/baojianming88/article/details/7591368
public class FileOpenIntent {
    // android获取一个用于打开HTML文件的intent
    public static Intent getHtmlFileIntent(String param) {
        Uri uri = Uri.parse(param).buildUpon().encodedAuthority("com.android.htmlfileprovider")
                .scheme("content").encodedPath(param).build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");

        return intent;
    }

    // android获取一个用于打开图片文件的intent
    public static Intent getImageFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "image/*");

        return intent;
    }

    // android获取一个用于打开PDF文件的intent
    public static Intent getPdfFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "application/pdf");

        return intent;
    }

    // android获取一个用于打开文本文件的intent
    public static Intent getTextFileIntent(String param, boolean paramBoolean) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (paramBoolean) {
            Uri uri1 = Uri.parse(param);
            intent.setDataAndType(uri1, "text/plain");
        } else {
            Uri uri2 = Uri.fromFile(new File(param));
            intent.setDataAndType(uri2, "text/plain");
        }

        return intent;
    }

    // android获取一个用于打开音频文件的intent
    public static Intent getAudioFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "audio/*");

        return intent;
    }

    // android获取一个用于打开视频文件的intent
    public static Intent getVideoFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "video/*");

        return intent;
    }

    // android获取一个用于打开CHM文件的intent

    public static Intent getChmFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "application/x-chm");

        return intent;
    }

    // android获取一个用于打开Word文件的intent
    public static Intent getWordFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "application/msword");

        return intent;
    }

    public static Intent getDocxFileIntent(String param) {
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                MimeTypeMap.getFileExtensionFromUrl(param));

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, mimeType);// "application/vnd.ms-works");

        return intent;
    }

    // android获取一个用于打开Excel文件的intent
    public static Intent getExcelFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "application/vnd.ms-excel");

        return intent;
    }

    // android获取一个用于打开PPT文件的intent
    public static Intent getPptFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");

        return intent;
    }

    public static Intent getCADFileIntent(String param) {
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                MimeTypeMap.getFileExtensionFromUrl(param));

        //application/autocad.dwg, application/dwg, application/x-invisox, image/dwg, image/vnd.dwg, vector/x-dwg

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Uri uri = Uri.fromFile(new File(param));
        //		intent.setDataAndType(uri, mimeType);
        intent.setDataAndType(uri, "application/x-autocad");
        //		intent.setDataAndType(uri, "application/autocad.dwg");
        //		intent.setDataAndType(uri, "application/dwg");
        //		intent.setDataAndType(uri, "application/x-invisox");
        //		intent.setDataAndType(uri, "image/dwg");
        //		intent.setDataAndType(uri, "image/vnd.dwg");
        //		intent.setDataAndType(uri, "vector/x-dwg");

        return intent;
    }
}
