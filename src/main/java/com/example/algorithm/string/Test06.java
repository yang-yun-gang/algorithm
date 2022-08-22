package com.example.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 621. 任务调度器
 * @Author : young
 * @Date : 2022-08-18 10:54
 * @Version : 1.0
 **/
public class Test06 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            cntMap.put(c, 0);
        }

        int spend = 0;
        for (char c : map.keySet()) {

        }

        return 0;
    }
}
