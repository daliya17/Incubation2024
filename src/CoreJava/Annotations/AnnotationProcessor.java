package CoreJava.Annotations;

import java.lang.reflect.Field;

public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<?> userClass = User.class;

        // read @Entity annotation
        if(userClass.isAnnotationPresent(Entity.class)) {
            Entity entity = userClass.getAnnotation(Entity.class);
            System.out.println("Table Name: " + entity.tableName());
        }

        //read @Fieldinfo annotation
        try {
            Field nameField = userClass.getDeclaredField("name");
            if(nameField.isAnnotationPresent(FieldInfo.class)) {
                FieldInfo fieldInfo = nameField.getAnnotation(FieldInfo.class);
                System.out.println("Field Name: " + nameField.getName());
                System.out.println("Description: " + fieldInfo.description());
                System.out.println("Author: " + fieldInfo.author());
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // access inherited annotation on adminuser class
        Class<?> adminUserClass = AdminUser.class;
        if(adminUserClass.isAnnotationPresent(InheritedAnnotation.class)){
            InheritedAnnotation inheritedAnnotation = adminUserClass.getAnnotation(InheritedAnnotation.class);
            System.out.println("Inherited Annotation: " + inheritedAnnotation.info());
        }

        // access annotations applied to userOperations interface
        Class<?> interfaceClass = UserOperations.class;
        if(interfaceClass.isAnnotationPresent(InterfaceInfo.class)){
            InterfaceInfo interfaceInfo = interfaceClass.getAnnotation(InterfaceInfo.class);
            System.out.println("Interface Description: " + interfaceInfo.description());
            System.out.println("Interface Version: " + interfaceInfo.version());
        }

        // access compile time annotation (wont be available at runtime)
        Class<?> complieTimeAnnotationClass = CompileTimeClass.class;
        if(complieTimeAnnotationClass.isAnnotationPresent(ComplieTimeAnnotation.class)){
            ComplieTimeAnnotation complieTimeAnnotation = userClass.getAnnotation(ComplieTimeAnnotation.class);
            System.out.println("Complie Time Annotation: " + complieTimeAnnotation.compiler());
        }
     }
}
