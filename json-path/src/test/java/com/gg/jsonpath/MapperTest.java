package com.gg.jsonpath;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import static com.gg.jsonpath.JsonPath.parse;
import static org.assertj.core.api.Assertions.assertThat;

public class MapperTest extends BaseTest {


    @Test
    public void an_Integer_can_be_converted_to_a_Long() {
        Assertions.assertThat(JsonPath.parse("{\"val\": 1}").read("val", Long.class)).isEqualTo(1L);
    }

    @Test
    public void an_String_can_be_converted_to_a_Long() {
        Assertions.assertThat(JsonPath.parse("{\"val\": 1}").read("val", Long.class)).isEqualTo(1L);
    }

    @Test
    public void an_Integer_can_be_converted_to_a_String() {
        Assertions.assertThat(JsonPath.parse("{\"val\": 1}").read("val", String.class)).isEqualTo("1");
    }

    @Test
    public void an_Integer_can_be_converted_to_a_Double() {
        Assertions.assertThat(JsonPath.parse("{\"val\": 1}").read("val", Double.class)).isEqualTo(1D);
    }

    @Test
    public void a_BigDecimal_can_be_converted_to_a_Long() {
        Assertions.assertThat(JsonPath.parse("{\"val\": 1.5}").read("val", Long.class)).isEqualTo(1L);
    }

    @Test
    public void a_Long_can_be_converted_to_a_Date() {
        Date now = new Date();
        Assertions.assertThat(JsonPath.parse("{\"val\": "+now.getTime()+"}").read("val", Date.class)).isEqualTo(now);
    }

    @Test
    public void a_String_can_be_converted_to_a_BigInteger() {
        Assertions.assertThat(JsonPath.parse("{\"val\": \"1\"}").read("val", BigInteger.class)).isEqualTo(BigInteger.valueOf(1));
    }

    @Test
    public void a_String_can_be_converted_to_a_BigDecimal() {
        Assertions.assertThat(JsonPath.parse("{\"val\": \"1.5\"}").read("val", BigDecimal.class)).isEqualTo(BigDecimal.valueOf(1.5d));
    }

    @Test
    public void a_Boolean_can_be_converted_to_a_primitive_boolean() {
        Assertions.assertThat(JsonPath.parse("{\"val\": true}").read("val", boolean.class)).isTrue();
        Assertions.assertThat(JsonPath.parse("{\"val\": false}").read("val", boolean.class)).isFalse();
    }
}
