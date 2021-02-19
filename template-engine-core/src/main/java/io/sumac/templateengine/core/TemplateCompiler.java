package io.sumac.templateengine.core;

import java.io.IOException;

@FunctionalInterface
public interface TemplateCompiler {
    String compile(Object facts, String resource);
}
