package com.tang.es;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author tcs
 * @date 2022-09-14  14:30
 */
@SpringBootTest
public class ElasticSearchTest {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 删除索引库
     */
    @Test
    public void testDelIndex() throws IOException {
        // 操作索引的对象
        IndicesClient indices = client.indices();
        // 删除索引的请求
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("ysx_course");
        // 删除索引
        AcknowledgedResponse delete = indices.delete(deleteIndexRequest, RequestOptions.DEFAULT);
        // 得到响应
        boolean b = delete.isAcknowledged();
        System.out.println(b);
    }

    @Test
    public void testAddIndex() throws IOException {
        // 操作索引的对象
        IndicesClient indices = client.indices();
        // 创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("ysx_course");
        request.settings(Settings.builder().put("number_of_shards", "1").put("number_of_replicas", "0"));
        // 创建映射
        request.mapping("doc", "{\n" +
                "                \"properties\": {\n" +
                "                    \"description\": {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"analyzer\": \"ik_max_word\",\n" +
                "                        \"search_analyzer\": \"ik_smart\"\n" +
                "                    },\n" +
                "                    \"name\": {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"analyzer\": \"ik_max_word\",\n" +
                "                        \"search_analyzer\": \"ik_smart\"\n" +
                "                    },\n" +
                "\"pic\":{                    \n" +
                "\"type\":\"text\",                        \n" +
                "\"index\":false                        \n" +
                "},                    \n" +
                "                    \"price\": {\n" +
                "                        \"type\": \"float\"\n" +
                "                    },\n" +
                "                    \"studymodel\": {\n" +
                "                        \"type\": \"keyword\"\n" +
                "                    },\n" +
                "                    \"timestamp\": {\n" +
                "                        \"type\": \"date\",\n" +
                "                        \"format\": \"yyyy-MM‐dd HH:mm:ss||yyyy‐MM‐dd||epoch_millis\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }", XContentType.JSON);


        // 执行创建操作
        CreateIndexResponse response = indices.create(request,RequestOptions.DEFAULT);
        // 得到响应
        boolean b = response.isAcknowledged();
        System.out.println(b);
    }
}
