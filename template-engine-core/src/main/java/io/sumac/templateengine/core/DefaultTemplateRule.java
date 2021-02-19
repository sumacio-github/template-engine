package io.sumac.templateengine.core;

import java.util.*;

public class DefaultTemplateRule<Object> implements TemplateRule<Object> {

    private final String templateName;

    private DefaultTemplateRule(String templateName) {
        this.templateName = templateName;
    }

    public static <Object> TemplateRule<Object> template(String templateName) {
        return new DefaultTemplateRule<>(templateName);
    }

    @Override
    public Collection<String> apply(Object object) {
        return Collections.singletonList(templateName);
    }


//    private final String templateName;
//
//    private DefaultTemplateRule(String templateName) {
//        this.templateName = templateName;
//    }
//
//    public static <T> TemplateRule<T> template(String templateName, Class<T> type) {
//        return new DefaultTemplateRule<>(templateName);
//    }
//
//    @Override
//    public Set<String> apply(T object) {
//        var result = new HashSet<String>();
//        result.add(templateName);
//        return result;
//    }
}
