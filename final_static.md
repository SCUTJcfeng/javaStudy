## final 和 static

---

### final

final 表示最后的、最终的

#### final 修饰类

用 final 修饰的类不能被继承

#### final 修饰方法

可以被重载
用 private 修饰的方法因为无法被继承, 所以不能被重写
没有 private 修饰的方法在子类中可以定义相同的方法名和参数, 但是这是新的方法, 不是重写

#### final 修饰变量

不能被修改的是地址的值
对于基本数据类型, 值指的是数值, 不能被修改
对于引用数据类型, 值指的是对象的地址, 对象不能被修改, 但是对象的属性可以修改(如数组)

---

### static

static 表示全局的 静态的

#### static 修饰变量

静态变量在内存中只有一个拷贝(节约内存), 可以用类名直接访问

#### static 修饰方法

可以用类名直接访问, 静态方法中不能用 this super 关键字

#### static 修饰代码块

只在类加载的时候执行一次, 优化程序性能

---

### static final

修饰成员变量和成员方法, 全局常量

---

### 执行顺序, 见 Main.java

静态代码块、静态方法、构造方法等在类加载、实例化的时候的执行顺序如下:

1. Class.forName 是将类加载到 JVM，可见加载子类之前，需要先加载父类，并按照出现的顺序执行其中的静态代码块、静态方法（如果有调用）。

2. new 先执行静态代码，再执行构造方法；先执行父类，在执行子类。(其中子类默认调用父类的无参构造方法)