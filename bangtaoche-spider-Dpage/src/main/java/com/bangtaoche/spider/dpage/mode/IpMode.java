package com.bangtaoche.spider.dpage.mode;

import com.bangtaoche.spider.dpage.jopo.IP;

import java.sql.SQLException;

/**
 * @author: 李飞
 * @Time: 17-11-23.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public interface IpMode {
    IP getIP() throws SQLException;
}
