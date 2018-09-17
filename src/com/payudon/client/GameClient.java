
package com.payudon.client;

import java.io.IOException;
import java.net.Socket;

/** 
* @ClassName: GameClient 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月17日 下午2:06:52 
*  
*/
public class GameClient {
	public static Object obj = new Object();
    // 与服务器连通地址本机（127.0.0.1），局域网中其他机器是（服务器在局域网中的ip地址） 端口都是8888
    public static void start() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        if (socket.isConnected()) {
            // 如果连接成功了就开启写和读的进程
            new Writer(socket).start();
            new Read(socket).start();
        } else {
            System.out.println("服务器未开启");
        }
    }
    public static void main(String[] args) {
    	try {
			GameClient.start();
		} catch (IOException e) {
		}
	}
}
