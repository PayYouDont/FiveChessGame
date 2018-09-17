
package com.payudon.chess.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @ClassName: MenuDialog
 * @Description: TODO( )
 * @author peiyongdong
 * @date 2018年9月17日 下午3:29:15
 * 
 */
public class WinDialog extends JDialog implements ActionListener {

	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
	private static final int WIDTH =  340;
	private static final int HEIGHT =  100;
	public WinDialog(JFrame frame) {
		super(frame);
		Container pane = getContentPane();
        int width = frame.getWidth()-WIDTH;
        width = width/2;
        int height = frame.getHeight()-HEIGHT;
        height = height/2;
        int x = (int)frame.getLocation().getX()+width;
        int y = (int)frame.getLocation().getY()+height;
        setBounds(x,y,WIDTH,HEIGHT);
        pane.add(new JLabel("you win"));
	}
	
	/** 
	 * <p>Title: actionPerformed</p> 
	 * <p>Description: </p> 
	 * @param e 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月17日 下午3:41:13
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
