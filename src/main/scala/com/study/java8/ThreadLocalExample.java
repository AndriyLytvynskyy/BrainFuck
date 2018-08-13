package com.study.java8;
/*
        You may wonder that each thread outputs exactly the value that it gets through the constructor although the variable threadLocal is declared static.
        ThreadLocal’s internal implementation makes sure that every time you call set() the given value is stored within a memory region that only the current thread has access to.
        Hence when you call afterwards get() you retrieve the value you have set before, despite the fact that in the meantime other threads may have called set().
 */

/**
 * Application servers in the Java EE world make heavy usage of the ThreadLocal feature as you have many parallel threads but each thread has for example its own transaction or security context.
 * As you don’t want to pass these objects within each method invocation, you simply store it in the thread’s own memory and access it later when you need it.
 */
public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private final int value;

    public ThreadLocalExample(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        threadLocal.set(value);
        Integer integer = threadLocal.get();
        System.out.println("[" + Thread.currentThread().getName() + "]: " + integer);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ThreadLocalExample(i), "thread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }
}
