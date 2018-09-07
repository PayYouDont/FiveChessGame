
package com.payudon.chess.player.impl;

import java.awt.Point;
import java.util.List;

import com.payudon.chess.gui.ChessPanel;
import com.payudon.chess.gui.Chessboard;
import com.payudon.chess.player.Player;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

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
	@Setter
	private Point point;
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
		return this.point;
	}
	public boolean hasLv5() {
		List<Point> chess = getChess();
		if(chess.size()<4) {
			return false;
		}
		for (Point point : chess) {
			
		}
		return false;
	}
	public void checkNearPoint(Point point,Point[] chess) {
		int x = (int)point.getX();
		int y = (int)point.getY();
		int grade = ChessPanel.grade;
		int x1 = x + grade>580?580:x + grade;
		int x2 = x - grade<20?20:x + grade;
		int y1 = y + grade>580?580:x + grade;;
		int y2 = y - grade<20?20:x + grade;
		for(int i=0;i<chess.length;i++) {
			Point p = chess[i];
			if(p.equals(point)) {
				continue;
			}else {
				if(p.getX()<x1&&p.getX()>x2&&p.getY()<y1&&p.getY()>y2) {
					
				}
			}
		}
	}
}
