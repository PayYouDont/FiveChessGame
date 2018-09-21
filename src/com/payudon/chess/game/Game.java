
package com.payudon.chess.game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.payudon.chess.Application;
import com.payudon.chess.gui.Chessboard;
import com.payudon.chess.player.Player;
import com.payudon.chess.player.impl.ComputerPlayer;
import com.payudon.chess.player.impl.PlayerImpl;
import com.payudon.client.GameClient;
import com.payudon.util.ChessUtil;
import com.payudon.util.IPutil;
import com.payudon.util.StringUtil;

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
	private Player player;
	private Player player2;
	public static Chessboard chessBoard;
	public static List<Point> points;
	private int mode = 0;
	public Game() {
		chessBoard = new Chessboard();
		points = new ArrayList<>();
	}
	public void start() {
		if(mode==0) {
			PVE();
		}else {
			PVP();
		}
	}
	public void PVE() {
		player = new PlayerImpl();
		player2 = new ComputerPlayer();
		player.setPlay(false);
		player2.setPlay(true);
		player.setFirst(false);
		player2.setFirst(true);
		player.play(chessBoard);
		player2.play(chessBoard);
	}
	public void PVP() {
		if(player==null) {
			String ip="";
			try {
				ip = IPutil.getLocalHostLANAddress().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String nick = StringUtil.getUUID();
			player = new PlayerImpl(nick, ip);
			update(player);
		}
	}
	public void next() {
		if(player2 instanceof ComputerPlayer) {
			player2.setPlay(true);
		}else {
			update(player);
		}
	}
	public void update(Player player) {
		Gamer gamer = GameClient.matchPlayer(player);
		if(this.player.equals(gamer.getPlayer1())) {
			this.player = gamer.getPlayer1();
			this.player2 = gamer.getPlayer2();
		}else {
			this.player = gamer.getPlayer2();
			this.player2 = gamer.getPlayer1();
		}
		if(gamer.isBegin()) {
			setGameMsg();
		}
		this.player.play(chessBoard);
		((PlayerImpl)player2).playOnlie(chessBoard);
	
	}
	public void setGameMsg() {
		String msg = "您是先手，黑棋";
		if(!this.player.isPlay()) {
			msg = "您是后手，白棋";
			update(player);
		}
		JOptionPane.showMessageDialog(null,msg);
	}
	public void dispose() {
		if(chessBoard!=null) {
			chessBoard.dispose();
		}
		if(player2 instanceof ComputerPlayer) {
			((ComputerPlayer) player2).dispose();
		}
		points = null;
		player2 = null;
	}
	public boolean isExist(Point point) {
		return ChessUtil.isExist(point,points);
	}
	public boolean isWin(Player player) {
		String msg = "you win";
		if(ChessUtil.checkWin(player.getPoint(), player)) {
			if(player.equals(player2)) {
				msg = "you lost";
			}
			JOptionPane.showMessageDialog(null,msg);
			Application.start();
			return true;
		}
		return false;
	}
}
