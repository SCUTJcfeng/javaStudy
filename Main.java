// 父类
class Father {
    // 非静态变量
    C fa = new C("fa");

    // 静态变量
    static C fb = new C("fb");

    // 静态语句块
    static {
        OutUtil.print("Static blocks 1 in Father! ");
    }

    // 静态语句块
    static {
        OutUtil.print("Static blocks 2 in Father! ");
    }

    // 静态常量
    static final int T = 28;

    // 构造方法
    public Father() {
        super();
        OutUtil.print("Construct method in Father! ");
    }

    // 带参构造器
    public Father(String name) {
        OutUtil.print("Construct method in Father! " + "Name = " + name);
    }

    // 非静态代码块
    {
        OutUtil.print("Common blocks in Father! ");
    }

    // 静态方法
    static void staticShow() {
        OutUtil.print("Static method in Father! ");
    }

    // 非静态方法
    void show() {
        OutUtil.print("Common method in Father! ");
    }

}


// 子类
class Child extends Father {

    // 非静态变量
    C ca = new C("ca");

    // 静态常量
    static final int T = 28;

    // 构造方法
    public Child() {
        super();
        OutUtil.print("Construct method in Child! ");
    }

    // 带参构造器
    public Child(String name) {
        OutUtil.print("Construct method in Child! " + "Name = " + name);
    }

    // 非静态代码块
    {
        OutUtil.print("Common blocks in Child! ");
    }

    // 静态方法
    static void staticShow() {
        OutUtil.print("Static method in Child! ");
    }

    // 非静态方法
    void show() {
        OutUtil.print("Common method in Child! ");
    }

    // 静态变量
    static C cb = new C("cb");

    // 静态语句块
    static {
        OutUtil.print("Static blocks 1 in Child! ");
    }

    // 静态语句块
    static {
        OutUtil.print("Static blocks 2 in Child! ");
    }

}


// 辅助类
class C {
    public static final String A = "A in C";

    public static String showC() {
        return "showC method in C!";
    }

    public C() {
        OutUtil.print("Construct method in C!");
    }

    public C(String msg) {
        OutUtil.print("Construct method in C! " + msg);
    }
}


// 入口程序所在类
public class Main {

    C ma = new C("ma"); // 打印结果显示ma并未进行初始化
    static C mb = new C("mb");

    public Main() {
        OutUtil.print("I am Main!");
    }

    static {
        OutUtil.print(mb.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        OutUtil.print("Main");
        Child child = new Child();
        child.show();
        OutUtil.print(C.A);
        OutUtil.print(C.showC());
    }

    static Child mc = new Child("mc");
}


// 打印输出的工具类
class OutUtil {
    public static void print(Object o) {
        System.out.println(o);
    }
}

// // Result
// // Main类未被实例化, 此处执行static修饰的静态代码
// Construct method in C! mb
// C
// // 执行父类static修饰的静态代码
// Construct method in C! fb
// Static blocks 1 in Father!
// Static blocks 2 in Father!

// // 执行子类static修饰的静态代码
// Construct method in C! cb
// Static blocks 1 in Child!
// Static blocks 2 in Child!

// // 调用父类构造方法
// Construct method in C! fa
// Common blocks in Father!
// Construct method in Father!

// // 调用子类构造方法
// Construct method in C! ca
// Common blocks in Child!
// Construct method in Child! Name = mc

// Main

// // 调用父类构造方法
// Construct method in C! fa
// Common blocks in Father!
// Construct method in Father!

// // 调用子类构造方法
// Construct method in C! ca
// Common blocks in Child!
// Construct method in Child!

// Common method in Child!
// A in C
// showC method in C!
