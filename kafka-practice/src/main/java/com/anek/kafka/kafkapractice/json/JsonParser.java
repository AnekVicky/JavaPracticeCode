package com.anek.kafka.kafkapractice.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Map;

public class JsonParser {
    public static void main(String[] args) {
    String json = """
            [
                {
                    "client": "GLOBAL_SEARCH",
                    "reqestPayload": {
                        "fileId": "12345",
                        "storageId":"IVAULT",
                        "clientAttributes": {
                            "ocr": "true",
                            "global_search": "true"
                        }
                    }
                },
                 {
                    "client": "CREDIT_LIBRARY",
                    "reqestPayload": {
                        "fileId": "345",
                        "storageId":"IVAULT",
                        "clientAttributes": {
                            "ocr": "true",
                            "global_search": "true"
                        }
                    }
                }
                ]
            """;
        try {
            ObjectMapper mapper = new ObjectMapper();
            DCRequestCommnad[] requestDataArray = mapper.readValue(json, DCRequestCommnad[].class);

            for (DCRequestCommnad requestData : requestDataArray) {
                System.out.println("client : "+requestData.getClient());
                System.out.println(""+requestData.getReqestPayload());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

enum DCClient{
    GLOBAL_SEARCH,CREDIT_LIBRARY
}
enum IsearchRequestAttribute{
    GLOBAL_SEARCH,OCR
}
@Data
class DCRequestCommnad {
    private DCClient client;
    private Payload reqestPayload;
}

class Payload {
    private String fileId;
    private String storageId;

    public Payload(){}
    // Getters and setters
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "fileId='" + fileId + '\'' +
                ", storageId='" + storageId + '\'' +
                '}';
    }
}
class IsearchRequest extends Payload{
    Map<IsearchRequestAttribute,String> clientAttributes ;

    @Override
    public String toString() {
        return "IsearchRequest{" +
                "fileId='" + this.getFileId() + '\'' +
                ", storageId='" + this.getStorageId() + '\'' +
                "clientAttributes=" + clientAttributes +
                '}';
    }
}



