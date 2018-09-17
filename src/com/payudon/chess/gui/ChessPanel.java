
package com.payudon.chess.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
* @ClassName: ChessPanel 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月6日 下午2:31:04 
*  
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class ChessPanel extends JPanel{

	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
	private static String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	public static int grade;
	public static int width = 620;
	public static int height = width;
	public ChessPanel() {
		setBackground(new Color(208,165,133));
		setBounds(30,30, width, height);
	}
	
	public void paint(Graphics g) {
		super.paint(g);//如果注释掉super.paint(g)，那么就不显示父类JPanel容器中的原本组件，只能显示出方块了。
		g.setColor(Color.black);
		paintRowLine(g);
		paintColLine(g);
	}
	
	public void paintChess(Point point,boolean isFirst) {
		Chess chess = new Chess();
		Graphics2D g = (Graphics2D) this.getGraphics();
		//抗锯齿
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if(isFirst) {
			chess.paint(g, point,Color.black);
		}else {
			chess.paint(g, point,Color.white);
		}
	}
	public void paintRowLine(Graphics g) {
		int width = this.getWidth()-20;
		grade = width/15;
		for(int i=0;i<15;i++) {
			int step = grade * i+20;
			int x1 = 20;
			int y1 = step;	
			int x2 = width-grade+20;
			int y2 = y1;
			if(i==3||i==11) {
				g.fill3DRect(grade * 3+18, step-2, 5, 5, false);
				g.fill3DRect(grade * 11+18, step-2, 5, 5, false);
			}
			g.drawLine(x1,y1,x2,y2);
			char[] data = new String(""+(i+1)).toCharArray();
			g.drawChars(data, 0,data.length, 0,step+5);
		}
	}
	public void paintColLine(Graphics g) {
		int height = this.getHeight()-20;
		for(int i=0;i<15;i++) {
			int step = grade * i+20;
			int x1 = step;
			int y1 = 20;	
			int x2 = x1;
			int y2 = height-grade+20;
			if(i==7) {
				g.fill3DRect(step-2, step-2, 5, 5, true);
			}
			g.drawLine(x1,y1,x2,y2);
			char[] data = letters[i].toCharArray();
			g.drawChars(data, 0,data.length, step-5,10);
		}
	}

	public Point[] getPoints() {
		Point[] points = new Point[15*15];
		int width = this.getWidth()-20;
		int grade = width/15;
		int index = 0;
		for(int i=0;i<15;i++) {
			int x = i*grade+20;
			for(int j=0;j<15;j++) {
				int y = j*grade+20;
				points[index] = new Point(x, y);
				index++;
			}
		}
		return points;
	}
	
	public Point getClickPoint(Point point) {
		Point[] points = getPoints();
		for (Point p : points) {
			double x = point.getX();
			double y = point.getY();
			double px = p.getX();
			double py = p.getY();
			int step = 20;//灵敏度
			if(x+step>px&&x-step<px&&y+step>py&&y-step<py) {
				return p;
			}
		}
		return null;
	}
}
