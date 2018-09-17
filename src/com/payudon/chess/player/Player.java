
package com.payudon.chess.player;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.payudon.chess.gui.Chessboard;
import com.payudon.chess.util.ChessUtil;

import lombok.Data;

/** 
* @ClassName: Player1 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:36:50 
*  
*/
@Data
public abstract class Player {
	private Integer id;
	private Integer score;
	private boolean isPlay;
	private boolean isFirst;
	private List<Point> chess = new ArrayList<>();
	private Player opponent;//对手
	private boolean isWin;
	private Chessboard board;
	public abstract void play();
	public boolean isExist(Point point) {
		if(ChessUtil.isExist(point,getChess())) {
			return true;
		}
		if(ChessUtil.isExist(point,getOpponent().getChess())) {
			return true;
		}
		return false;
	}
	public boolean isWin(Point point) {
		if(ChessUtil.checkWin(point, this)) {
			JOptionPane.showMessageDialog(null,"you win");
			return true;
		}
		return false;
	}
}
