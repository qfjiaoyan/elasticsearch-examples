package com.qianfeng.elasticsearch.test.document;

import com.qianfeng.elasticsearch.SearchServiceApplication;
import com.qianfeng.elasticsearch.query.HighLightQuery;
import com.qianfeng.elasticsearch.query.SortQuery;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SearchServiceApplication.class)
@WebAppConfiguration
public class SortQueryTest {
    private String indexName = "sms-logs-index";
    private String type = "sms_logs_type";

    @Autowired
    private SortQuery sortQuery;

    //默认排序
    @Test
    public void testSortQueryByDefault() throws IOException {
        sortQuery.queryMatch(indexName,type,"smsContent","中国银行");
    }

    //条件排序
    @Test
    public void testSortQueryBySort() throws IOException {
        sortQuery.sortQuery(indexName,type,"smsContent","中国银行","replyTotal", SortOrder.DESC);
    }

    //多条件排序
    @Test
    public void testSortQueryByMultSort() throws IOException {
        sortQuery.multSortQuery(indexName,type,"smsContent","中国银行","replyTotal","province", SortOrder.DESC);
    }
}
