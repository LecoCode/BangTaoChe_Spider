package com.bangtaoche.spider.dpage.url;

import java.util.List;
import java.util.Set;

/**
 * @author: 李飞
 * @Time: 17-11-22.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 对数据库中的URL资源的操作接口
 */
public interface DBsourceURL {
    /**
     * 存入单个URL
     * @param url
     */
    void setUrl(String url);
    /**
     * 存入多个URL
     * @param
     */
    void setUrlList(List<String> listurl);

    /**
     * 获取单个url
     * @return
     */
    String getUrl(long id);

    /**
     * 获取多个url
     * @return
     */
    List<String> getUrlList(List<String> ids);

    /**
     * 获取所有url
     */
    Set<String> getUrlAll(String key);

}
