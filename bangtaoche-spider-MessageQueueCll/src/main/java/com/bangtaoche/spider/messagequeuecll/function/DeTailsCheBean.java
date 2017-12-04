package com.bangtaoche.spider.messagequeuecll.function;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DeTailsCheBean implements Serializable {
    /** 车辆ID */
    private long carId;
    /** 车辆名 */
    private String carName;
    /** 添加时间 */
    private Date addTime;
    /** 车主报价（万元） */
    private double ownerPrice;
    /*** 变速箱 */
    private String gearbox;
    /** 指导价（万元） */
    private double directPrice;
    /** 上牌时间 */
    private String regTime;
    /** 里程 */
    private double mileage;
    /** 上牌地 */
    private String regCity;
    /** 排放标准 */
    private String standard;
    /** 过户次数 */
    private int dealCount;
    /** 排量 */
    private String displacement;
    /** 看车地址 */
    private String seeCarCity;
    /** 交强险到期时间 */
    private String trafficInsuranceTime;
    /** 年检时间 */
    private String yearExamineTime;
    /** 商业险到期时间 */
    private String commercialInsuranceTime;
    /** 车源编号 */
    private String sourceId;
    /** 高科技配置 */
    private String highTechDeploy;
    /** 服务费 */
    private double servicePrice;
    /** 是否4s店保养（1：是；2：否；-1未知） */
    private int fourService;
    /** 车辆来源URL*/
    private String sourceUrl;
    /*** 卖家描述*/
    private String ownerDepict;
    /*** 是否降价*/
    private int priceReduction;
    /*** 是否新上架 */
    private int newStatus;
    /*** 是否在售*/
    private int status;
    /** * 车辆图片*/
    private String 	carImages;
    /** * 城市URL*/
    private String cityUrl;
    /*** 咨询电话*/
    private String phone;
    private String brightPoints;
    /** * 所在城市 */
    private String location;
    /*** 添加时间 */
    private String SellTime;


    @Override
    public String toString() {
        return "DeTailsCheBean{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", addTime=" + addTime +
                ", ownerPrice=" + ownerPrice +
                ", gearbox='" + gearbox + '\'' +
                ", directPrice=" + directPrice +
                ", regTime='" + regTime + '\'' +
                ", mileage=" + mileage +
                ", regCity='" + regCity + '\'' +
                ", standard='" + standard + '\'' +
                ", dealCount=" + dealCount +
                ", displacement='" + displacement + '\'' +
                ", seeCarCity='" + seeCarCity + '\'' +
                ", trafficInsuranceTime='" + trafficInsuranceTime + '\'' +
                ", yearExamineTime='" + yearExamineTime + '\'' +
                ", commercialInsuranceTime='" + commercialInsuranceTime + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", highTechDeploy='" + highTechDeploy + '\'' +
                ", servicePrice=" + servicePrice +
                ", fourService=" + fourService +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", ownerDepict='" + ownerDepict + '\'' +
                ", priceReduction=" + priceReduction +
                ", newStatus=" + newStatus +
                ", status=" + status +
                ", carImages='" + carImages + '\'' +
                ", cityUrl='" + cityUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", brightPoints='" + brightPoints + '\'' +
                ", location='" + location + '\'' +
                ", SellTime='" + SellTime + '\'' +
                '}';
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public double getOwnerPrice() {
        return ownerPrice;
    }

    public void setOwnerPrice(double ownerPrice) {
        this.ownerPrice = ownerPrice;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public double getDirectPrice() {
        return directPrice;
    }

    public void setDirectPrice(double directPrice) {
        this.directPrice = directPrice;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getRegCity() {
        return regCity;
    }

    public void setRegCity(String regCity) {
        this.regCity = regCity;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getDealCount() {
        return dealCount;
    }

    public void setDealCount(int dealCount) {
        this.dealCount = dealCount;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getSeeCarCity() {
        return seeCarCity;
    }

    public void setSeeCarCity(String seeCarCity) {
        this.seeCarCity = seeCarCity;
    }

    public String getTrafficInsuranceTime() {
        return trafficInsuranceTime;
    }

    public void setTrafficInsuranceTime(String trafficInsuranceTime) {
        this.trafficInsuranceTime = trafficInsuranceTime;
    }

    public String getYearExamineTime() {
        return yearExamineTime;
    }

    public void setYearExamineTime(String yearExamineTime) {
        this.yearExamineTime = yearExamineTime;
    }

    public String getCommercialInsuranceTime() {
        return commercialInsuranceTime;
    }

    public void setCommercialInsuranceTime(String commercialInsuranceTime) {
        this.commercialInsuranceTime = commercialInsuranceTime;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getHighTechDeploy() {
        return highTechDeploy;
    }

    public void setHighTechDeploy(String highTechDeploy) {
        this.highTechDeploy = highTechDeploy;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getFourService() {
        return fourService;
    }

    public void setFourService(int fourService) {
        this.fourService = fourService;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getOwnerDepict() {
        return ownerDepict;
    }

    public void setOwnerDepict(String ownerDepict) {
        this.ownerDepict = ownerDepict;
    }

    public int getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(int priceReduction) {
        this.priceReduction = priceReduction;
    }

    public int getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(int newStatus) {
        this.newStatus = newStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCarImages() {
        return carImages;
    }

    public void setCarImages(String carImages) {
        this.carImages = carImages;
    }

    public String getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(String cityUrl) {
        this.cityUrl = cityUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBrightPoints() {
        return brightPoints;
    }

    public void setBrightPoints(String brightPoints) {
        this.brightPoints = brightPoints;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSellTime() {
        return SellTime;
    }

    public void setSellTime(String sellTime) {
        SellTime = sellTime;
    }
}
