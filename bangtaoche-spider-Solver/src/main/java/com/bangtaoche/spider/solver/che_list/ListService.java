package com.bangtaoche.spider.solver.che_list;

import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;
import com.bangtaoche.spider.messagequeuecll.function.CheBean;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import com.bangtaoche.spider.solver.Util;

import java.io.Serializable;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class ListService {
    private String HandlerMessageName;
    public ListService(String HandlerMessageName){
        this.HandlerMessageName=HandlerMessageName;
    }
    public void run() {
        Consumer consumer = MessageQueueFactory.getConsumer(HandlerMessageName);
        final Producer producer = MessageQueueFactory.getProducer(Util.getSendUrlDetailedMessageName());
        consumer.startMessage(new HandMessage() {
            public void handMessage(String s) {

            }
            public void handMessage(Serializable serializable) {
                CheBean cheBean = (CheBean) serializable;
//                System.out.println(cheBean.getCheName());
//                String sourceID = cheBean.getSourceID();
//                if (sourceID.equals("5")){
//                    DBSourceInterface dbsource = new DBSource("tbl_che168_car");
//                    boolean carExist = dbsource.isCarExist(cheBean.getUrl());
//                    if (carExist){
//                        //存在
//                        double shouJia = Double.parseDouble(cheBean.getShouJia());
//                        double carPrice = Double.parseDouble(dbsource.isCarPrice(cheBean.getShouJia()));
//                        //判断最新的售价是否和数据库中的售价相同
//                        if (carPrice!=shouJia){
//                            //如果不同，判断谁大于谁
//                            if (carPrice>shouJia){
//                                //如果数据库中的大于最新的
//                                //降价了
//                                //更新数据库
//                                //发送消息
//                            }else {
//                                //如果最新的大于数据库中的
//                                //涨价了
//                                //更新数据库
//                                //发送消息
//                            }
//                        }
//                        String shiFouShangXing = cheBean.getShiFouShangXing();
//                        if (shiFouShangXing.equals("2")){
//                            //如果不是上新的，通过url查询数据库中的值
//                            String carNews = dbsource.isCarNews(cheBean.getUrl());
//                            if (carNews.equals("1")){
//                                //如果数据库中值是上新的，则取消上新
//                                //发送消息
//                                //更新数据库
//                            }
//                        }
//                    }else {
                        //不存在
                        //将bean发送给消息队列
                MessageMode messageMode = new MessageMode();
                messageMode.setSourceID(cheBean.getSourceID());
                messageMode.setMode(cheBean.getUrl());
                System.out.println(cheBean.getSourceID());
                producer.sendObjectMessage(messageMode);
//                    }
//                }
            }
        });
    }

    public static void main(String[] args) {
        ListService ListService = new ListService(Util.getHandResultMessageName());
        ListService.run();
    }
}

