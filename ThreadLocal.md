## ThreadLocal

[参考资料](http://ifeve.com/%e6%89%8b%e6%92%95%e9%9d%a2%e8%af%95%e9%a2%98threadlocal%ef%bc%81%ef%bc%81%ef%bc%81/)

### 用在什么地方

- 保存线程上下文信息, 在任意需要的地方可以获取
- 线程安全, 避免某些情况需要考虑线程安全必须同步带来的性能损失！！！

### 细节

- ThreadLocal 无法解决共享对象的更新问题, 因为线程隔离
- 每个线程都有 threadLocals （类型是 ThreadLocal.ThreadLocalMap）

### 最佳实践

由于线程的生命周期很长，如果我们往 ThreadLocal 里面 set 了很大很大的 Object 对象，虽然 set、get 等等方法在特定的条件会调用进行额外的清理，但是 ThreadLocal 被垃圾回收后，在 ThreadLocalMap 里对应的 Entry 的键值会变成 null，但是后续在也没有操作 set、get 等方法了。

- try { // 其它业务逻辑} finally { threadLocal 对象.remove();}
