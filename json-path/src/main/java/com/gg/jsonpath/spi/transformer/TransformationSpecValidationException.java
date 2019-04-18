package com.gg.jsonpath.spi.transformer;

import com.gg.jsonpath.JsonPathException;

public class TransformationSpecValidationException extends JsonPathException {

    public TransformationSpecValidationException(Throwable cause) {
        super(cause);
    }

    public TransformationSpecValidationException(String message) {
        super(message);
    }
}
