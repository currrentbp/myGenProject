package com.bp.util.all.htmlUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Node;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.SimpleNodeIterator;

/**
 * 解析HTML页面
 *
 * @author current_bp
 * @createTime 20170502
 */
public class ParseHtml {
    private static String ENCODE = "UTF-8";

    private static void message(String szMsg) {
        try {
            System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding")));
        } catch (Exception e) {
        }
    }

    public static String openFile(String szFileName) {
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(new File(szFileName)), ENCODE));
            String szContent = "";
            String szTemp;

            while ((szTemp = bis.readLine()) != null) {
                szContent += szTemp + "\n";
            }
            bis.close();
            return szContent;
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) {

        try {
            Parser parser = new Parser((HttpURLConnection) (
                    new URL("http://baidu.lecai.com/lottery/draw/list/1?type=range&start=0&end=14141")).openConnection());

            //迭代所有节点, null 表示不使用 NodeFilter
            NodeList list = parser.parse(null);
            //从初始的节点列表跌倒所有的节点
            String keyword = "historylist";
            processNodeList(list, keyword);
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }

    private static void processNodeList(NodeList list, String keyword) {
        //迭代开始
        SimpleNodeIterator iterator = list.elements();
        while (iterator.hasMoreNodes()) {
            Node node = iterator.nextNode();
            //得到该节点的子节点列表
            NodeList childList = node.getChildren();
            //孩子节点为空，说明是值节点
            if (null == childList) {
                //得到值节点的值
                String result = node.toPlainTextString();
                //节点的属性值
                String result1 = node.getText();
                if (result1.indexOf(keyword) != -1)
                    System.out.println("result1:" + result1);
                //若包含关键字，则简单打印出来文本
                if (result.indexOf(keyword) != -1)
                    System.out.println("result:" + result);
            } //end if
            //孩子节点不为空，继续迭代该孩子节点
            else {
                processNodeList(childList, keyword);
            }//end else
        }//end wile
    }
}
