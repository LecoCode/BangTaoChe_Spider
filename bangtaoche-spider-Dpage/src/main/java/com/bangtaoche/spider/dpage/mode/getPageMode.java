package com.bangtaoche.spider.dpage.mode;

import com.bangtaoche.spider.dpage.jopo.IP;
import com.bangtaoche.spider.dpage.messagequeue.DocumentMessageQueue;
import com.bangtaoche.spider.util.ThreadLocalClientFactory;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * @author: 李飞
 * @Time: 17-11-23.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class getPageMode implements PageMode {
    static ThreadLocalClientFactory instance;
    public getPageMode(){

    }
    public static String get(String url) {
        instance= ThreadLocalClientFactory.getInstance();
        WebClient webClient = instance.getWebClient();
        String pageMode = getPageMode(url,webClient);
        return pageMode;
    }

    public static String get(String url, IP ip) {
        ThreadLocalClientFactory instance = ThreadLocalClientFactory.getInstance();
        WebClient webClient = instance.getWebClient();
        ProxyConfig proxyConfig = webClient.getProxyConfig();
        proxyConfig.setProxyHost(ip.getIp());
        proxyConfig.setProxyPort(ip.getPort());
        String pageMode = getPageMode(url,webClient);
        return pageMode;
    }
    /**
     * 获取页面
     * String：正常
     * -1：失败
     * 0：下架
     *
     * @param url
     * @return
     */
    private static String getPageMode(String url,WebClient webClient) {
        try {
            HtmlPage page = webClient.getPage(url);
            if (page.asXml()!=null) {
                DomNodeList<HtmlElement> body = page.getElementsByTagName("body");
                if (body.size()>0){
                    String xml = body.get(0).asXml();
                    if (xml.contains("出错啦，您访问的页面走丢啦！")){
                       return "-1";
                    }else if (xml.contains("该车源已售")){
                       return "0";
                    }else {
                        return xml.toString();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
