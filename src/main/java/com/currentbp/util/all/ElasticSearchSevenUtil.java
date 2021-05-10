package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.currentbp.common.model.Student;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.*;


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
            System.out.println("ElasticSearchSevenUtil, getId is error, obj:" + JSON.toJSONString(obj) + " errorMsg:" + e.getMessage());
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

    public <T> T queryById(String index, String id, Class<T> t) {
        RestHighLevelClient client = getClient();
        GetRequest getRequest = new GetRequest(index, id);
        try {
            GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
            String sourceAsString = response.getSourceAsString();
            System.out.println("queryById,source:" + sourceAsString);
            T t1 = JSON.parseObject(sourceAsString, t);
            return t1;
        } catch (Exception e) {
            System.out.println("queryById is error!index:" + index + ",id:" + id + ",msg:" + e.getMessage());
        }
        return null;
    }

    public <T> List<T> queryByCondition(String index, Class<T> t) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(1);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("logLevel", "INFO");
        BoolQueryBuilder boolq = QueryBuilders.boolQuery();
        boolq.must(matchQueryBuilder);
        searchSourceBuilder.query(boolq);

        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source(searchSourceBuilder);

        return queryByCondition(index, t, searchRequest);
    }

    public <T> List<T> queryByCondition(String index, Class<T> t, SearchRequest searchRequest) {
        RestHighLevelClient client = getClient();
        try {
            SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = search.getHits();
            Iterator<SearchHit> iterator = hits.iterator();
            List<T> result = new ArrayList<>();
            while (iterator.hasNext()) {
                SearchHit next = iterator.next();
                String sourceAsString = next.getSourceAsString();
                System.out.println("queryByCondition,source:" + sourceAsString);
                T t1 = JSON.parseObject(sourceAsString, t);
                result.add(t1);
            }
            return result;
        } catch (Exception e) {
            System.out.println("queryByCondition is error!index:" + index + ",msg:" + e.getMessage());
        }
        return null;
    }


    public RestHighLevelClient getClient() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(esHost, esPort, "http")));
        return client;
    }
}
