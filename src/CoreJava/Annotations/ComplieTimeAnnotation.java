package CoreJava.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.SOURCE)
@Target(java.lang.annotation.ElementType.TYPE)
public @interface ComplieTimeAnnotation {
    String compiler() default "unknown";
}
