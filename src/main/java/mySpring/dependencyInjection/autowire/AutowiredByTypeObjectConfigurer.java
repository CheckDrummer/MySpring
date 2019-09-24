package mySpring.dependencyInjection.autowire;

import lombok.SneakyThrows;
import mySpring.config.MyConfigImpl;
import mySpring.dependencyInjection.objectFactory.MyObjectFactory;

import java.lang.reflect.Field;

public class AutowiredByTypeObjectConfigurer implements ObjectConfigure{

    private MyConfigImpl myConfigImpl = new MyConfigImpl();

    @SneakyThrows
    @Override
    public void configure(Object o) {
        Class<?> type = o.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutowiredByType.class)) {
                field.setAccessible(true);
                Object object = MyObjectFactory.getInstance().createObject(resolveImpl(field.getType()));
                field.set(o, object);
            }
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = myConfigImpl.getImpl(type);
        }
        return type;
    }
}
