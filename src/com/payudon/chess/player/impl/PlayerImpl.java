
package com.payudon.chess.player.impl;

import java.awt.Point;
import java.awt.event.MouseEvent;

import com.payudon.chess.Application;
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
	/** 
	* @Fields serialVersionUID : TODO(     ) 
	*/ 
	private static final long serialVersionUID = 1L;
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
	public void play(Chessboard board) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				board.getChess().addMouseListener(new ChessListener() {
					@Override
					 public void mouseClicked(MouseEvent e) {
						if(isPlay()&&e.getButton()==1) {
							Point point = board.getChess().getClickPoint(e.getPoint());
							if(!Application.GAME.isExist(point)) {
								setPoint(point);
								getChess().add(point);
								board.chess.paintChess(point,isFirst());
								setPlay(false);
								isWin();
								Application.GAME.next();
							}
						}
					}
				});
			}
		}).start();
	}
	public void playOnlie(Chessboard board) {
		Point point = getPoint();
		if(point!=null&&!Application.GAME.isExist(point)) {
			getChess().add(point);
			board.chess.paintChess(point,isFirst());
			isWin();
		}
	}
	public PlayerImpl(String nick, String ip) {
		super();
		this.nick = nick;
		this.ip = ip;
	}
	public PlayerImpl() {
		super();
	}
}
