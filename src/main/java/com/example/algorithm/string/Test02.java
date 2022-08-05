package com.example.algorithm.string;

/**
 * @Description : 剑指 Offer 05. 替换空格
 * @Author : young
 * @Date : 2022-08-04 10:17
 * @Version : 1.0
 **/
public class Test02 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        Test02 test = new Test02();
        System.out.println(test.replaceSpace("We are happy."));
    }
}
