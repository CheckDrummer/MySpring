package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class AutowiredByTypeObjectConfigurer implements ObjectConfigure{

    @SneakyThrows
    @Override
    public void configure(Object o) {
        Class<?> type = o.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutowiredByType.class)) {
                field.setAccessible(true);
                Object object = MyObjectFactory.getInstance().createObject(field.getType());
                field.set(o, object);
            }
        }
    }
}
