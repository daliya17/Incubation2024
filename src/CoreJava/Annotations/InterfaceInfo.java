package CoreJava.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(java.lang.annotation.ElementType.TYPE)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface InterfaceInfo {
    String description() default "default description";
    String version();
}
