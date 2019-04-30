package mySpring;

import javax.annotation.PostConstruct;

public class JonSnow {

    @AutowiredByType
    private GirlFriend girlFriend;

    @PostConstruct
    public void init() {
        System.out.println("Winter is coming");
        girlFriend.speak();
    }

    public void speak() {
        System.out.println("Winter is here");
    }

}
