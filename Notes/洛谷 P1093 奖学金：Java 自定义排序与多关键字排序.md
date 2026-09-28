# 洛谷 P1093 奖学金：Java 自定义排序与多关键字排序

## 1. 这题学到的核心

这道题最重要的不是成绩求和，而是：

**如何按照多个条件对二维数组进行自定义排序。**

题目要求排序优先级：

1. 总分高的在前；
2. 总分相同，语文成绩高的在前；
3. 总分和语文都相同，学号小的在前。

因此这是一个典型的 **多关键字排序**。

---

## 2. 二维数组中每一行代表一个学生

可以把每个学生的信息保存为：

```java
int[][] a = new int[n + 1][3];
```

其中：

```java
a[i][0] = 总分;
a[i][1] = 语文成绩;
a[i][2] = 学号;
```

例如：

```text
a[1] = {285, 100, 1}
a[2] = {285, 95, 2}
```

这里二维数组 `a` 的每一个元素其实都是一个 `int[]`。

也就是说：

```java
a[1]
```

本质上就是：

```java
int[]
```

---

## 3. Comparator 中的 x 和 y 到底是什么

自定义排序：

```java
Arrays.sort(a, 1, n + 1, (x, y) -> {
    ...
});
```

这里的：

```java
x
y
```

代表数组中正在被比较的 **两个元素**。

因为：

```java
a
```

是：

```java
int[][]
```

所以它里面的一个元素是：

```java
int[]
```

因此：

```java
x // 一个学生的信息
y // 另一个学生的信息
```

例如某一次比较可能是：

```java
x = {285, 100, 1};
y = {285, 95, 2};
```

那么：

```java
x[0] // x 的总分
x[1] // x 的语文成绩
x[2] // x 的学号
```

可以把：

```java
Arrays.sort(a, (x, y) -> ...)
```

理解成：

> Java 每次拿出两个学生 x 和 y，我负责告诉它谁应该排在前面。

---

## 4. Comparator 的返回值规则

Comparator 最重要的规则：

```text
返回负数：x 排在 y 前面
返回正数：y 排在 x 前面
返回 0：两者在当前规则下相等
```

例如：

```java
Integer.compare(x, y)
```

相当于：

```text
x 小的时候排前面
```

因此是：

```text
升序
```

而：

```java
Integer.compare(y, x)
```

相当于：

```text
x 大的时候排前面
```

因此是：

```text
降序
```

可以直接记：

```java
Integer.compare(x, y); // 升序
Integer.compare(y, x); // 降序
```

---

## 5. 本题排序规则

本题要求：

```text
总分：降序
语文：降序
学号：升序
```

因此：

```java
Arrays.sort(a, 1, n + 1, (x, y) -> {
    if (x[0] != y[0]) {
        return Integer.compare(y[0], x[0]);
    }

    if (x[1] != y[1]) {
        return Integer.compare(y[1], x[1]);
    }

    return Integer.compare(x[2], y[2]);
});
```

逻辑是：

先比较总分。

如果总分不同：

```java
return Integer.compare(y[0], x[0]);
```

让总分高的排前面。

如果总分相同，再比较语文：

```java
return Integer.compare(y[1], x[1]);
```

让语文成绩高的排前面。

如果语文也一样：

```java
return Integer.compare(x[2], y[2]);
```

让学号小的排前面。

---

## 6. 为什么使用 `1, n + 1`

这题使用：

```java
int[][] a = new int[n + 1][3];
```

并且：

```java
for (int i = 1; i <= n; i++)
```

从下标 1 开始存学生。

因此：

```java
a[0]
```

虽然没有主动赋值，但它实际上仍然存在：

```java
a[0] = {0, 0, 0}
```

如果直接：

```java
Arrays.sort(a, comparator);
```

那么 Java 会把：

```java
a[0]
```

也参与排序。

Java 不知道这个位置是我们故意不用的。

因此应该只排序：

```java
a[1] ~ a[n]
```

写成：

```java
Arrays.sort(a, 1, n + 1, comparator);
```

这里排序区间是：

```text
[1, n + 1)
```

也就是：

```text
1, 2, 3, ..., n
```

注意 Java 很多 API 都采用：

```text
左闭右开
```

即：

```text
[fromIndex, toIndex)
```

---

## 7. 一个容易写但不推荐的方式

可能会想到：

```java
return y[0] - x[0];
```

表示降序。

虽然很多情况下可以通过，但不推荐。

因为如果两个整数比较大：

```java
y[0] - x[0]
```

可能发生 `int` 溢出。

更稳妥的写法：

```java
Integer.compare(y[0], x[0]);
```

竞赛中最好养成这个习惯。

---

## 8. 多关键字排序通用模板

以后遇到：

```text
第一关键字优先
第一关键字相同再比较第二关键字
第二关键字相同再比较第三关键字
```

都可以写成：

```java
Arrays.sort(a, (x, y) -> {
    if (第一关键字不同) {
        return 第一关键字比较规则;
    }

    if (第二关键字不同) {
        return 第二关键字比较规则;
    }

    return 第三关键字比较规则;
});
```

例如：

```text
第一项升序
第二项降序
第三项升序
```

写成：

```java
Arrays.sort(a, (x, y) -> {
    if (x[0] != y[0]) {
        return Integer.compare(x[0], y[0]);
    }

    if (x[1] != y[1]) {
        return Integer.compare(y[1], x[1]);
    }

    return Integer.compare(x[2], y[2]);
});
```

---

## 9. 本题易错点总结

### 易错点 1：不理解 x、y

错误理解：

```text
x、y 是下标
```

实际上：

```text
x、y 是数组中的两个元素。
```

对于：

```java
int[][]
```

来说，一个元素就是：

```java
int[]
```

所以 x、y 都代表一整行。

### 易错点 2：忘记 a[0]

使用：

```java
int[n + 1][]
```

并从 1 开始存数据时：

```java
a[0]
```

仍然存在。

因此不能无脑排序整个数组。

### 易错点 3：升序和降序写反

记住：

```java
Integer.compare(x, y); // 升序
Integer.compare(y, x); // 降序
```

### 易错点 4：只写第一排序条件

多关键字排序必须逐层判断：

```text
总分
→ 语文
→ 学号
```

前面的条件相同时，才能继续比较后面的条件。

---

## 10. 本题收获

这题让我第一次真正理解了 Java 的自定义排序。

以前 `Arrays.sort()` 更多只是：

```java
Arrays.sort(a);
```

默认升序。

现在知道了排序其实可以自己定义规则：

```java
Arrays.sort(a, comparator);
```

更重要的是理解了：

```text
排序器不断拿两个元素 x、y 进行比较，
Comparator 决定谁应该放在前面。
```

这个方法以后在：

- 贪心；
- 区间排序；
- 二维数组排序；
- 学生信息排序；
- 多属性对象排序；

中都会大量使用。