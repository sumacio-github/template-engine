package io.sumac.templateengine.sample;

import io.sumac.templateengine.core.DefaultTemplateRule;
import io.sumac.templateengine.core.TemplateFactory;
import io.sumac.templateengine.drools.MustacheTemplateCompiler;

public class Main {
    public static void main(String[] args) {
        var factory = TemplateFactory.compiler("hello.mustache", new MustacheTemplateCompiler());
//        Function<Person, Optional<String>> helloRule = fact -> {
//            //Person person = (Person) fact;
//            if (fact.getName().equals("mike") || fact.getName().equals("nate"))
//                return Optional.of("hello.mustache");
//            return Optional.empty();
//        };
//        Function<Object, Optional<String>> goodbyeRule = fact -> {
//            Person person = (Person) fact;
//            if (person.getName().equals("tim") || person.getName().equals("nate"))
//                return Optional.of("goodbye.mustache");
//            return Optional.empty();
//        };
//
        factory.eval(new Person("nate", 62)).forEach((k,v) -> System.out.println(k + " > " + v));

    }

    public static class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
