## dfs + 剪枝
使用dfs暴力解题时(多半借用递归)，使用剪枝缩减大量时间。
比如：
- 力扣2305，给k个小孩分发饼干
- 力扣473，火柴拼正方形

这里的“分”饼干动作和“拿”火柴动作可以分离出来，单独作为一个方法action，完整代码见template01

```java
private void action(int[] possible, int p) {

        // bfs停止
        if (p < 0) {
            // ...
            return;
        }

        // 在这里进行剪枝操作


        // 本次动作存在的可能
        for(int i = 0; i < possible.length; i++) {
            // 剪枝：第一次动作随意选择一种可能
            if (p == n - 1 && i > 0) return;

            // 当前可能增加
            possible[i] += nums[p];
            // 在当前情况下，探究下一次可能
            action(possible, p - 1);
            // 回溯
            possible[i] -= nums[p];
        }
    }
```