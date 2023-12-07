package com.eugenephua.cachewithredis.controller.request;

import lombok.Data;

@Data
public class SearchRequestV1 {

    private String database;
    private String query;
    private Boolean isPublic;
}
