package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyObjectFactory {
    private Reflections scanner = new Reflections("mySpring");
    private MyMyConfigImpl myConfigImpl = new MyMyConfigImpl();
    private List<ObjectConfigure> objectConfigures = new ArrayList<>();

    private static MyObjectFactory myInstance = new MyObjectFactory();

    public static MyObjectFactory getInstance() {
        return myInstance;
    }

    @SneakyThrows
    public MyObjectFactory() {
        Set<Class<? extends ObjectConfigure>> classes = scanner.getSubTypesOf(ObjectConfigure.class);
        for (Class<? extends ObjectConfigure> configuratedClass : classes) {
            objectConfigures.add(configuratedClass.newInstance());
        }

    }

    public <T> T createObject(Class<T> type) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        resolveImpl(type);

        T t = type.newInstance();
        configure(t);

        invokeInitMethods(type, t);

        return t;
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = myConfigImpl.getImpl(type);
        }
        return type;
    }

    private <T> void configure (T t) {
        objectConfigures.forEach(objectConfigure -> objectConfigure.configure(t));
    }

    private  <T> void invokeInitMethods(Class<T> type, T t) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

}
