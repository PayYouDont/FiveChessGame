/**   
* @Title: Writer.java 
* @Package com.payudon.client 
* @Description: TODO(     ) 
* @author peiyongdong  
* @date 2018年9月17日 下午2:07:55 
*/
package com.payudon.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.Data;
import lombok.EqualsAndHashCode;
/** 
* @ClassName: Writer 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月17日 下午2:07:55 
*  
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class Writer extends Thread{
    private Socket socket;
    private PrintWriter printWriter;
    private String str = null;
 
    public Writer(Socket socket) throws IOException {
        this.socket = socket;
        this.printWriter = new PrintWriter(socket.getOutputStream());
 
    }
    @Override
    public void run() {
    	 printWriter.write(str + "\r\n");
         printWriter.flush();
    }
}
