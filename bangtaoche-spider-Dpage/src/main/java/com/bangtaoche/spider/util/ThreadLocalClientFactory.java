package com.bangtaoche.spider.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ImmediateRefreshHandler;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

import java.security.GeneralSecurityException;

public  class ThreadLocalClientFactory {
        
            //单例工厂模式
        private final static ThreadLocalClientFactory instance =new ThreadLocalClientFactory();
        
        public static ThreadLocalClientFactory getInstance(){
            return instance;
            }
        
        
        // 覆写ThreadLocal的initialValue方法
        //线程的本地实例存储器，用于存储WebClient实例
      private ThreadLocal<WebClient> client = new ThreadLocal<WebClient>() {
    
          @Override    
      //该方法ThreadLocal变量第一次get的时候执行,如果该线程已经执行过set方法，initialValue不会执行
      protected synchronized WebClient initialValue(){
          WebClient webclient = new WebClient(BrowserVersion.FIREFOX_3_6);
              webclient.setJavaScriptEnabled(true);
              webclient.setThrowExceptionOnScriptError(false);
              webclient.setCssEnabled(false);
              webclient.getCookieManager().clearCookies();
              webclient.getCache().clear();
              webclient.setRefreshHandler(new ImmediateRefreshHandler());
              webclient.setTimeout(30000);
              webclient.setJavaScriptTimeout(30000);
              webclient.setAjaxController(new NicelyResynchronizingAjaxController());
              webclient.setJavaScriptEnabled(true);
              webclient.setJavaScriptTimeout(30000);
              webclient.setRedirectEnabled(true);
              webclient.waitForBackgroundJavaScript(8000);
              webclient.setThrowExceptionOnScriptError(false);
              webclient.setThrowExceptionOnFailingStatusCode(false);
              try {
                  webclient.setUseInsecureSSL(true);
              } catch (GeneralSecurityException e) {
                  e.printStackTrace();
              }
              return webclient;
      }  
  };  
  
  public void setWebClient(WebClient wc) {
      client.set(wc);  
  }  
    
  public WebClient getWebClient() {
      return client.get();  
  } 
}