
package com.payudon.chess.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: Chessboard
 * @Description: TODO( )
 * @author peiyongdong
 * @date 2018年9月6日 上午11:56:09
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Chessboard extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = 640;
	public static int HEIGHT = 660;
	public ChessPanel chess;
	public JPanel main;
	public int count = 1;

	public Chessboard() {
		setBackground(new Color(208, 165, 133));
		setTitle("五子棋");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = new JPanel();
		main.setBackground(new Color(208, 165, 133));
		main.setLayout(null);
		this.add(main);
		/*
		 * MenuPanel menu = new MenuPanel(); main.add(menu);
		 */
		chess = new ChessPanel();
		chess.setName("chess");
		main.add(chess);
		// 设置界面可见
		setVisible(true);
		// Frame在窗体居中
		setLocationRelativeTo(null);
	}
}
