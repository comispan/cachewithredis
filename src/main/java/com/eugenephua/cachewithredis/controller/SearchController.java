package com.eugenephua.cachewithredis.controller;

import com.eugenephua.cachewithredis.controller.request.SearchRequestV1;
import com.eugenephua.cachewithredis.controller.response.SearchResponseV1;
import com.eugenephua.cachewithredis.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    @Cacheable(value = "itemCache")
    public String search(@RequestParam(name="q")String query) {
        log.info("GET search called");
        return "book-search-" + query;
    }

    @PostMapping("/search/v1")
    public ResponseEntity<SearchResponseV1> createSearch(@RequestBody SearchRequestV1 searchRequest) {

        SearchResponseV1 responseV1 = searchService.searchV1(searchRequest);

        return new ResponseEntity<>(responseV1, HttpStatus.OK);
    }
}
