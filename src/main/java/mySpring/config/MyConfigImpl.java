package mySpring.config;

import mySpring.model.Friend;
import mySpring.model.GirlFriend;

import java.util.HashMap;
import java.util.Map;

public class MyConfigImpl implements MyConfig {
    private Map<Class, Class> interfaceToImplMapping = new HashMap<>();

    public MyConfigImpl() {
        interfaceToImplMapping.put(Friend.class, GirlFriend.class); //ToDo Only for Demo
    }

    public void bind(Class someInterface, Class someImplementation) {
        interfaceToImplMapping.put(someInterface, someImplementation);
    }

    @Override
    public <T> Class<T> getImpl(Class<T> type) {
        return interfaceToImplMapping.get(type);
    }
}
