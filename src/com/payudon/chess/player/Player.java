
package com.payudon.chess.player;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.payudon.chess.Application;
import com.payudon.chess.gui.Chessboard;

import lombok.Data;

/** 
* @ClassName: Player1 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:36:50 
*  
*/
@Data
public abstract class Player implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer score;
	private boolean isPlay;
	private boolean isFirst;
	@JSONField(serialize=false)
	private List<Point> chess = new ArrayList<>();
	private Point point;
	public abstract void play(Chessboard board);
	public boolean isWin() {
		if(point==null) {
			return false;
		}
		return Application.GAME.isWin(this);
	}
}
