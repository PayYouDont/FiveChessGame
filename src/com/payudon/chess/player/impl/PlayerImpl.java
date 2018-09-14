
package com.payudon.chess.player.impl;

import java.awt.Point;
import java.awt.event.MouseEvent;

import com.payudon.chess.gui.ChessListener;
import com.payudon.chess.gui.Chessboard;
import com.payudon.chess.player.Player;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
* @ClassName: Player 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月7日 上午9:30:16 
*  
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class PlayerImpl extends Player{
	private String nick;
	private String ip;
	/** 
	 * <p>Title: play</p> 
	 * <p>Description: </p>  
	 * @see com.payudon.chess.player.Player#play() 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月7日 下午2:44:14
	 */
	@Override
	public void play() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Chessboard.chess.addMouseListener(new ChessListener() {
					@Override
					 public void mouseClicked(MouseEvent e) {
						if(isPlay()&&e.getButton()==1) {
							Point point = Chessboard.chess.getClickPoint(e.getPoint());
							if(!isExist(point)&&point!=null) {
								getChess().add(point);
								Chessboard.chess.paintChess(point,isFirst());
								setPlay(false);
								getOpponent().setPlay(true);
								isWin(point);
							}
						}
					}
				});
			}
		}).start();
	}
}
