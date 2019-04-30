package mySpring;

import java.util.HashMap;
import java.util.Map;

public class MyMyConfigImpl implements MyConfig {
    private Map<Class, Class> interfaceToImplMapping = new HashMap<>();

    public MyMyConfigImpl() {
        interfaceToImplMapping.put(Friend.class, GirlFriend.class);
    }

    public void bind(Class someInterface, Class someImplementation) {
        interfaceToImplMapping.put(someInterface, someImplementation);
    }

    @Override
    public <T> Class<T> getImpl(Class<T> type) {
        return interfaceToImplMapping.get(type);
    }
}
