package com.gg.jsonpath.internal.filter;

import com.gg.jsonpath.Predicate;

public interface Evaluator {
    boolean evaluate(ValueNode left, ValueNode right, Predicate.PredicateContext ctx);
}