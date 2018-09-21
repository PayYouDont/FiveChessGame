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
public class Writer{
    private Socket socket;
    private PrintWriter printWriter;
    private String str = null;
    public Writer(Socket socket) throws IOException {
        this.socket = socket;
        this.printWriter = new PrintWriter(socket.getOutputStream());
 
    }
    public void write(String msg) {
    	printWriter.write(msg + "\r\n");
        printWriter.flush();
    }
}
