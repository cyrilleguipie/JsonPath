package com.gg.jsonpath.spi.cache;

import com.gg.jsonpath.JsonPath;

public class NOOPCache implements Cache {

    @Override
    public JsonPath get(String key) {
        return null;
    }

    @Override
    public void put(String key, JsonPath value) {
    }
}
