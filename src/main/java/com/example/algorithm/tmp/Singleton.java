package com.example.algorithm.tmp;

/**
 * @Description : TODO
 * @Author : young
 * @Date : 2022-07-20 10:49
 * @Version : 1.0
 **/
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
