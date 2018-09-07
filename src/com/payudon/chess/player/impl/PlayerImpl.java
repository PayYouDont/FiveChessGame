
package com.payudon.chess.player.impl;

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
				while(true) {
					if(!isPlay()||getListener().isPlay()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						ChessListener listener = getListener();
						listener.setPlay(isPlay());
						Chessboard.chess.addMouseListener(listener);
						setPlay(false);
						getOpponent().setPlay(true);
						setChess(getListener().getChess());
					}
				}
			}
		}).start();
	}
	
}
