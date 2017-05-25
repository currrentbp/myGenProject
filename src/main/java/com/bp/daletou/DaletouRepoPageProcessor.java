package com.bp.daletou;

import com.alibaba.fastjson.JSON;
import com.bp.util.all.StringUtil;
import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by issuser on 2017/5/23.
 */
public class DaletouRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public static void main(String[] args) {
        Spider.create(new DaletouRepoPageProcessor()).addUrl("http://baidu.lecai.com/lottery/draw/list/1/?agentId=5599").thread(5).run();
    }

    public void process(Page page) {
        List<String> historys = page.getHtml().css("table.historylist > tbody > tr").all();
        for (String history : historys) {
            String aLabel = StringUtil.getALabel(history).get(0);

        }
    }

    public Site getSite() {
        return site;
    }



}
