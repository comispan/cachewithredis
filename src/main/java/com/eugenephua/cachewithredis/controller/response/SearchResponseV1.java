package com.eugenephua.cachewithredis.controller.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchResponseV1 {

    private String resultCode;
    private String result;
}
