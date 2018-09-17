
package com.payudon.chess;

import javax.swing.JOptionPane;

import com.payudon.chess.gui.Game;
import com.payudon.chess.player.impl.PlayerImpl;

/** 
* @ClassName: Start 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:41:34 
*  
*/
public class Application {
	public static void main(String[] args) {
		Object[] options = { " 人机对战 ", " 联机对战 " };
		int response = JOptionPane.showOptionDialog(null, "请选择对战方式", " 选择菜单 ",
				JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (response == 0) {
			new Game(new PlayerImpl()).start();
		} else if (response == 1) {
			new Game(new PlayerImpl(),new PlayerImpl()).start();
		}
	}
}
