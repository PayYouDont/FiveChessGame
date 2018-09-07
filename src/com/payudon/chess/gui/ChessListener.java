
package com.payudon.chess.gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/** 
* @ClassName: Listener 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月6日 下午5:08:17 
*  
*/
@Data
public class ChessListener implements MouseListener{
	private boolean isFirst;
	private List<Point> chess= new ArrayList<>();
	private boolean isPlay;
	/** 
	 * <p>Title: mouseClicked</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月6日 下午5:08:49
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==1) {
			Point point = Chessboard.chess.getClickPoint(e.getPoint());
			if(point!=null) {
				chess.add(point);
				Chessboard.chess.paintChess(point,isFirst());
				setPlay(false);
			}
		}
	}

	/** 
	 * <p>Title: mousePressed</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月6日 下午5:08:49
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * <p>Title: mouseReleased</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月6日 下午5:08:49
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * <p>Title: mouseEntered</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月6日 下午5:08:49
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * <p>Title: mouseExited</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月6日 下午5:08:49
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
