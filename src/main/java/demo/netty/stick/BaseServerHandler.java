package demo.netty.stick;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 19:59 2018/7/5 .
 */
public class BaseServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String)msg;
        System.out.println("server receive order : " + body + ";the counter is: " + ++counter);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
