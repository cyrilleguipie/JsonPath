package com.gg.jsonpath.internal;

import com.gg.jsonpath.Configuration.Defaults;
import com.gg.jsonpath.Option;
import com.gg.jsonpath.spi.json.JsonProvider;
import com.gg.jsonpath.spi.json.JsonSmartJsonProvider;
import com.gg.jsonpath.spi.mapper.JsonSmartMappingProvider;
import com.gg.jsonpath.spi.mapper.MappingProvider;
import com.gg.jsonpath.spi.transformer.TransformationProvider;
import com.gg.jsonpath.spi.transformer.jsonpathtransformer.JsonPathTransformationProvider;

import java.util.EnumSet;
import java.util.Set;

public final class DefaultsImpl implements Defaults {

  public static final DefaultsImpl INSTANCE = new DefaultsImpl();

  private final MappingProvider mappingProvider = new JsonSmartMappingProvider();

  @Override
  public JsonProvider jsonProvider() {
    return new JsonSmartJsonProvider();
  }

  @Override
  public Set<Option> options() {
    return EnumSet.noneOf(Option.class);
  }

  @Override
  public MappingProvider mappingProvider() {
    return mappingProvider;
  }

  @Override
  public TransformationProvider transformationProvider() {
    return new JsonPathTransformationProvider();
  }

  private DefaultsImpl() {
  }

}
