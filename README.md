# juice

juice 是一个用于说明、演示 JDK 8、11、17、21、25 代表性新特性与新语法的学习型项目。

当前仓库采用以下组织方式：

- 文档集中放在 docs 目录
- 示例代码按 JDK 版本拆分为独立 Maven 模块
- 每个模块内部再按特性继续细分包结构

## 目录结构

```text
juice/
├─ docs/
├─ jdk-8-demo/
├─ jdk-11-demo/
├─ jdk-17-demo/
├─ jdk-21-demo/
├─ jdk-25-demo/
├─ pom.xml
└─ README.md
```

## 模块说明

| 模块 | 说明 |
| --- | --- |
| jdk-8-demo | JDK 8 新特性与新语法示例 |
| jdk-11-demo | JDK 11 新特性与新语法示例 |
| jdk-17-demo | JDK 17 新特性与新语法示例 |
| jdk-21-demo | JDK 21 新特性与新语法示例 |
| jdk-25-demo | JDK 25 新特性与新语法示例 |

## 文档入口

- [docs/jdk-feature-showcase-plan.md](docs/jdk-feature-showcase-plan.md)：总体方案
- [docs/overview.md](docs/overview.md)：项目总览
- [docs/jdk-8.md](docs/jdk-8.md)：JDK 8 专题
- [docs/jdk-11.md](docs/jdk-11.md)：JDK 11 专题
- [docs/jdk-17.md](docs/jdk-17.md)：JDK 17 专题
- [docs/jdk-21.md](docs/jdk-21.md)：JDK 21 专题
- [docs/jdk-25.md](docs/jdk-25.md)：JDK 25 专题

## 当前进度

当前已经完成 JDK 8、JDK 11、JDK 17 和 JDK 21 的首批示例与专题文档。

JDK 8 当前覆盖：

- Lambda 表达式
- 方法引用
- 函数式接口
- Stream API
- Collectors 进阶
- Optional
- 接口默认方法与静态方法
- 新日期时间 API
- CompletableFuture

JDK 11 当前覆盖：

- HttpClient API
- 单文件源码运行
- String API 增强
- Files API 增强
- var 在 Lambda 参数中的使用
- Optional 与集合相关 API 的补充能力

JDK 17 当前覆盖：

- Record
- Sealed Class
- Pattern Matching for instanceof
- Text Blocks
- 改进的空指针异常信息

JDK 21 当前覆盖：

- Virtual Threads
- Record Patterns
- Pattern Matching for switch
- Sequenced Collections

## 构建说明

当前阶段项目骨架已经就位，后续会逐步补充各版本的示例代码和文档内容。

根项目为 Maven 聚合工程。后续可以按模块单独构建，例如：

```bash
mvn -pl jdk-17-demo package
```

不同模块会使用各自的编译版本配置。

## 运行 JDK 8 示例

先编译模块：

```bash
mvn -q -pl jdk-8-demo package -DskipTests
```

再运行统一入口：

```bash
java -cp jdk-8-demo/target/classes com.juice.jdk8.DemoApplication
```

如果想先阅读内容，再查看代码，建议从 [docs/jdk-8.md](docs/jdk-8.md) 开始，然后进入 [jdk-8-demo/src/main/java/com/juice/jdk8/DemoApplication.java](jdk-8-demo/src/main/java/com/juice/jdk8/DemoApplication.java)。

## 运行 JDK 11 示例

先编译模块：

```bash
mvn -q -pl jdk-11-demo package -DskipTests
```

再运行统一入口：

```bash
java -cp jdk-11-demo/target/classes com.juice.jdk11.DemoApplication
```

单文件源码运行示例位于 [jdk-11-demo/single-file/SingleFileHello.java](jdk-11-demo/single-file/SingleFileHello.java)，可以单独进入该目录后执行：

```bash
java SingleFileHello.java
```

## 运行 JDK 17 示例

先编译模块：

```bash
mvn -q -pl jdk-17-demo package -DskipTests
```

再运行统一入口：

```bash
java -cp jdk-17-demo/target/classes com.juice.jdk17.DemoApplication
```

## 运行 JDK 21 示例

先编译模块：

```bash
mvn -q -pl jdk-21-demo package -DskipTests
```

再运行统一入口：

```bash
java -cp jdk-21-demo/target/classes com.juice.jdk21.DemoApplication
```
