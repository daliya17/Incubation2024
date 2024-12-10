package CoreJava.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS) // Retained at compile time
@Target(ElementType.METHOD)
public @interface Version {
  double number();
  String description() default "";
}
