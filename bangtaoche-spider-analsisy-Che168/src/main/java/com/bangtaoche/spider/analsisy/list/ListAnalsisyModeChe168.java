package com.bangtaoche.spider.analsisy.list;

import bangtaoche.spider.beans.che.CheBean;
import com.bangtaoche.spider.analsisy.service.absListAnalsisyMode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-12-5.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class ListAnalsisyModeChe168 extends absListAnalsisyMode {

    public List<CheBean> run() {
        List<CheBean> cheBeans = new ArrayList<CheBean>();
        try {
            Document parse = Jsoup.parse(pagexml);
            Element a3 = parse.getElementById("a3");
            Element element1 = a3.getElementsByClass("list-source-wrap")
                    .get(0)
                    .getElementsByClass("tab-content")
                    .get(0);
            Element elementById = element1.getElementById("tab-11");
            if (elementById.getElementsByClass("list-photo").size()>0) {
                Element element2 = elementById.getElementsByClass("list-photo").get(0);
                Element element =
                        element2.getElementsByClass("fn-clear").get(0);
                Elements li = element.getElementsByTag("li");
                for (Element el:
                        li) {
                    try {
                        //*******************URL********************************************
                        Element a = el.getElementsByTag("a").get(0);
                        String Url = "https://www.che168.com"+a.attr("href");
                        //********************车名字*******************************************
                        Element list_photo = el.getElementsByClass("list-photo-info").get(0);
                        String CheName = list_photo.getElementsByTag("h3").get(0).text();
                        //*********************里程******************************************
                        Element time = list_photo.getElementsByClass("time").get(0);
                        String[] split = time.text().split("／");
                        String suWan=split[0].substring(0,split[0].indexOf("万"));
                        double licheng_d=Double.parseDouble(suWan);
                        String v1 = (licheng_d * 10000)+"";
                        if (v1.contains(".")){
                            v1=v1.substring(0,v1.indexOf("."));
                        }
                        String LiCheng =v1;
                        //*********************上牌时间******************************************
                        String ShangPaiShiJian = split[1];
                        //*********************上牌地址******************************************
                        String ShangPaiDiZhi = split[2];
                        //*********************售价******************************************
                        String b = list_photo.getElementsByClass("price").get(0)
                                .getElementsByTag("em").get(0)
                                .getElementsByTag("b").text();
                        double moni = Double.parseDouble(b);
                        double v = moni * 10000;
                        String vs = v+"";
                        String substring = vs.substring(0, vs.indexOf("."));
                        String ShouJia = substring;
                        String ShiFouShangXIng;
                        Element element3 = el.getElementsByClass("tag-area").get(0);
                        if (element3.text().contains("新上")){
                            ShiFouShangXIng="1";
                        }else {
                            ShiFouShangXIng="2";
                        }
                        CheBean cheBean = new CheBean();
                        cheBean.setUrl(Url);
                        cheBean.setCheName(CheName);
                        cheBean.setLiCheng(LiCheng);
                        cheBean.setShangPaiDiZhi(ShangPaiDiZhi);
                        cheBean.setShangPaiShiJian(ShangPaiShiJian);
                        cheBean.setShouJia(ShouJia);
                        cheBean.setShiFouShangXing(ShiFouShangXIng);
                        cheBeans.add(cheBean);
                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return cheBeans;
    }


}
