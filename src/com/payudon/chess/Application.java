
package com.payudon.chess;

import javax.swing.JOptionPane;

import com.payudon.chess.game.Game;

/** 
* @ClassName: Start 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:41:34 
*  
*/
public class Application {
	public static Game GAME;
	public static void main(String[] args) {
		start();
	}
	public static void start() {
		if(GAME!=null) {
			GAME.dispose();
		}
		GAME = new Game();
		Object[] options = { " 人机对战 ", " 联机对战 " };
		int mode = JOptionPane.showOptionDialog(null, "请选择对战方式", " 选择菜单 ",
				JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if(mode==-1) {
			GAME.dispose();
			return;
		}
		GAME.setMode(mode);
		GAME.start();
	}
}
