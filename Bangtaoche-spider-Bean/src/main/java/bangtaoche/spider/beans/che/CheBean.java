package bangtaoche.spider.beans.che;

import java.io.Serializable;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 统一的Che列表页单列类
 */
public class CheBean implements Serializable {
    private String sourceID="-";
    private String url="-";
    private String CheName="-";//车名
    private String LiCheng="-";//里程
    private String ShangPaiShiJian="-";//上牌时间
    private String ShangPaiDiZhi="-";//上牌地址
    private String ShouJia="-";//售价
    private String ShiFouShangXing="-";//是否上新

    @Override
    public String toString() {
        return "CheBean{" +
                "url='" + url + '\'' +
                ", CheName='" + CheName + '\'' +
                ", LiCheng='" + LiCheng + '\'' +
                ", ShangPaiShiJian='" + ShangPaiShiJian + '\'' +
                ", ShangPaiDiZhi='" + ShangPaiDiZhi + '\'' +
                ", ShouJia='" + ShouJia + '\'' +
                ", ShiFouShangXing='" + ShiFouShangXing + '\'' +
                '}';
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getShiFouShangXing() {
        return ShiFouShangXing;
    }

    public void setShiFouShangXing(String shiFouShangXing) {
        ShiFouShangXing = shiFouShangXing;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCheName() {
        return CheName;
    }

    public void setCheName(String cheName) {
        CheName = cheName;
    }

    public String getLiCheng() {
        return LiCheng;
    }

    public void setLiCheng(String liCheng) {
        LiCheng = liCheng;
    }

    public String getShangPaiShiJian() {
        return ShangPaiShiJian;
    }

    public void setShangPaiShiJian(String shangPaiShiJian) {
        ShangPaiShiJian = shangPaiShiJian;
    }

    public String getShangPaiDiZhi() {
        return ShangPaiDiZhi;
    }

    public void setShangPaiDiZhi(String shangPaiDiZhi) {
        ShangPaiDiZhi = shangPaiDiZhi;
    }

    public String getShouJia() {
        return ShouJia;
    }

    public void setShouJia(String shouJia) {
        ShouJia = shouJia;
    }
}
