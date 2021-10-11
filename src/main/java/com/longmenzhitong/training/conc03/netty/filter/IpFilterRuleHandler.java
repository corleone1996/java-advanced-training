package com.longmenzhitong.training.conc03.netty.filter;

import com.longmenzhitong.training.conc03.netty.pojo.IpRange;
import com.longmenzhitong.training.util.IpUtil;
import io.netty.handler.ipfilter.IpFilterRule;
import io.netty.handler.ipfilter.IpFilterRuleType;

import java.net.InetSocketAddress;

public class IpFilterRuleHandler implements IpFilterRule {

    /**
     * @param remoteAddress
     * @return This method should return true if remoteAddress is valid according to your criteria. False otherwise.
     */
    @Override
    public boolean matches(InetSocketAddress remoteAddress) {
        String hostString = remoteAddress.getHostString();
        long host = IpUtil.ipToLong(hostString);

        IpRange range = new IpRange("127.0.0.1", "127.0.0.1");
        long ipStart = IpUtil.ipToLong(range.getStart());
        long ipEnd = IpUtil.ipToLong(range.getEnd());

        return host <= ipEnd && host >= ipStart;
    }

    /**
     * @return This method should return {@link IpFilterRuleType#ACCEPT} if all
     * {@link IpFilterRule#matches(InetSocketAddress)} for which {@link #matches(InetSocketAddress)}
     * returns true should the accepted. If you want to exclude all of those IP addresses then
     * {@link IpFilterRuleType#REJECT} should be returned.
     */
    @Override
    public IpFilterRuleType ruleType() {
        return IpFilterRuleType.REJECT;
    }
}
