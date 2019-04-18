package com.gg.jsonpath.matchers;

import com.gg.jsonpath.JsonPath;
import com.gg.jsonpath.JsonPathException;
import com.gg.jsonpath.ReadContext;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class WithoutJsonPath extends TypeSafeDiagnosingMatcher<ReadContext> {
    private final JsonPath jsonPath;

    public WithoutJsonPath(JsonPath jsonPath) {
        this.jsonPath = jsonPath;
    }

    @Override
    protected boolean matchesSafely(ReadContext actual, Description mismatchDescription) {
        try {
            Object value = actual.read(jsonPath);
            mismatchDescription
                    .appendText(jsonPath.getPath())
                    .appendText(" was evaluated to ")
                    .appendValue(value);
            return false;
        } catch (JsonPathException e) {
            return true;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("without json path ").appendValue(jsonPath.getPath());
    }
}
