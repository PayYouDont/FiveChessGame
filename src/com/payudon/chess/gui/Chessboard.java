
package com.payudon.chess.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
* @ClassName: Chessboard 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月6日 上午11:56:09 
*  
*/
public class Chessboard extends JFrame{

	private static final long serialVersionUID = 1L;
	public static int WIDTH = 640;
	public static int HEIGHT = 660;
	public static MenuPanel menu;
	public static ChessPanel chess;
	public static JPanel main;
	public static int count = 1;
	public Chessboard() {
		setBackground(new Color(208,165,133));
		setTitle("五子棋");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = new JPanel();
		main.setBackground(new Color(208,165,133));
		main.setLayout(null);
		add(main);
		menu = new MenuPanel();
		main.add(menu);
		chess = new ChessPanel();
		chess.setName("chess");
		main.add(chess);
		// 设置界面可见
		setVisible(true);
		// Frame在窗体居中
		setLocationRelativeTo(null);
	}
	public static void hideMenu() {
		menu.setVisible(false);
	}
	public static void showMenu() {
		menu.setVisible(true);
	}
	/*public static void start(Player player) {
		Player player2 = new PlayerImpl();
		player.setOpponent(player2);
		player.setOpponent(player);
		ChessListener listerer1 = player.getListener();
		ChessListener listerer2 = player2.getListener();
		listerer1.setPanel(chess);
		listerer2.setPanel(chess);
		chess.addMouseListener(listerer1);
		chess.addMouseListener(listerer2);
	}*/
}
