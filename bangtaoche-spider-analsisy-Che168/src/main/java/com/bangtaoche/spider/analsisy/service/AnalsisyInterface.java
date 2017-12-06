package com.bangtaoche.spider.analsisy.service;

import com.bangtaoche.spider.messagequeuecll.function.CheBean;

import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-12-5.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public interface AnalsisyInterface {
   void setPageXMl(String pagexml);
   Object run();// 开始解析的抽象方法
}
