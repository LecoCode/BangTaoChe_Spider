package bangtaoche.spider.beans.data;

/**
 * @author: 李飞
 * @Time: 17-12-6.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class IP {
    private String IP;
    private int port;

    @Override
    public String toString() {
        return "IP{" +
                "IP='" + IP + '\'' +
                ", port=" + port +
                '}';
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
