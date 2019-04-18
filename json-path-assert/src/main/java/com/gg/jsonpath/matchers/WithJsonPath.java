package com.gg.jsonpath.matchers;

import com.gg.jsonpath.JsonPath;
import com.gg.jsonpath.JsonPathException;
import com.gg.jsonpath.PathNotFoundException;
import com.gg.jsonpath.ReadContext;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class WithJsonPath<T> extends TypeSafeMatcher<ReadContext> {
    private final JsonPath jsonPath;
    private final Matcher<T> resultMatcher;

    public WithJsonPath(JsonPath jsonPath, Matcher<T> resultMatcher) {
        this.jsonPath = jsonPath;
        this.resultMatcher = resultMatcher;
    }

    @Override
    protected boolean matchesSafely(ReadContext context) {
        try {
            T value = context.read(jsonPath);
            return resultMatcher.matches(value);
        } catch (JsonPathException e) {
            return false;
        }
    }

    public void describeTo(Description description) {
        description
                .appendText("with json path ")
                .appendValue(jsonPath.getPath())
                .appendText(" evaluated to ")
                .appendDescriptionOf(resultMatcher);
    }

    @Override
    protected void describeMismatchSafely(ReadContext context, Description mismatchDescription) {
        try {
            //with java 8, compilation fails saying ambiguous jsonPath.read
            T value = jsonPath.read((Object)context.json());
            mismatchDescription
                    .appendText("json path ")
                    .appendValue(jsonPath.getPath())
                    .appendText(" was evaluated to ")
                    .appendValue(value);
        } catch (PathNotFoundException e) {
            mismatchDescription
                    .appendText("json path ")
                    .appendValue(jsonPath.getPath())
                    .appendText(" was not found in ")
                    .appendValue(context.json());
        } catch (JsonPathException e) {
            mismatchDescription
                    .appendText("was ")
                    .appendValue(context.json());
        }
    }

}
