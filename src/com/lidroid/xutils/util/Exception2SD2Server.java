package com.lidroid.xutils.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import android.os.Environment;

import com.lidroid.xutils.file.FormFile;
import com.lidroid.xutils.file.SocketHttpRequester;

/**
 * 将app异常信息保存到SD卡上，同时上传到服务器上去
* @类名: Exception2SD2Server 
* @描述: TODO 
* @作者: 王明远 
* @日期: 2015年10月26日 下午1:42:39 
* @修改人: 
 * @修改时间: 
 * @修改内容:
 * @版本: V1.0
 * @版权:Copyright ©  All rights reserved.
 */
public class Exception2SD2Server {
    /**
  　　*将错误日志文件保存到sd卡 
  　　* @param toSaveString
  　　* @param filePath 
    * @throws Exception */
    public static void saveErrorFile(String uploadFileURL,Throwable e,String errorname){
        try {
         Writer info = new StringWriter();
         PrintWriter printWriter = new PrintWriter(info);
         e.printStackTrace(printWriter);
         Throwable cause = e.getCause();
         while (cause != null) {
             cause.printStackTrace(printWriter);
             cause = cause.getCause();
         }
         String toSaveString = info.toString();
         printWriter.close();
         if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
             InputStream is = StringTOInputStream(toSaveString);
             File dir = new File("/mnt/sdcard/");
             if (dir.exists() == false) {
                 boolean b = dir.mkdirs();
             }

             File file = new File("/mnt/sdcard/", errorname);
             FileOutputStream fos = new FileOutputStream(file);
             //           fos.write(toSaveString.getBytes());
             //           fos.close();

             byte[] buffer = new byte[1024];
             int len = 0;
             while ((len = is.read(buffer)) != -1) {
                 fos.write(buffer, 0, len);
             }
             fos.flush();
             fos.close();
             is.close(); 
              
             fileUp2Server(uploadFileURL ,"/mnt/sdcard/"+errorname);
         }
     } catch (Exception e2) {
         // TODO: handle exception
         e.printStackTrace();
     }
    }  
    
    
    /**
     * @T itle: sendToServer
     * @Description: 附件资料上传到服务器
     * @param
     * @return void  /image/filesUpload
     * @throws
     * 
     */ 
    public static void fileUp2Server(String uploadFileURL ,final String filePath ) { 
        if(uploadFileURL==null){
            uploadFileURL="http://58.246.138.178:8000/DistMobile/image/exceptfilesUpload";
            }
        final String uploadFileURL2=uploadFileURL;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() { 
                //请求普通信息
                Map<String, String> params = new HashMap<String, String>(); 
                    try {
                        
                      FormFile[] formfiles = new FormFile[1];  
                              File tempfile = new File(filePath); 
//                              SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                              String nowTime=format.format(new Date(System.currentTimeMillis()));  
//                              nowTime.replaceAll(" ", "").replaceAll(":", "：")+ 
                              params.put("fileName",tempfile.getName());
                              formfiles[0] = new FormFile(tempfile.getName(), tempfile, "files",
                                      "application/octet-stream"); 
 
                          boolean result = SocketHttpRequester
                                  .post(uploadFileURL2, params, formfiles);
                         
                    } catch (Exception e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    }
//                } 
            }
        });
        t.start();
    }
    
    
    
    
    public static InputStream StringTOInputStream(String in) throws Exception{          
        ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("UTF-8"));  
        return is;  
    };
}
