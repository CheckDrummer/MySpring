package mySpring.model;

import mySpring.dependencyInjection.autowire.AutowiredByType;

import javax.annotation.PostConstruct;

public class JonSnow {

    @AutowiredByType
    private Friend girlFriend;

    @PostConstruct
    public void init() {
        System.out.println("Winter is coming");
        girlFriend.speak();
    }

    public void speak() {
        System.out.println("You are McQueen");
    }

}
