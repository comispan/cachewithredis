package com.eugenephua.cachewithredis.service;

import com.eugenephua.cachewithredis.controller.request.SearchRequestV1;
import com.eugenephua.cachewithredis.controller.response.SearchResponseV1;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Cacheable(value = "customerCache", keyGenerator="customKeyGenerator",
            condition = "#requestV1.getIsPublic() == true")
    public SearchResponseV1 searchV1(SearchRequestV1 requestV1) {

        SearchResponseV1 responseV1 = new SearchResponseV1();
        responseV1.setResult(requestV1.getDatabase() + "_" + requestV1.getQuery());
        responseV1.setResultCode("20");

        return responseV1;
    }
}
