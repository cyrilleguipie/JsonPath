package com.gg.jsonpath.matchers;

import com.gg.jsonpath.JsonPath;
import com.gg.jsonpath.ReadContext;
import org.junit.Test;

import static com.gg.jsonpath.matchers.JsonPathMatchers.withoutJsonPath;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WithoutJsonPathTest {
    private static final String JSON_STRING = "{" +
            "\"name\": \"Jessie\"," +
            "\"flag\": false," +
            "\"empty_array\": []," +
            "\"empty_object\": {}," +
            "\"none\": null" +
            "}";
    private static final ReadContext JSON = JsonPath.parse(JSON_STRING);

    @Test
    public void shouldMatchNonExistingJsonPath() {
        assertThat(JSON, withoutJsonPath(JsonPath.compile("$.not_there")));
        assertThat(JSON, withoutJsonPath("$.not_there"));
    }

    @Test
    public void shouldNotMatchExistingJsonPath() {
        assertThat(JSON, not(withoutJsonPath(JsonPath.compile("$.name"))));
        assertThat(JSON, not(withoutJsonPath("$.name")));
        assertThat(JSON, not(withoutJsonPath("$.flag")));
        assertThat(JSON, not(withoutJsonPath("$.empty_array")));
        assertThat(JSON, not(withoutJsonPath("$.empty_object")));
        assertThat(JSON, not(withoutJsonPath("$.none")));
    }

    @Test
    public void shouldBeDescriptive() {
        assertThat(withoutJsonPath("$.name"),
                hasToString(equalTo("without json path \"$['name']\"")));
    }

}
