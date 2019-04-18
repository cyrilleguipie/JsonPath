package com.gg.jsonpath.matchers;

import com.gg.jsonpath.matchers.helpers.ResourceHelpers;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

import static com.gg.jsonpath.matchers.JsonPathMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@Ignore
public class DemoTest {
    @Test
    public void shouldFailOnJsonString() {
        String json = ResourceHelpers.resource("books.json");
        assertThat(json, isJson(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnJsonFile() {
        File json = ResourceHelpers.resourceAsFile("books.json");
        assertThat(json, isJson(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnInvalidJsonString() {
        String json = ResourceHelpers.resource("invalid.json");
        assertThat(json, isJson(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnInvalidJsonFile() {
        File json = ResourceHelpers.resourceAsFile("invalid.json");
        assertThat(json, isJson(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnTypedJsonString() {
        String json = ResourceHelpers.resource("books.json");
        assertThat(json, isJsonString(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnTypedJsonFile() {
        File json = ResourceHelpers.resourceAsFile("books.json");
        assertThat(json, isJsonFile(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnTypedInvalidJsonString() {
        String json = ResourceHelpers.resource("invalid.json");
        assertThat(json, isJsonString(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnTypedInvalidJsonFile() {
        File json = ResourceHelpers.resourceAsFile("invalid.json");
        assertThat(json, isJsonFile(withJsonPath("$.store.name", equalTo("The Shop"))));
    }

    @Test
    public void shouldFailOnNonExistingJsonPath() {
        String json = ResourceHelpers.resource("books.json");
        assertThat(json, hasJsonPath("$.not-here"));
    }

    @Test
    public void shouldFailOnExistingJsonPath() {
        String json = ResourceHelpers.resource("books.json");
        assertThat(json, hasNoJsonPath("$.store.name"));
    }

    @Test
    public void shouldFailOnExistingJsonPathAlternative() {
        String json = ResourceHelpers.resource("books.json");
        assertThat(json, isJson(withoutJsonPath("$.store.name")));
    }
}
