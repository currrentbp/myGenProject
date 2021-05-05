package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * es的查询util
 * https://www.kaifaxueyuan.com/server/elasticsearch7/elasticsearch-java-document-new-index-api.html
 * 注意，本方法使用于es7
 *
 * @author baopan
 * @createTime 20210428
 */
public class ElasticSearchSevenUtil {
    private String clusterName = "CollectorDBCluster";
    private String esHost = "192.168.137.149";
    private int esPort = 9200;
    private final String defaultIndex = "currentbp";

    public void insert(Object obj) {
        try {
            Object id = ClassUtil.getValue(obj, "id");
            insert(obj, null, id.toString());
        } catch (Exception e) {
            System.out.println("ElasticSearchSevenUtil, getId is error, obj:" + JSON.toJSONString(obj)+" errorMsg:"+e.getMessage());
        }
    }

    public void insert(Object obj, String id) {
        insert(obj, null, id);
    }

    public void insert(Object obj, String index, String id) {
        if (obj == null) {
            return;
        }
        if (StringUtil.isEmpty(index)) {
            index = defaultIndex;
        }
        try {
            System.out.println("===>index:" + index);
            IndexRequest request = new IndexRequest(index); //索引
            request.id(id); //文档id
            String jsonString = JSON.toJSONString(obj);
            System.out.println("===>jsonString:" + jsonString);
            request.source(jsonString, XContentType.JSON); //以字符串形式提供的文档源
            request.opType("create"); //操作类型 可选create或update


            IndexResponse indexResponse = getClient().index(request, RequestOptions.DEFAULT);
            RestStatus status = indexResponse.status();
            System.out.println("insertObject4es status:" + JSON.toJSONString(status));
        } catch (Exception e) {
            System.out.println("insertObject4es is error!" + e.getMessage());
        }
    }

    public void queryById(String index,String id){
        RestHighLevelClient client = getClient();
    }

    public void query(String index, String type) {

    }

    public RestHighLevelClient getClient() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(esHost, esPort, "http")));
        return client;
    }
}
