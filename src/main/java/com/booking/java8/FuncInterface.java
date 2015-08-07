package com.booking.java8;

/**
 * Created by Andrii_Lytvynskyi on 7/15/2015.
 */
@FunctionalInterface
public interface FuncInterface {
    public void hello();
    // public void hello2();

    default public void hello1(){
        System.out.println("This is the default method of functional interface");
    }


}
