package com.bangtaoche.spider.analsisy.detailed;

import com.bangtaoche.spider.analsisy.service.absDetailedAnalsisyMode;
import com.bangtaoche.spider.messagequeuecll.function.DeTailsCheBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-12-5.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DetailedAnalsisyModeChe168 extends absDetailedAnalsisyMode {
    private static final String HTTPS="https:";
    DeTailsCheBean deTailsCheBean = new DeTailsCheBean();
    private static final String UrlPath="https:";

    public DeTailsCheBean run() {
        try {


        Document document = Jsoup.parse(pagexml);
        //详情头
        Element car_warp_content_fn_clear = document.getElementsByClass("car-warp content fn-clear").get(0);
        //基本信息
        Element  anchor01 = document.getElementById("anchor01");
        //车辆配置
        Element  anchor02 = document.getElementById("anchor02");
        DetailHead(car_warp_content_fn_clear);
        BaseMessage(anchor01);
        CarConfig(anchor02);

        //车源编号
        deTailsCheBean.setSourceId("5");
        //是否新上
        deTailsCheBean.setNewStatus(1);
        //车辆来源URL
        deTailsCheBean.setSourceUrl(pageUrl);
        //是否降价
        deTailsCheBean.setPriceReduction(2);
        //是否在售
        deTailsCheBean.setStatus(1);
        }catch (Exception e){
            System.err.println(">>>>>>>>>>>>解析错误！");
        }
        return deTailsCheBean;
    }
    //详细的头
    public void DetailHead(Element element)throws Exception{
        Element divs = element.getElementsByTag("div").get(0);
        Element imagNode = divs.getElementsByClass("car-foucs").get(0);
        Element contextNode = divs.getElementsByClass("car-info").get(0);
        ImageNodeAnalysis(imagNode);
        String name ="-";//名称
        String jiaqian ="-";//价钱
//        String sheng ="-";//比新车省了**
//        String xingJiaQian ="-";//新车含税价格**
//        String guoHuFei ="-";//是否包含过户费**
        String liCheng ="-";//行驶里程
        String shouCiPaiZhao ="-"; //首次上牌照
//        String dangWei ="-";//档位
        String paiLiang ="-";//排量
        String suoZaiDi ="-"; //所在地
        String iphone ="-";//电话
        String kanCheDiDian ="-";//看车地点
        String faBuShiJian ="-"; //发布时间
//        String yishouZhuangTai ="-";//已售状态
        Element car_title = contextNode.
                getElementsByClass("car-title").get(0);
        name = car_title.
                getElementsByTag("h2").get(0).text();
        Element car_key_fn_clear = contextNode.
                getElementsByClass("car-key fn-clear").get(0);
        Element ins = car_key_fn_clear
                .getElementsByTag("ins").get(0);
        jiaqian = ins.text().
                substring(1, ins.text().length());
//        Element base_compriceHead = car_key_fn_clear.
//                getElementById("base_compriceHead");
//        sheng = base_compriceHead.
//                text().substring(5,base_compriceHead.text().length()-1);
//        if (car_key_fn_clear.getElementById("CarNewPrice").text().contains("2")){
//            xingJiaQian = car_key_fn_clear
//                    .getElementById("CarNewPrice").text();
//        }
//        guoHuFei = car_key_fn_clear.
//                getElementsByClass("car-price").get(0).getElementsByClass("tag").get(0).text();
        //车辆信息
        Element details = contextNode.
                getElementsByClass("details").get(0);
        Element ul = details.
                getElementsByTag("ul").get(0);
        Elements li = ul.
                getElementsByTag("li");
        liCheng = li.get(0).
                getElementsByTag("span").get(0).text();
        liCheng = liCheng.substring(0,liCheng.indexOf("万"));
        shouCiPaiZhao = li.get(1).
                getElementsByTag("span").get(0).text();
        String dw_pl = li.get(2).
                getElementsByTag("span").get(0).text();
        String[] split = dw_pl.split("／");
//        dangWei = split[0];
        paiLiang = split[1];
        suoZaiDi = li.get(3).
                getElementsByTag("span").get(0).text();
        //联系人信息
        Element car_results_fn_clear = contextNode.
                getElementsByClass("car-results fn-clear").get(0);
        iphone = car_results_fn_clear.
                getElementsByClass("btn btn-iphone3").get(0).text();
        if (iphone.length()>4) {
            iphone = iphone.substring(2, iphone.length());
        }
        String car_address = contextNode.
                getElementsByClass("car-address").get(0).text();
        kanCheDiDian = car_address.substring(0,car_address.indexOf("发")).trim().substring(5);

        faBuShiJian = car_address.substring(car_address.lastIndexOf(":")+1).trim();

        //所在城市
        deTailsCheBean.setLocation(suoZaiDi);
        // 咨询电话
        deTailsCheBean.setPhone(iphone);
        //名称
        deTailsCheBean.setCarName(name);
        //发布时间
        deTailsCheBean.setSellTime(faBuShiJian);
        //价格
        if (!"-".equals(jiaqian)){
            String s = (Double.parseDouble(jiaqian) * 10000) + "";
            s.substring(0, s.indexOf(".") + 2);
            deTailsCheBean.setOwnerPrice(Double.parseDouble(s.substring(0, s.indexOf(".") + 2)));
        }else {
            deTailsCheBean.setOwnerPrice(-1);
        }
        //里程
        if (!"-".equals(liCheng)){
            String lccopy = (Double.parseDouble(liCheng) * 10000) + "";
            deTailsCheBean.setMileage(Double.parseDouble(lccopy.substring(0, lccopy.indexOf(".") + 2)));
        }else {
            deTailsCheBean.setMileage(-1);
        }
        //添加时间
        deTailsCheBean.setAddTime(new Date());
        //上牌时间
        deTailsCheBean.setRegTime(shouCiPaiZhao);
        //排量
        if (paiLiang.contains("L")){
            deTailsCheBean.setDisplacement(paiLiang);
        }
        //看车地址
        deTailsCheBean.setSeeCarCity(kanCheDiDian);
        //所在城市
        deTailsCheBean.setRegCity(suoZaiDi);

    }
    //车的配置
    public void CarConfig(Element element)throws Exception{
//        String faDongji="-";//发动机
        String bianSuQi="-";//变速器
//        String cheLiangJiBie="-";//车辆级别
//        String yanSe="-";//颜色
//        String ranYouBiaoHao="-";//燃油标号
//        String quDongBiaoHao="-";//驱动方式
        String GaoDuanPeiZhi = "";//高端配置





        Elements ul = element.
                getElementsByClass
                        ("infotext-list fn-clear").get(0).getElementsByTag("li");
        //发动机

//        faDongji = getText(ul.get(0));
        //变速器
        bianSuQi = getText(ul.get(1));
//
//        //车辆级别
//        cheLiangJiBie = getText(ul.get(2));
//        //颜色
//        yanSe = getText(ul.get(3));
//
//        //燃油标号
//        ranYouBiaoHao = getText(ul.get(4));
//
//        //驱动方式
//        quDongBiaoHao = getText(ul.get(5));

        //高端配置
        Elements scrollPics = element.getElementsByClass("scrollPic");
        if (scrollPics.size()>=1){
            Element scrollPic = scrollPics.get(0);
            if (scrollPic!=null){
                Element ul1 = scrollPic.getElementsByTag("ul").get(0);
                Elements li = ul1.getElementsByTag("li");
                for (Element e:
                        li) {
                    Element p = e.getElementsByTag("p").get(0);
                    GaoDuanPeiZhi+=p.text()+",";
                }
            }
        }
        // 高端配置
        deTailsCheBean.setBrightPoints(GaoDuanPeiZhi);
        //变速箱
        String gearbox = bianSuQi;
        if (gearbox.contains("手动")) {
            deTailsCheBean.setGearbox("1");
        }
        if (gearbox.contains("自动")) {
            deTailsCheBean.setGearbox("2");
        }
        if (gearbox.contains("手自一体")) {
            deTailsCheBean.setGearbox("3");
        }
        if (gearbox.contains("无级变速")) {
            deTailsCheBean.setGearbox("4");
        }
        if (gearbox.contains("双离合")) {
            deTailsCheBean.setGearbox("5");
        }

    }
    private String getText(Element element){
        String text = element.text().
                substring(6).trim();
        return text;
    }
    //基本信息
    public void BaseMessage(Element element)throws Exception{
        String nianJian="-";//年检到期
        String baoXian="-";//保险到期
//        String zhiBao="-";//质保到期
        String paiFang="-";//排放标准
        String guoHu="-";//过户
        String baoYang="-";//保养
        String carMessage="-";//车主描述


        Elements ul = element.
                getElementsByTag("ul").get(0).
                getElementsByTag("li");
        //年检到期
        String grid_6_1 = ul.get(0).text();
        nianJian = grid_6_1.
                substring(grid_6_1.indexOf(" ")).trim();
        //保险到期
        String grid_6_2 = ul.get(1).text();
        baoXian = grid_6_2.
                substring(grid_6_2.indexOf(" ")).trim();
        //质保到期
        /*
        String grid_8 = ul.get(2).text();
        zhiBao = grid_8.
                substring(grid_8.indexOf(" ")).trim();
                */
        //排放标准
        String grid_6_3 = ul.get(3).text();
        paiFang = grid_6_3.
                substring(grid_6_3.indexOf(" ")).trim();
        //过户次数
        String grid_6_4 = ul.get(4).text();
        guoHu = grid_6_4.
                substring(grid_6_4.indexOf(" ")).trim();
        //维修保养
        String grid_6_5 = ul.get(6).text();
        baoYang = grid_6_5.
                substring(grid_6_5.indexOf(" ")).trim();
        //车主描述
        carMessage = ul.get(7).getElementsByClass("tip-content fn-clear").text();
        carMessage=carMessage.replaceAll("展开更多","");
        carMessage=carMessage.replaceAll("收起","");

        //是否4s保养
        if (baoYang.contains("定期4S保养")) {
            deTailsCheBean.setFourService(1);
        } else if (baoYang.contains("-")) {
            deTailsCheBean.setFourService(2);
        } else {
            deTailsCheBean.setFourService(-1);
        }
        //卖家描述
        if (carMessage.length() > 10) {
            carMessage.replaceAll("�N", "km");
            carMessage.replaceAll("�", "");
            deTailsCheBean.setOwnerDepict(carMessage);
        } else {
            deTailsCheBean.setOwnerDepict(carMessage);
        }
        //年检时间
        deTailsCheBean.setYearExamineTime(nianJian);
        //交强险到期时间
        deTailsCheBean.setTrafficInsuranceTime(baoXian);
        //排放标准
        String standard = paiFang;
        if (standard.contains("国I")) {
            deTailsCheBean.setStandard("1");
        }
        if (standard.contains("国II")) {
            deTailsCheBean.setStandard("2");
        }
        if (standard.contains("国III")) {
            deTailsCheBean.setStandard("3");
        }
        if (standard.contains("国IV")) {
            deTailsCheBean.setStandard("4");
        }
        if (standard.contains("国V")) {
            deTailsCheBean.setStandard("5");
        }
        if (standard.contains("欧I")) {
            deTailsCheBean.setStandard("100");
        }
        if (standard.contains("欧II")) {
            deTailsCheBean.setStandard("101");
        }
        if (standard.contains("欧III")) {
            deTailsCheBean.setStandard("102");
        }
        if (standard.contains("欧IV")) {
            deTailsCheBean.setStandard("103");
        }
        if (standard.contains("欧V")) {
            deTailsCheBean.setStandard("104");
        }
        if (standard.contains("欧VI")) {
            deTailsCheBean.setStandard("105");
        }
        //过户次数
        if (!"-".equals(guoHu)){
            deTailsCheBean.setDealCount(Integer.parseInt(guoHu.substring(0, 1)));
        }else {
            deTailsCheBean.setDealCount(-1);
        }
    }

    /**
     * 获取图片
     * @return 图片URL集合
     */
    private void ImageNodeAnalysis(Element imagNode){
//        Set<String> images=new HashSet<String>();
        String images = new String();
        Element ul = imagNode.getElementsByTag("ul").get(0);
        Elements li = ul.getElementsByTag("li");
        for (Element el:
                li) {
            String alt = el.attr("alt");
//            System.out.println(alt);
//            images.add(UrlPath+alt);
            String url = UrlPath+alt;
            images +=url+",";
        }
        /*
          {"1":"www.baidu.com",}
         */
        StringBuilder JSONImage = new StringBuilder("{");
        String[] split = images.split(",");
        for (int i = 0; i <split.length; i++) {
            String key = (i+1)+"";
            String value = split[i];
            String jsonString = "\""+key+"\":"+"\""+value+"\",";
            JSONImage.append(jsonString);
        }
        String substring = JSONImage.substring(0, JSONImage.length()-2)+"\"}";
        deTailsCheBean.setCarImages(substring);
    }

}
