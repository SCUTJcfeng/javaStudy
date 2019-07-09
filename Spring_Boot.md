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
