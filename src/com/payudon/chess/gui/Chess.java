
package com.payudon.chess.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/** 
* @ClassName: Chess 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月6日 下午5:28:07 
*  
*/
public class Chess extends JPanel{
	
	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g,Point point,Color color) {
		super.paint(g);//如果注释掉super.paint(g)，那么就不显示父类JPanel容器中的原本组件，只能显示出方块了。
		g.setColor(color);
		int r = 15;
		int x = (int)point.getX()-r;
		int y = (int)point.getY()-r;
		g.fillOval(x, y, 2*r, 2*r);
	}
}
