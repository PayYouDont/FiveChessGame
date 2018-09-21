
package com.payudon.util;

import java.awt.Point;
import java.util.List;

import com.payudon.chess.gui.ChessPanel;
import com.payudon.chess.player.Player;

/** 
* @ClassName: ChessUtil 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月14日 下午4:48:02 
*  
*/
public class ChessUtil {
	
	public static boolean checkWin(Point point,Player player) {
		List<Point> points = player.getChess();
		int x = (int)point.getX();
		int y = (int)point.getY();
		int grade = ChessPanel.grade;
		int sum = 1;
		switch (0) {
		case 0://←→方向
			for(int i=0;i<5;i++) {
				sum = 1;
				for (int j = 1; j <5;j++) {
					int x1;
					if(j>i) {
						x1 = x - grade*(j-i);
					}else {
						x1 = x + grade*(i-j+1);
					}
					if(x1>580||x1<20) {
						continue;
					}
					Point p = new Point(x1, y);
					if(isExist(p, points)) {
						sum++;
					}
				}
				if(sum>4) {
					return true;
				}
			}
		case 1://↑↓方向
			for(int i=0;i<5;i++) {
				sum = 1;
				for (int j = 1; j <5;j++) {
					int y1;
					if(j>i) {
						y1 = y - grade*(j-i);
					}else {
						y1 = y + grade*(i-j+1);
					}
					if(y1<20||y1>580) {
						continue;
					}
					Point p = new Point(x, y1);
					if(isExist(p, points)) {
						sum++;
					}
				}
				if(sum>4) {
					return true;
				}
			}
		case 2://↖↘方向
			for(int i=0;i<5;i++) {
				sum = 1;
				for (int j = 1; j <5;j++) {
					int x1,y1;
					if(j>i) {
						x1 = x - grade*(j-i);
						y1 = y - grade*(j-i);
					}else {
						x1 = x + grade*(i-j+1);
						y1 = y + grade*(i-j+1);
					}
					if(x1<20||x1>580||y1<20||y1>580) {
						continue;
					}
					Point p = new Point(x1, y1);
					if(isExist(p, points)) {
						sum++;
					}
				}
				if(sum>4) {
					return true;
				}
			}
		case 3://↗↙方向
			for(int i=0;i<5;i++) {
				sum = 1;
				for (int j = 1; j <5;j++) {
					int x1,y1;
					if(j>i) {
						x1 = x + grade*(j-i);
						y1 = y - grade*(j-i);
					}else {
						x1 = x - grade*(i-j+1);
						y1 = y + grade*(i-j+1);
					}
					if(x1<20||x1>580||y1<20||y1>580) {
						continue;
					}
					Point p = new Point(x1, y1);
					if(isExist(p, points)) {
						sum++;
					}
				}
				if(sum>4) {
					return true;
				}
			}
			break;
		}
		return false;
	}
	public static boolean isExist(Point point,List<Point> points) {
		for (Point p : points) {
			if(p.equals(point)) {
				return true;
			}
		}
		return false;
	}
}
