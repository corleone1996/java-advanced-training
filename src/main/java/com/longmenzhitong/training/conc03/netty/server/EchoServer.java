package com.longmenzhitong.training.conc03.netty.server;

import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServer extends BaseServer {

    public EchoServer(int port) {
        super(port);
    }

    @Override
    protected ChannelInboundHandlerAdapter getServerHandler() {
        return new EchoServerHandler();
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new EchoServer(port).run();
    }
}
