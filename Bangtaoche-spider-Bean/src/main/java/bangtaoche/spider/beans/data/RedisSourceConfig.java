package bangtaoche.spider.beans.data;

/**
 * @author: 李飞
 * @Time: 17-12-7.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class RedisSourceConfig {

    private String Host = "127.0.0.1";
    private String Port = "6379";
    private int MaxIdle = 1000;
    private int MaxWait = 1500;
    private boolean TestOnBrrorw = false;
    private boolean TestOnReturn = false;

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public int getMaxIdle() {
        return MaxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        MaxIdle = maxIdle;
    }

    public int getMaxWait() {
        return MaxWait;
    }

    public void setMaxWait(int maxWait) {
        MaxWait = maxWait;
    }

    public boolean isTestOnBrrorw() {
        return TestOnBrrorw;
    }

    public void setTestOnBrrorw(boolean testOnBrrorw) {
        TestOnBrrorw = testOnBrrorw;
    }

    public boolean isTestOnReturn() {
        return TestOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        TestOnReturn = testOnReturn;
    }

    @Override
    public String toString() {
        return "RedisSourceConfig{" +
                "Host='" + Host + '\'' +
                ", Port='" + Port + '\'' +
                ", MaxIdle=" + MaxIdle +
                ", MaxWait=" + MaxWait +
                ", TestOnBrrorw=" + TestOnBrrorw +
                ", TestOnReturn=" + TestOnReturn +
                '}';
    }
}
