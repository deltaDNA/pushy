package com.relayrides.pushy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ExpiredTokenEncoder extends MessageToByteEncoder<TokenExpiration> {

	@Override
	protected void encode(final ChannelHandlerContext context, final TokenExpiration expiredToken, final ByteBuf out) {
		out.writeInt((int) (expiredToken.getExpiration().getTime() / 1000L));
		out.writeShort(expiredToken.getToken().length);
		out.writeBytes(expiredToken.getToken());
	}
}
