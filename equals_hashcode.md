## equals 和 hashcode

---

### equals 方法

1. Object 类的 equals 方法比较的是 2 个对象的**内存地址**是否相等

```
public boolean equals(Object obj) {
    return (this == obj);
}
```

2. 常见数据类型的封装类都对 equals 方法进行了重写, 如 String 比较的是内容

```
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = count;
        if (n == anotherString.count) {
        char v1[] = value;
        char v2[] = anotherString.value;
        int i = offset;
        int j = anotherString.offset;
        while (n-- != 0) {
            if (v1[i++] != v2[j++])
            return false;
        }
        return true;
        }
    }
    return false;
}
```

3. equals 方法的规则:

   - 自反性, x.equals(x) 返回 true
   - 对称性, x.equals(y) 返回 true, y.equals(x)也返回 true
   - 传递性, x.equals(y) 返回 true, y.equals(z)返回 true, x.equals(z)也返回 true
   - 一致性, 多次调用 x.equals(y)返回的结果是一样的
   - 对非空 x, x.equals(null)返回 false

4. 推荐实践
   使用 getClass 而不是 instance of 判断类型, 因为 childObject instance of FatherClass 返回 true

---

### hashCode

1. hashCode 用于对象的查找使用(散列表中 key-value 中的 key)

2. hashCode 返回对象的哈希码值, 通常 equals 方法被重写时, 有必要重写 hashCode 方法

3. 两个对象的 hashCode 相同, 不一定表示两个对象就相同, 只能说明这两个对象在 Hashtable 中放在同一个篮子里
