
package com.payudon.chess.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** 
* @ClassName: Listener 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月6日 下午5:08:17 
*  
*/
public interface ChessListener extends MouseListener{
	default public void mousePressed(MouseEvent e) {
	
	}

	default public void mouseReleased(MouseEvent e) {
	}

	default public void mouseEntered(MouseEvent e) {
	}

	default public void mouseExited(MouseEvent e) {
	}
}
