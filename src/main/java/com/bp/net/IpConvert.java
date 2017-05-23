package com.bp.net;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;

/**
 * 获取ip
 *
 * @author current_bp
 * @createTime 20170523
 */
public class IpConvert extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String hostAddress = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostAddress = address.getHostAddress();
        } catch (Exception e) {
            System.out.println("===>e:msg:" + e.getMessage());
        }
        return hostAddress;
    }
}
