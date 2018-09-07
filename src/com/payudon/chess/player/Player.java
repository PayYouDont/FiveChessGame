
package com.payudon.chess.player;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.payudon.chess.gui.ChessListener;

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
	private ChessListener listener = new ChessListener();
	public Player() {
		this.listener.setFirst(isFirst());
	}
	public abstract void play();
}
