package com.study.java8;

/**
 * Created by Andrii_Lytvynskyi on 8/18/2015.
 */
interface Strategy{
     public ReturnInterface sayHello();
}

interface ReturnInterface{

}

class CountInterfaceProduct implements ReturnInterface{

}



class StrategyExecutor {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
public class MethodReference {
    public static void main(String[] args) {
        StrategyExecutor executor = new StrategyExecutor();
        executor.setStrategy(CountInterfaceProduct::new);
    }
}
