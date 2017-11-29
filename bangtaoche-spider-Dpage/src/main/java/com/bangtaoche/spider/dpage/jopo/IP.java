package com.bangtaoche.spider.dpage.jopo;

/**
 * @author: 李飞
 * @Time: 17-11-23.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class IP {
    private String ip;
    private int port;

    public IP(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "IP{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
