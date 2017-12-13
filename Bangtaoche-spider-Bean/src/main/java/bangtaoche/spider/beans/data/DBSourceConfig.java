package bangtaoche.spider.beans.data;

/**
 * @author: 李飞
 * @Time: 17-12-6.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourceConfig {
    private String DriverClassName;
    private String Url;
    private String Username;
    private String Password;
    private int MaxActive;
    private int MinIdle;
    private int QueryTimeout;


    public int getMaxActive() {
        return MaxActive;
    }

    public void setMaxActive(int maxActive) {
        MaxActive = maxActive;
    }

    public int getMinIdle() {
        return MinIdle;
    }

    public void setMinIdle(int minIdle) {
        MinIdle = minIdle;
    }

    public int getQueryTimeout() {
        return QueryTimeout;
    }

    public void setQueryTimeout(int queryTimeout) {
        QueryTimeout = queryTimeout;
    }

    public String getDriverClassName() {
        return DriverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        DriverClassName = driverClassName;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "DBSourceConfig{" +
                "DriverClassName='" + DriverClassName + '\'' +
                ", Url='" + Url + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", MaxActive=" + MaxActive +
                ", MinIdle=" + MinIdle +
                ", QueryTimeout=" + QueryTimeout +
                '}';
    }
}
