package io.sumac.templateengine.core;

import java.util.Collection;
import java.util.function.Function;

public interface TemplateRule<T> extends Function<T, Collection<String>> {
}
