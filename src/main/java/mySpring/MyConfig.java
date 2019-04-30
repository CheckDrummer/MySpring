package mySpring;

public interface MyConfig {
    <T> Class<T> getImpl(Class<T> type);
}
