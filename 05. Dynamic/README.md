### Dynamic Programming

**"Simplifying a complicated problem by breaking it down into simpler sub-problems"**
**(in a recursive manner)**

#### 本质

动态规划 和 递归分治没有根本的区别 (关键是有无最优子结构) - 都是找重复子问题
差异性: 最优子结构、中途可以**淘汰次优解**

#### 斐波拉契数列

Bottom Up

```java
// F[n] = F[n - 1] + F[n - 2]
int[] dp = new int[n + 1];
dp[0] = 0, dp[1] = 1;
for (int i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
}
return dp[n];
```

Up Bottom

```java
// O(2^n) - 可以使用缓存优化 时间复杂度 => O(n)
int fib(int n) {
    return n <= 1 ? n : fib(n - 1) + fib(n - 2);
}
```

#### 关键点

1. 最优子结构
2. 储存中间状态
3. 递推公式(状态转移方程、DP方程)

#### 小结

1. 打破自己的思维习惯、 形成机器思维
2. 理解复杂逻辑的关键

#### 总结

​	感觉最好理解动态规划的题目是LeetCode上的路径计数、最小子序和. 也就是像超哥所讲的一样 主要是需要先寻找重复子问题, 然后看中间有没有附加条件, 需不需要对子问题的结果进行选择 然后得到递推公式. 最后 储存中间状态的时候 空间复杂度有很多时候也可以进行优化 - 只储存当前需要的之前的状态.