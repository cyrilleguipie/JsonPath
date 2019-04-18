package com.gg.jsonpath.spi.cache;

import com.gg.jsonpath.InvalidJsonException;
import com.gg.jsonpath.JsonPath;

public interface Cache {

	/**
     * Get the Cached JsonPath
     * @param key cache key to lookup the JsonPath
     * @return JsonPath
     */
	public JsonPath get(String key);
	
	/**
     * Add JsonPath to the cache
     * @param key cache key to store the JsonPath
     * @param value JsonPath to be cached
     * @return void
     * @throws InvalidJsonException
     */
	public void put(String key, JsonPath value);
}
