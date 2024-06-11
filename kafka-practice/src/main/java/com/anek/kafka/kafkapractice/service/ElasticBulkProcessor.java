package com.anek.kafka.kafkapractice.service;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.client.RestClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ElasticBulkProcessor {

    //@KafkaListener(topics = "isearch-topic-dlt",groupId = "isearch-consumer-dlt")
    public void bulkProcessor(){
        System.out.println("****** started bulklistener ****");
        // Initialize the REST client
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost("localhost", 9092, "http")));

            BulkProcessor.Listener listener = new BulkProcessor.Listener() {
                @Override
                public void beforeBulk(long executionId, BulkRequest request) {
                    int numberOfActions = request.numberOfActions();
                    System.out.println("Executing bulk [{}] with {} requests"+executionId+","+numberOfActions);
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request,
                                      BulkResponse response) {
                    if (response.hasFailures()) {
                        System.out.println("Bulk [{}] executed with failures: {}"+ executionId+","+response.buildFailureMessage());
                    } else {
                        for(var r : response.getItems()){
                            System.out.println("response"+r.getResponse().toString());
                        }

                        System.out.println("Bulk [{}] completed in {} milliseconds"+executionId+","+ response.getTook().millis());
                    }
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request,
                                      Throwable failure) {
                    System.err.println("Failed to execute bulk: " + failure);
                }
            };

            BulkProcessor.Builder builder = BulkProcessor.builder(
                    (request, bulkListener) ->
                            client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
                    listener);

            builder.setBulkActions(1); // Set maximum actions per bulk request
            builder.setBulkSize(new ByteSizeValue(1L, ByteSizeUnit.MB)); // Set maximum size per bulk request
            builder.setFlushInterval(TimeValue.timeValueSeconds(1)); // Flush the bulk requests every 10 seconds
            builder.setConcurrentRequests(1); // Set the number of concurrent requests

            BulkProcessor bulkProcessor = builder.build();

            // Use bulkProcessor to add indexing requests
            // Example:
            // IndexRequest one = new IndexRequest("posts").id("1").source(XContentType.JSON,"field", "value");
            // bulkProcessor.add(one);

            // Flush any remaining requests
            bulkProcessor.flush();

            // Await close (here, 30 seconds to complete all pending operations)
            bulkProcessor.awaitClose(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while waiting to close BulkProcessor");
        }
    }

   // @KafkaListener(topics = "isearch-topic-dlt",groupId = "isearch-consumer-dlt")
    void main(){

    }
    public void bulkProcessorListener() throws IOException {
        System.out.println("****** started bulkProcessorListener ****");

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost",9092,"http")
        ) .setRequestConfigCallback(
                requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(5000)
                        .setSocketTimeout(60000)
        ));
        BulkRequest bulkRequest = new BulkRequest();

        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("test");
        indexRequest.id(String.valueOf(1));
        indexRequest.source(Map.of("field-1","doc-1"));

        IndexRequest indexRequest2 = new IndexRequest();
        indexRequest2.index("test");
        indexRequest2.id(String.valueOf(2));
        indexRequest2.source(Map.of("field-2","doc-2"));


        bulkRequest.add(indexRequest);
        bulkRequest.add(indexRequest2);

        try{
            BulkResponse response = restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);
            for(BulkItemResponse bulkResponse : response.getItems()){
                IndexResponse indexResponse = bulkResponse.getResponse();
                System.out.println(indexResponse);
            }

        }catch (Exception ex){
                ex.printStackTrace();
        }



        //restHighLevelClient.close();

    }
}
