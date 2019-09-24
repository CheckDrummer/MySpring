package mySpring.dependencyInjection.autowire;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface AutowiredByType {
}
