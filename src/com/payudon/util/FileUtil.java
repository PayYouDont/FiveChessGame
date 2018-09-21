package com.payudon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;


public class FileUtil {
	public static String read(InputStream in) {
		byte[] b = new byte[1024];
        String str = "";
    	try {
    		while(in.read(b)!=-1) {
    			str += in.read(b);
            }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return str;
	}
	
	public static void out(String msg,OutputStream out) {
		try {
			out.write(msg.getBytes(), 0, msg.getBytes().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String writeString(String msg,String path) {
		PrintWriter out = null;
		File file = new File(path);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			out = new PrintWriter(file);
			out.write(msg);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null) {
				out.close();
			}
		}
		return file.getAbsolutePath();
	}
	public static String copyFile(InputStream in,String outPaht,String fileName) {
		File file = new File(outPaht);
		if(!file.exists()) {
			file.mkdirs();
		}
		File outFile = new File(outPaht+File.separatorChar+fileName);
		try {
			wirteFile(in, new FileOutputStream(outFile));
	        System.out.println("写出文件完毕!路径:"+outFile.getPath());
	        return outFile.getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void copyFile(String inPath,String outPaht,String fileName) {
		 File file = new File(inPath);
		 File outFile = new File(outPaht+File.separatorChar+fileName);
		 try {
			InputStream in = new FileInputStream(file);
			wirteFile(in, new FileOutputStream(outFile));
		} catch (IOException e) {
		}
	}
	public static void wirteFile(InputStream in,OutputStream out) {
		byte[] b = new byte[1024];
        int len = 0;
        try {
        	 while((len=in.read(b))!=-1) {
             	out.write(b, 0, len);
             }
        	 out.flush();
        }catch(IOException e) {
        	System.out.println("复制文件出错："+e);
        }finally {
            try {
            	if(out!=null) {
    				out.close();
            	}
            	if(in!=null) {
    	            in.close();
            	}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
       
	}
}
