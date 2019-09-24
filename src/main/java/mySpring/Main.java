package mySpring;

import mySpring.dependencyInjection.objectFactory.MyObjectFactory;
import mySpring.model.JonSnow;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        MyObjectFactory factory = MyObjectFactory.getInstance();
        JonSnow jonSnow = factory.createObject(JonSnow.class);
        jonSnow.speak();
    }

}
