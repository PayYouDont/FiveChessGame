
package com.payudon.chess.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.payudon.chess.player.Player;
import com.payudon.chess.player.impl.ComputerPlayer;
import com.payudon.chess.player.impl.PlayerImpl;

/** 
* @ClassName: MenuPanel 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:43:11 
*  
*/
public class MenuPanel extends JPanel{
	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	public MenuPanel() {
		setLayout(null);
		setBounds(150, 280, 340, 100);
		setBackground(new Color(255,255,255,200));
		setButton1();
		setButton2();
		//show();
	}
	public void setButton1() {
		JButton button = new JButton("人机对战");
		button.setBackground(new Color(208,165,133));
		button.setBounds(120, 10, 100, 35);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chessboard.hideMenu();
				Player player1 = new ComputerPlayer();
				Player player2 = new PlayerImpl();
				player1.setId(1);
				player2.setId(2);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				player1.setPlay(true);
				player2.setPlay(false);
				player1.setFirst(true);
				player2.setFirst(false);
				player1.play();
				player2.play();
			}
		});
		this.add(button);
	}
	public void setButton2() {
		JButton button = new JButton("联机对战");
		button.setBounds(120, 55, 100, 35);
		button.setBackground(new Color(208,165,133));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chessboard.hideMenu();
				Player player1 = new PlayerImpl();
				Player player2 = new PlayerImpl();
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				player1.setPlay(true);
				player2.setPlay(false);
				player1.setFirst(true);
				player2.setFirst(false);
				player1.play();
				player2.play();
			}
		});
		this.add(button);
	}
}
