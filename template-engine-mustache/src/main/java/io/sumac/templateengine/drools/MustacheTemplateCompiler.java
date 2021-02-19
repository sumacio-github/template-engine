package io.sumac.templateengine.drools;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.sumac.templateengine.core.TemplateCompiler;
import io.sumac.templateengine.core.TemplateCompilerException;

import java.io.IOException;
import java.io.StringWriter;

public class MustacheTemplateCompiler implements TemplateCompiler {

    MustacheFactory factory = new DefaultMustacheFactory();

    @Override
    public String compile(Object facts, String resource) {
        try {
            Mustache mustache = factory.compile(resource);
            StringWriter writer = new StringWriter();
            mustache.execute(writer, facts).flush();
            return writer.toString();
        } catch (IOException e) {
            throw new TemplateCompilerException(e);
        }
    }
}
