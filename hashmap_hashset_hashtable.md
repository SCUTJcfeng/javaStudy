## HashMap HashSet 和 HashTable

[参考资料](https://blog.csdn.net/bear_wr/article/details/52275874)

---

### HashMap

HashMap 是在 bucket 中储存键对象和值对象，作为 Map.Entry。这一点有助于理解获取对象的逻辑。

在 HashMap 中，null 可以作为键，这样的键只有一个；可以有一个或多个键所对应的值为 null。当 get()方法返回 null 值时，即可以表示 HashMap 中没有该键，也可以表示该键所对应的值为 null。因此，在 HashMap 中不能由 get()方法来判断 HashMap 中是否存在某个键， 而应该用 containsKey()方法来判断。

### HashSet

HashSet 底层实现是 HashMap, 用 key 保存, value 为 Object 常量

### HashTable

HashTable 的方法是同步的, key, value 不允许为 null
