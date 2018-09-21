
package com.payudon.chess.game;

import java.awt.Point;
import java.util.List;

import com.payudon.chess.player.Player;
import com.payudon.chess.player.impl.PlayerImpl;
import com.payudon.util.JsonUtil;

import lombok.Data;

/** 
* @ClassName: Gamer 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月20日 下午5:51:17 
*  
*/
@Data
public class Gamer {
	private boolean begin;
	private int count;
	private Player1 player1;
	private Player2 player2;

	@Data
	public static class Player1 {
		private Integer id;
		private Integer score;
		private boolean isPlay;
		private boolean isFirst;
		private List<Point> chess;
		private Point point;
		private boolean isWin;
		private String nick;
		private String ip;
	}

	@Data
	public static class Player2 {
		private Integer id;
		private Integer score;
		private boolean isPlay;
		private boolean isFirst;
		private List<Point> chess;
		private Point point;
		private boolean isWin;
		private String nick;
		private String ip;
	}
	public Player getPlayer1() {
		String json = JsonUtil.toJson(this.player1);
		PlayerImpl player = JsonUtil.parseObject(json, PlayerImpl.class);
		return player;
	}
	public Player getPlayer2() {
		String json = JsonUtil.toJson(this.player2);
		PlayerImpl player = JsonUtil.parseObject(json, PlayerImpl.class);
		return player;
	}
}
