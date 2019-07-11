## Spring Boot 学习

### POM 文件

- parent 配置

  ```
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.1.6.RELEASE</version>
          <relativePath /> <!-- lookup parent from repository -->
      </parent>
  ```

  通过配置 parent 继承, 默认具备以下功能

  - Java 版本 Java8
  - 编码方式 UTF-8
  - 依赖管理
  - 打包支持
  - 动态资源识别
  - 插件位置识别
  - 识别不同配置, 如 application-dev.properties 和 application-dev.yml

  继承之后, 不需要再次指定版本号

### Java Bean

[stackoverflow](https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly)

JavaBean 仅仅是一个标准, 一个类如果遵循了以下标准那它就是 JavaBean

- 所有属性是 private 的(使用 getters/setters 访问)
- 有一个无参构造器
- 使用 Serializable 接口

### Spring @Bean

[stackoverflow](https://stackoverflow.com/questions/17193365/what-in-the-world-are-spring-beans)

- 在 Spring 中，Bean 由 Spring IoC 容器实例化, 管理和销毁

- @Bean 是一个方法级别上的注解, 主要用在@Configuration 注解的类里, 也可以用在@Component 注解的类里

- 当项目中的类是自己编写的，则一般使用@controller、@service、@component 等注解直接把 bean 交给 spring 管理。

- 当我们需要引入第三方库，并且也需要把第三方库中的类实例交给 spring 管理时，则使用@Bean、@Configuration 注解。

#### @Bean 的生命周期

[资料来源](http://cmsblogs.com/?p=4034)

- Spring 容器根据实例化策略对 Bean 进行实例化。
- 实例化完成后，如果该 bean 设置了一些属性的话，则利用 set 方法设置一些属性。
- 如果该 Bean 实现了 BeanNameAware 接口，则调用 setBeanName() 方法。
- 如果该 bean 实现了 BeanClassLoaderAware 接口，则调用 setBeanClassLoader() 方法。
- 如果该 bean 实现了 BeanFactoryAware 接口，则调用 setBeanFactory() 方法。
- 如果该容器注册了 BeanPostProcessor，则会调用 postProcessBeforeInitialization() 方法完成 bean 前置处理
- 如果该 bean 实现了 InitializingBean 接口，则调用 。afterPropertiesSet() 方法。
- 如果该 bean 配置了 init-method 方法，则调用 init-method 指定的方法。
- 初始化完成后，如果该容器注册了 BeanPostProcessor 则会调用 postProcessAfterInitialization() 方法完成 bean 的后置处理。
- 对象完成初始化，开始方法调用。
- 在容器进行关闭之前，如果该 bean 实现了 DisposableBean 接口，则调用 destroy() 方法。
- 在容器进行关闭之前，如果该 bean 配置了 destroy-mehod，则调用其指定的方法。
- 到这里一个 bean 也就完成了它的一生。

#### @Component 和 @Configuration

- @Configuration 使用 CGLIB 代理, @Component 不使用, 需用@Autowired 获取对应的实例

- @Configuration 中所有带 @Bean 注解的方法都会被动态代理，因此调用该方法返回的都是同一个实例。

#### @Resource 和 @Autowired

- @Autowired 按照 ByType 装配对象
- @Resource 指定 name 按照 ByName 装配对象(默认), 指定 type 按照 ByType 装配对象

#### @Service

让 spring 自动扫描管理组件，@Service  @Controller @Repository @Component ，这四个其实是一样的功能，没有区别，只是在 MVC 模式上表示的层不一样，service 一般标注在 service 层的 bean 上，controller 标注在控制层，@Repository 标注在 view 层，component 通用

service 注解的类, 实现的时候用接口实现([解析链接](https://blog.csdn.net/sunsgne_AC/article/details/79269213))

#### @EnableAsync 　@Async

- 在启动类上增加 @EnableAsync 注解，开启异步任务
- 在需要异步执行的方法上增加 @Async 注解，标识为一个异步任务

#### @EnableScheduling @Scheduled

- @EnableScheduling 注解用在配置类(加@Configuration 注解)
- @Scheduled 注解用于定时任务方法, 参数见[链接](https://blog.csdn.net/u014042066/article/details/77233581)

#### 常用注解及含义

| 注解        | 含义                                           |
| ----------- | ---------------------------------------------- |
| @Component  | 最普通的组件，可以被注入到 spring 容器进行管理 |
| @Repository | 作用于持久层                                   |
| @Service    | 作用于业务逻辑层                               |
| @Controller | 作用于表现层（spring-mvc 的注解）              |

#### ibatis @Mapper @Param

#### jpa @EnableJpaRepositories

#### jackson @JsonProperty

#### JDBC 与 MyBatis
