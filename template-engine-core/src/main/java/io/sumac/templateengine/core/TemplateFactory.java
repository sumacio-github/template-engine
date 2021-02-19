package io.sumac.templateengine.core;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TemplateFactory<T> {

    private final TemplateCompiler compiler;
    private final TemplateRule<T> rule;

    private TemplateFactory(TemplateRule<T> rule, TemplateCompiler compiler) {
        this.rule = rule;
        this.compiler = compiler;
    }

    public static TemplateFactory<Object> compiler(String templateName, TemplateCompiler compiler) {
        return new TemplateFactory<>(DefaultTemplateRule.template(templateName), compiler);
    }

    public static <T> TemplateFactory<T> compiler(TemplateRule<T> rule, TemplateCompiler compiler) {
        return new TemplateFactory<>(rule, compiler);
    }

    public Map<String, String> eval(T facts) {
        var results = new HashMap<String, String>();
        rule.apply(facts).forEach(template -> results.put(template, compiler.compile(facts, template)));
        return results;
    }

}
