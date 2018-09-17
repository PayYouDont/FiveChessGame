
package com.payudon.chess.gui;

import com.payudon.chess.player.Player;
import com.payudon.chess.player.impl.ComputerPlayer;

import lombok.Data;

/** 
* @ClassName: MenuPanel 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:43:11 
*  
*/
@Data
public class Game{
	private Player player1;
	private Player player2;
	public Game(Player player) {
		this.player1 = player;
		player2 = new ComputerPlayer();
	}
	public Game(Player player1,Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	private void setPlay(Player player1,Player player2) {
		player1.setOpponent(player2);
		player2.setOpponent(player1);
		player1.setPlay(true);
		player2.setPlay(false);
		player1.setFirst(true);
		player2.setFirst(false);
		player1.play();
		player2.play();
	}
	public void start() {
		setPlay(getPlayer1(), getPlayer2());
	}
}
