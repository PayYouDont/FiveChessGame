
package com.payudon.client;

import com.payudon.chess.game.Gamer;
import com.payudon.chess.player.Player;
import com.payudon.util.JsonUtil;

/** 
* @ClassName: GameClient 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月17日 下午2:06:52 
*  
*/
public class GameClient {
    public static Gamer matchPlayer(Player player) {
		String jsonstr = JsonUtil.toJson(player);
		String gamerJson = NettyClient.send(jsonstr).toString();
		Gamer gamer = JsonUtil.parseObject(gamerJson, Gamer.class);
		return gamer;
		
    }
}
