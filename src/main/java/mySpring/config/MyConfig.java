package mySpring.config;

public interface MyConfig {
    <T> Class<T> getImpl(Class<T> type);
}
