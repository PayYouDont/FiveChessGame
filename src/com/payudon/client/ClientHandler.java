
package com.payudon.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

/** 
* @ClassName: ClientHandler 
* @Description: TODO(     ) 
* @author peiyongdong
* @date 2018年9月20日 下午4:54:31 
*  
*/
public class ClientHandler extends SimpleChannelInboundHandler<Object> {
	/** 
	 * <p>Title: messageReceived</p> 
	 * <p>Description: </p> 
	 * @param ctx
	 * @param msg
	 * @throws Exception 
	 * @see io.netty.channel.SimpleChannelInboundHandler#messageReceived(io.netty.channel.ChannelHandlerContext, java.lang.Object) 
	 * @throws 
	 * @author peiyongdong
	 * @date 2018年9月20日 下午4:55:00
	 */
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
		ctx.channel().attr(AttributeKey.valueOf("Attribute_key")).set(msg);
		ctx.close();
		
	}
}
