# 项目总览

## 项目简介

juice 用于说明和演示 JDK 8、11、17、21、25 的代表性新特性与新语法。

## 阅读方式

建议按以下顺序阅读：

1. 先阅读总体方案文档，了解项目范围和组织方式。
2. 再按版本阅读专题文档。
3. 最后进入对应模块查看示例代码。

## 文档导航

- [jdk-feature-showcase-plan.md](jdk-feature-showcase-plan.md)：总体方案
- [jdk-8.md](jdk-8.md)：JDK 8 专题
- [jdk-11.md](jdk-11.md)：JDK 11 专题
- [jdk-17.md](jdk-17.md)：JDK 17 专题
- [jdk-21.md](jdk-21.md)：JDK 21 专题
- [jdk-25.md](jdk-25.md)：JDK 25 专题

## 代码导航

- [../jdk-8-demo](../jdk-8-demo)：JDK 8 示例模块
- jdk-11-demo：JDK 11 示例模块
- jdk-17-demo：JDK 17 示例模块
- jdk-21-demo：JDK 21 示例模块
- jdk-25-demo：JDK 25 示例模块

## 当前已完成

当前已经完成 JDK 8 和 JDK 11 的首批内容，包括专题文章和可运行示例。

- JDK 8 阅读入口：[jdk-8.md](jdk-8.md)
- JDK 8 代码入口：[../jdk-8-demo/src/main/java/com/juice/jdk8/DemoApplication.java](../jdk-8-demo/src/main/java/com/juice/jdk8/DemoApplication.java)
- JDK 8 运行方式：先执行 mvn -q -pl jdk-8-demo package -DskipTests，再执行 java -cp jdk-8-demo/target/classes com.juice.jdk8.DemoApplication
- JDK 11 阅读入口：[jdk-11.md](jdk-11.md)
- JDK 11 代码入口：[../jdk-11-demo/src/main/java/com/juice/jdk11/DemoApplication.java](../jdk-11-demo/src/main/java/com/juice/jdk11/DemoApplication.java)
- JDK 11 运行方式：先执行 mvn -q -pl jdk-11-demo package -DskipTests，再执行 java -cp jdk-11-demo/target/classes com.juice.jdk11.DemoApplication

## 后续计划

后续会逐步补充：

1. JDK 11 的专题正文和首批示例
2. 其余版本的专题正文和首批特性示例
3. 文档与示例代码之间的对应关系说明
