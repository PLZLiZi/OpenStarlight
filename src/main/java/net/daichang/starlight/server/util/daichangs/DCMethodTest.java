package net.daichang.starlight.server.util.daichangs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface DCMethodTest {
    String name();

    Class<?> clazz();
}
