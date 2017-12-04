package com.bangtaoche.spider.solver.service;

import com.bangtaoche.spider.solver.dao.RenRenCheDAO;
import com.bangtaoche.spider.solver.message.MessageRules;
import com.bangtaoche.util.msg.factory.ProducerFactory;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class SolverService {
    static {
        ProducerFactory.getInstanceTest(MessageRules.PID_CAR,MessageRules.TOPIC_CAR);
        ProducerFactory.getInstanceTest(MessageRules.PID_PRICE,MessageRules.TOPIC_PRICE);
    }
}
