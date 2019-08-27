## Proxy

[参考资料](https://blog.csdn.net/briblue/article/details/73928350)

### 静态代理

代理模式可以在不修改被代理对象的基础上，通过扩展代理类，进行一些功能的附加与增强。值得注意的是，代理类和被代理类应该共同实现一个接口，或者是共同继承某个类。

共同接口

```Java
interface IMovie {
    public void play();
}
```

被代理类

```Java
class RealMovie implements IMovie {
    @Override
    public void play() {
        System.out.println("real movie plays");
    }
}
```

代理类

```Java
class MovieProxy implements IMovie {
    private IMovie movie;

    public MovieProxy(IMovie movie) {
        this.movie = movie;
    }

    @Override
    public void play() {
        beforePlay();
        movie.play();
        afterPlay();
    }

    private void beforePlay() {
        System.out.println("before play");
    }

    private void afterPlay() {
        System.out.println("after play");
    }
}
```

```Java
public final class App {
    public static void main(String[] args) {
        // IMovie movie = new RealMovie();
        IMovie movie = new MovieProxy(new RealMovie());
        movie.play();
    }
}
```

### 动态代理

1. JDK

共同接口

```Java
public interface IWine {
    public void sellWine();
}
```

被代理类

```Java
public class MaotaiWine implements IWine {

    @Override
    public void sellWine() {
        System.out.println("sell maotai wine");
    }
}
```

处理类 InvocationHandler

```Java
public class GuitaiHandler implements InvocationHandler {

    private Object platform;

    public GuitaiHandler(Object platform) {
        this.platform = platform;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("sell start with " + this.getClass().getSimpleName());
        method.invoke(platform, args);
        System.out.println("sell ends");
        return null;
    }
}
```

使用动态代理, 参数 loader 指定动态代理类的类加载器，参数 interfaces 指定动态代理类需要实现的所有接口。

```Java
public final class App {
    public static void main(String[] args) {
        IWine wine = new MaotaiWine();
        InvocationHandler handler = new GuitaiHandler(wine);
        IWine dynamicProxy = (IWine) Proxy.newProxyInstance(MaotaiWine.class.getClassLoader(),
                MaotaiWine.class.getInterfaces(), handler);
        dynamicProxy.sellWine();
        // com.sun.proxy.$Proxy0
        // System.out.println(dynamicProxy.getClass().getName());
    }
}
```

2. CGLib

[参考资料](https://juejin.im/post/5b06bf2df265da0de2574ee1)

JDK 在创建代理对象时的性能要高于 CGLib 代理，而生成代理对象的运行性能却比 CGLib 的低。
如果是单例的代理，推荐使用 CGLib
