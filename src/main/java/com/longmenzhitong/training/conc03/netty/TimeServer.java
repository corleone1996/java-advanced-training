package com.longmenzhitong.training.conc03.netty;

import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServer extends BaseServer {

    public TimeServer(int port) {
        super(port);
    }

    @Override
    protected ChannelInboundHandlerAdapter getServerHandler() {
        return new TimeServerHandler();
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new TimeServer(port).run();
    }
}
