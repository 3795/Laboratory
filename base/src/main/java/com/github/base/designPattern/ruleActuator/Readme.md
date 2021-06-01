规则执行器

如果直接使用if else实现一些逻辑判断，实现如下：
```java
if (是否海外用户) {
 return false;
}

if (刷单用户) {
  return false;
}

if (未付费用户 && 不再服务时段) {
  return false
}

if (转介绍用户 || 付费用户 || 内推用户) {
  return true;
}
```

这其中做了短路处理，如果使用执行器模式的话，实现如代码实现。

参考：https://mp.weixin.qq.com/s/LTEnR_KYv1PZNd90mnf5ww