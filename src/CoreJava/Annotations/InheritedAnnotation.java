package CoreJava.Annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(java.lang.annotation.ElementType.TYPE)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited  // This annotation is inherited by subclasses
public @interface InheritedAnnotation {
    String info() default "default info";
}
