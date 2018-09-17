/**   
* @Title: Read.java 
* @Package com.payudon.client 
* @Description: TODO(     ) 
* @author peiyongdong  
* @date 2018年9月17日 下午2:08:36 
*/
package com.payudon.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: Read
 * @Description: TODO( )
 * @author peiyongdong
 * @date 2018年9月17日 下午2:08:36
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Read extends Thread {
	private Socket socket;
	private BufferedReader bufferedReader;
	private String str = null;

	public Read(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket
                .getInputStream()));
    }

	@Override
	public void run() {
		while (true) {

			try {
				str = bufferedReader.readLine();
				System.out.println(str);
			} catch (IOException e) {
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
