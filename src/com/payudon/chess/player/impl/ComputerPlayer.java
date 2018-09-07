
package com.payudon.chess.player.impl;

import java.awt.Point;

import com.payudon.chess.gui.Chessboard;
import com.payudon.chess.player.Player;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
* @ClassName: ComputerPlayer 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:36:19 
*  
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class ComputerPlayer extends Player{

	private int weights;//权重
	public static final int WEIGHT_Lv1 = 1;
	public static final int WEIGHT_Lv2 = 2;
	public static final int WEIGHT_Lv3 = 3;
	public static final int WEIGHT_Lv4 = 4;
	public static final int WEIGHT_Lv5 = 5;
	/** 
	 * <p>Title: play</p> 
	 * <p>Description: </p>  
	 * @see com.payudon.chess.player.Player#play() 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月7日 下午2:44:07
	 */
	@Override
	public void play() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					if(!isPlay()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						Point point = getPoint();
						getChess().add(point);
						Chessboard.chess.paintChess(point,isFirst());
						setPlay(false);
						getOpponent().setPlay(true);
					}
					
				}
			}
		}).start();
	}
	public Point getPoint() {
		return new Point(20,20);
	}
	public boolean hasLv5() {
		
		return false;
	}
}
