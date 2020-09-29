### 高级动态规划

1. 对比与初级动态规划来说 **状态拥有更多的维度(二维、三维甚至是更多维度、甚至需要压缩)**
2. 状态方程更复杂

#### 关键点

​	以机器的思维去思考 寻找最优子结构、如何淘汰次优解

### 字符串

#### 匹配算法

1. 暴力法
2. Rabin-Karp算法
3. KMP算法

##### 暴力破解

​	其他更加优化的字符串算法 基本上都是对暴力破解的第二层循环进行优化. 第一层枚举是不变的

```java
// Java
public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();
    for (int i = 0; i <= M - N; i++) {
        int j;
        for (j = 0; j < N; j++) {
            if (txt.charAt(i + j) != pat.charAt(j))
                break;
        }
        if (j == N) {
            return i;
        }
        // 更加聪明？ 
        // 1. 预先判断 hash(txt.substring(i, M)) == hash(pat)
        // 2. KMP 
    }
    return -1;
}
```

##### Rabin-Karp

​	通过**哈希函数** 我们可以计算出子串的哈希值 然后将它和目标子串的哈希值进行比较.

​	**这里哈希函数并不是每个子串摘出来调用系统的哈希函数 而是通过某种计算方式 使得这个哈希值像一个滑动窗口的方式 每次匹配失败 会把最开始匹配的丢掉 然后加上新进来的字符组成一个新的哈希值 这种方式是O(1)的时间复杂度**

```java
//Java
public final static int D = 256;
public final static int Q = 9997;

static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;

    for (i = 0; i < M; i++) {
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }

    int highestPow = 1;  // pow(256, M-1)
    for (i = 0; i < M - 1; i++)
        highestPow = (highestPow * D) % Q;

    for (i = 0; i <= N - M; i++) { // 枚举起点
        if (patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return i;
        }
        if (i < N - M) {
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            if (txtHash < 0)
                txtHash += Q;
        }
    }
    return -1;
}
```

##### KMP

​	**设法利用已知信息** 不要把"搜索位置"移回已经比较过的位置 继续把它向后移.

​	这里利用已知信息 指的是 当一个长串和需要匹配的字符串进行匹配时 匹配到某个字符不相同时 不会把已经计算过的字符重新进行比对 会利用最长公共前后缀 达到一个省略前面已经匹配过字符的过程.

​	动画原理: https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171

​	阮一峰文章: http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html

​	代码实现: https://www.bilibili.com/video/BV1hW411a7ys/?spm_id_from=333.788.videocard.0

##### Sunday算法

​	https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html

##### Boyer-Moore算法

​	https://blog.csdn.net/u012505432/article/details/52210975