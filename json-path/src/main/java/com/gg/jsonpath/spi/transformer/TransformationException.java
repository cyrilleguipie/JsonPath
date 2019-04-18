package com.gg.jsonpath.spi.transformer;

import com.gg.jsonpath.JsonPathException;

public class TransformationException extends JsonPathException {

    public TransformationException(Throwable cause) {
        super(cause);
    }

    public TransformationException(String message) {
        super(message);
    }
}