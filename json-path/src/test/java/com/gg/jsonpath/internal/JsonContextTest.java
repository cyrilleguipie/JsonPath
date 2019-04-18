package com.gg.jsonpath.internal;

import com.gg.jsonpath.Criteria;
import com.gg.jsonpath.DocumentContext;
import com.gg.jsonpath.Filter;
import com.gg.jsonpath.JsonPath;
import com.gg.jsonpath.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class JsonContextTest extends BaseTest {

	@Test
    public void cached_path_with_predicates() {

        Filter feq = Filter.filter(Criteria.where("category").eq("reference"));
        Filter fne = Filter.filter(Criteria.where("category").ne("reference"));
        
        DocumentContext JsonDoc = JsonPath.parse(JSON_DOCUMENT);

        List<String> eq = JsonDoc.read("$.store.book[?].category", feq);
        List<String> ne = JsonDoc.read("$.store.book[?].category", fne);

        Assertions.assertThat(eq).contains("reference");
        Assertions.assertThat(ne).doesNotContain("reference");
    }

}
