package com.bp.daletou;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by issuser on 2017/5/23.
 */
public class DaletouRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public static void main(String[] args) {
        Spider.create(new DaletouRepoPageProcessor()).addUrl("http://baidu.lecai.com/lottery/draw/list/1/?agentId=5599").thread(5).run();
    }

    public void process(Page page) {
        List<String> historys = page.getHtml().css("table.historylist tbody tr").all();
        for (String history : historys) {
            System.out.println("===>source:" + JSON.toJSONString(history));
            System.out.println("===>now:" + JSON.toJSONString(removeWithoutEM(removeAllDisVisualChar(history))));
        }
    }

    public Site getSite() {
        return site;
    }

    public String removeAllDisVisualChar(String resourceStr) {
        return resourceStr.replaceAll("\\s", "");
    }

    public String removeWithoutEM(String resourceStr) {
        return resourceStr.replaceAll("<(?!em).*?>", "");
    }

}
