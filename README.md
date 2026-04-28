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

- docs/jdk-feature-showcase-plan.md：总体方案
- docs/overview.md：项目总览
- docs/jdk-8.md：JDK 8 专题
- docs/jdk-11.md：JDK 11 专题
- docs/jdk-17.md：JDK 17 专题
- docs/jdk-21.md：JDK 21 专题
- docs/jdk-25.md：JDK 25 专题

## 构建说明

当前阶段项目骨架已经就位，后续会逐步补充各版本的示例代码和文档内容。

根项目为 Maven 聚合工程。后续可以按模块单独构建，例如：

```bash
mvn -pl jdk-17-demo package
```

不同模块会使用各自的编译版本配置，具体运行方式会在后续示例完善时继续补充。
