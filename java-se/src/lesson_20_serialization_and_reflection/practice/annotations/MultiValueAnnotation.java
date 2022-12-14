package lesson_20_serialization_and_reflection.practice.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MultiValueAnnotation {

    int value() default 0;

    int value2() default 20;

    String value3() default "";
}
