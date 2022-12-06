package com.createiq.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "requestData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestData {
    private String requestId;
    private Object object;
    
    
}
