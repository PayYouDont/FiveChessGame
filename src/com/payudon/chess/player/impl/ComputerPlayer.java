
package com.payudon.chess.player.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.payudon.chess.gui.ChessPanel;
import com.payudon.chess.player.Player;
import com.payudon.chess.util.ChessUtil;

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

	private int weight;//权重
	public static final int WEIGHT_Lv1 = 1;
	public static final int WEIGHT_Lv2 = 2;
	public static final int WEIGHT_Lv3 = 3;
	public static final int WEIGHT_Lv4 = 4;
	public static final int WEIGHT_Lv5 = 5;
	public static final Integer horizontal = 0;//横方向（-）
	public static final Integer vertical = 1;//竖方向（|）
	public static final Integer left_falling = 2;//撇方向（/）
	public static final Integer right_falling = 3;//捺方向（\）
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
						next();
						Point point = getPoint();
						getChess().add(point);
						getOpponent().getBoard().getChess().paintChess(point,isFirst());
						setPlay(false);
						getOpponent().setPlay(true);
					}
					
				}
			}
		}).start();
	}
	public void next() {
		if(hasNext(WEIGHT_Lv5)) {
			return;
		}
		if(hasNext(WEIGHT_Lv4)) {
			return;
		}
		if(hasNext(WEIGHT_Lv3)) {
			return;
		}
		if(hasNext(WEIGHT_Lv2)) {
			return;
		}
		if(hasNext(WEIGHT_Lv1)) {
			return;
		}
	}
	public boolean hasNext(Integer weight) {
		setWeight(weight);
		List<Point> chess = getChess();
		if(chess.size()<weight-1) {
			return false;
		}
		if(weight==WEIGHT_Lv1) {
			Random r = new Random();
			Point point;
			int i1 = r.nextInt(3)+6;
			int i2 = r.nextInt(3)+6;
			do {
				point = new Point(ChessPanel.grade*i1+20,ChessPanel.grade*i2+20);
				i1 = r.nextInt(15);
				i2 = r.nextInt(15);
			} while (isExist(point)||!checkSpace(point,horizontal));
			setPoint(point);
			return true;
		}
		for (Point point : chess) {
			List<Point> points = getLinePoint(point, chess, horizontal);
			if(hasLv(points, horizontal)) {
				return true;
			}
			points = getLinePoint(point, chess, vertical);
			if(hasLv(points, vertical)) {
				return true;
			}
			points = getLinePoint(point, chess, left_falling);
			if(hasLv(points, left_falling)) {
				return true;
			}
			points = getLinePoint(point, chess, right_falling);
			if(hasLv(points, right_falling)) {
				return true;
			}
		}
		return false;
	}
	public boolean hasLv(List<Point> points,Integer direction) {
		if(points.size()<getWeight()-1) {
			return false;
		}
		
		if(direction== horizontal) {
			return a(points, direction);
		}else if(direction== vertical) {
			
		}else if(direction== left_falling) {
			
		}else if(direction== right_falling) {
			
		}
		return false;
	}
	public boolean a(List<Point> points,Integer direction) {
		int grade = ChessPanel.grade;
		int xMax = (int)points.get(points.size()-1).getX();
		int y = (int)points.get(0).getY();
		List<Point> list = points;
		for (int i = 0; i < points.size(); i++) {
			if(!checkSpace(points.get(i), direction)) {
				return false;
			}
			int x = (int)points.get(i).getX();
			if((xMax-x)/grade<getWeight()-1) {
				int x1 = x -  grade;
				Point p = new Point(x1,y);
				if(isExist(p, getOpponent())) {
					x1 = xMax +  grade;
					p = new Point(x1,y);
				}
				setPoint(p);
				return true;
			}
			if((xMax-x)/grade<getWeight()) {
				for(int j=1;j<getWeight()-1;j++) {
					int x1 = x +  grade*i;
					Point p = new Point(x1,y);
					if(!isExist(p)) {
						setPoint(p);
						return true;
					}
				}
			}
			list.remove(i);
			a(list, direction);
		}
		return false;
	}
	public List<Point> getLinePoint(Point point,List<Point> chess,Integer direction) {
		int x = (int)point.getX();
		int y = (int)point.getY();
		int grade = ChessPanel.grade;
		int weight = getWeight()-1;
		List<Point> points = new ArrayList<>();
		if(direction==horizontal) {
			int xMax = x + grade*weight+1>580?580:x + grade*weight+1;
			int xMin = x - grade*weight-1<20?20:x - grade*weight-1;
			for (Point p : chess) {
				if(p.getY()==y&&p.getX()<xMax&&p.getX()>xMin) {
					points.add(p);
				}
			}
			return points;
		}else if(direction==vertical) {
			int yMax = y + grade*weight+1>580?580:x + grade*weight+1;
			int yMin = y - grade*weight-1<20?20:x - grade*weight-1;
			for (Point p : chess) {
				if(p.getX()==x&&p.getY()<yMax&&p.getY()>yMin) {
					points.add(p);
				}
			}
			return points;
		}else if(direction==right_falling) {
			for (Point p : chess) {
				for(int i=0;i<weight;i++) {
					int x1 = x + grade*i;
					int x2 = x - grade*i;
					int y1 = y + grade*i;
					int y2 = y - grade*i;
					if((p.getX()==x1&&p.getY()==y1)||(p.getX()==x2&&p.getY()==y2)) {
						points.add(p);
					}
				}
			}
			return points;
		}else if(direction==left_falling) {
			for (Point p : chess) {
				for(int i=0;i<weight;i++) {
					int x1 = x + grade*i;
					int y1 = y - grade*i;
					int x2 = x - grade*i;
					int y2 = y + grade*i;
					if((p.getX()==x1&&p.getY()==y1)||(p.getX()==x2&&p.getY()==y2)) {
						points.add(p);
					}
				}
			}
			return points;
		}
		return null;
	}
	public void sortPoints(List<Point> points,Integer direction) {//根据方向排序
		if(direction==vertical) {//纵向
			Collections.sort(points, new Comparator<Point>() {
				@Override
				public int compare(Point p1, Point p2) {
					return p1.getY()>p2.getY()?1:-1;
				}
			});
		}else {
			Collections.sort(points, new Comparator<Point>() {
				@Override
				public int compare(Point p1, Point p2) {
					return p1.getX()>p2.getX()?1:-1;
				}
			});

		}
	}
	public boolean isExist(Point point,Player opponent) {
		return ChessUtil.isExist(point, opponent.getChess());
	}
	public boolean checkSpace(Point point,Integer direction) {
		int grade = ChessPanel.grade;
		if(direction==horizontal) {
			int y = (int)point.getY();
			for(int i=1;i<5;i++) {
				int x = (int)point.getX();
				if(x==20||x==580) {
					int x1 = x==20?x+grade*4:x-grade*4;
					Point p1 = new Point(x1, y);
					if(isExist(p1,getOpponent())) {
						return false;
					}
				}
				int x1 = x - grade*i;
				int x2 = x + grade*(5-i);
				int count = 0;
				for (Point p:getOpponent().getChess()) {
					if(p.getY()==y&&p.getX()<=x2&&p.getX()>=x1) {
						count++;
					}
					if(count==2) {
						return false;
					}
				}
			}
		}else if(direction==vertical) {
			
		}else if(direction==right_falling) {
			
		}else if(direction==left_falling) {
			
		}
		return true;
	}
}
