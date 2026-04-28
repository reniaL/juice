# JDK 21

## 版本简介

JDK 21 是当前主流长期支持版本之一，也是 Java 在并发模型和模式匹配方向上的一个重要里程碑。这个版本既有非常受关注的 Virtual Threads，也把 Record Patterns、Pattern Matching for switch 这类表达能力继续推进到了更成熟的阶段。

对很多团队来说，JDK 21 不只是“更新的 LTS”，而是一个值得认真评估的升级目标，因为它已经开始显著影响代码组织方式和并发设计方式。

## 为什么这个版本值得重点学习

JDK 21 值得重点学习，主要因为它在两个方向上非常突出：

1. Virtual Threads 让高并发任务编排的心智负担显著下降。
2. Record Patterns 和 switch 模式匹配让数据拆解和类型分支更接近业务意图。
3. Sequenced Collections 把“首元素、尾元素、反向视图”这些常见需求补进了集合体系。

它的整体特点是：不仅有新能力，而且这些新能力之间开始形成明显的协同效应。

## 计划覆盖的主要特性

- Virtual Threads
- Record Patterns
- Pattern Matching for switch
- Sequenced Collections
- Scoped Values 或其他并发相关扩展内容

## 对应模块

- jdk-21-demo

## 代码入口

- 统一运行入口：[../jdk-21-demo/src/main/java/com/juice/jdk21/DemoApplication.java](../jdk-21-demo/src/main/java/com/juice/jdk21/DemoApplication.java)
- Virtual Threads 示例：[../jdk-21-demo/src/main/java/com/juice/jdk21/virtualthreads/VirtualThreadsExample.java](../jdk-21-demo/src/main/java/com/juice/jdk21/virtualthreads/VirtualThreadsExample.java)
- Record Patterns 示例：[../jdk-21-demo/src/main/java/com/juice/jdk21/recordpatterns/RecordPatternsExample.java](../jdk-21-demo/src/main/java/com/juice/jdk21/recordpatterns/RecordPatternsExample.java)
- Pattern Matching for switch 示例：[../jdk-21-demo/src/main/java/com/juice/jdk21/switchpattern/SwitchPatternExample.java](../jdk-21-demo/src/main/java/com/juice/jdk21/switchpattern/SwitchPatternExample.java)
- Sequenced Collections 示例：[../jdk-21-demo/src/main/java/com/juice/jdk21/sequencedcollections/SequencedCollectionsExample.java](../jdk-21-demo/src/main/java/com/juice/jdk21/sequencedcollections/SequencedCollectionsExample.java)

说明：
Scoped Values 在 JDK 21 中仍然更适合作为扩展阅读讨论。为了保持当前模块无需 preview 配置即可直接编译和运行，本轮没有把它放入示例代码。

## 各特性详解

### 1. Virtual Threads

#### 背景与痛点

传统线程模型在处理大量并发任务时，往往要在吞吐、线程数量、阻塞模型和复杂异步编排之间做权衡。Virtual Threads 的目标，就是让“每个任务一个线程”这种更直观的写法重新变得可行。

#### 示例代码

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
	List<Future<String>> futures = new ArrayList<>();
	futures.add(executor.submit(() -> taskResult("parse markdown")));
	futures.add(executor.submit(() -> taskResult("read examples")));
	futures.add(executor.submit(() -> taskResult("render output")));
}
```

这个示例用最小方式说明了 Virtual Threads 的核心价值：

1. 用起来仍然很像普通线程或线程池。
2. 但它更适合承载大量阻塞型任务。

#### 适用场景

- 高并发请求处理
- 阻塞型 I/O 任务编排
- 希望保留同步写法又想提升并发伸缩性的场景

### 2. Record Patterns

#### 背景与痛点

Record 解决了数据载体的定义问题，但在使用这些数据时，仍然可能需要一层层访问字段。Record Patterns 进一步解决的是“如何直接解构 record”。

#### 示例代码

```java
if (value instanceof Developer(String name, Address(String city))) {
	return name + " works from " + city;
}
```

这个写法把“判断类型”和“拆出内部字段”合并到了一个位置里，表达力比手工取值更高。

#### 适用场景

- 处理嵌套 record
- 响应对象拆解
- 更声明式的数据匹配逻辑

### 3. Pattern Matching for switch

#### 背景与痛点

传统 switch 更适合处理固定常量分支，不太适合复杂类型匹配。JDK 21 的 switch 模式匹配把 switch 推向了更通用的分支表达工具。

#### 示例代码

```java
return switch (value) {
	case null -> "null value";
	case String text when text.isBlank() -> "blank string";
	case String text -> "text=" + text.toUpperCase();
	case Integer number when number > 0 -> "positive integer=" + number;
	case Integer number -> "non-positive integer=" + number;
	default -> "unsupported value=" + value;
};
```

这个例子展示了三种能力：

1. 类型匹配。
2. 模式变量绑定。
3. 带条件的分支守卫。

#### 适用场景

- 多类型输入处理
- 规则分发
- 替代冗长的 if / else if 链

### 4. Sequenced Collections

#### 背景与痛点

很多集合操作都隐含着“先后顺序”的语义，但在过去的 API 里，取首元素、取尾元素、反向查看等操作并不统一。JDK 21 的 Sequenced Collections 对这一点做了系统化补充。

#### 示例代码

```java
List<String> versions = new ArrayList<>(List.of("JDK 8", "JDK 11", "JDK 17"));
versions.addFirst("JDK 7");
versions.addLast("JDK 21");

versions.getFirst();
versions.getLast();
versions.reversed();
```

#### 适用场景

- 有顺序语义的列表处理
- 需要统一访问头尾元素的集合逻辑
- 希望直接获取反向视图而不是手工翻转集合

### 5. Scoped Values 与并发扩展能力

在 JDK 21 里，Scoped Values 和结构化并发也是值得关注的方向，但它们更适合作为扩展阅读或单独实验主题处理。

当前项目为了保持模块可直接编译运行，先不把这类需要额外配置或更深入上下文的内容纳入首批代码示例。等你后续愿意扩展 JDK 21 章节时，可以把它们作为第二阶段专题加入。

## 与旧版本写法对比

和 JDK 17 相比，JDK 21 的变化更明显地指向两类问题：

1. 怎么更自然地写并发程序。
2. 怎么更自然地拆解和分支处理数据。

Virtual Threads 让同步风格重新具备高并发可行性；Record Patterns 和 switch 模式匹配则让 Java 在表达复杂分支时少了很多胶水代码。

## 适用场景与落地建议

如果是在真实项目里评估 JDK 21，建议优先关注：

1. 是否存在大量阻塞型并发场景，适合引入 Virtual Threads。
2. 是否有很多以 record 或简单数据模型为基础的分支处理代码。
3. 是否存在大量依赖集合首尾访问的业务逻辑。

## 升级或使用注意事项

1. Virtual Threads 会降低并发编排复杂度，但不意味着线程相关问题会自动消失。
2. Record Patterns 和 switch 模式匹配会提升表达力，但前提是模型本身要足够清晰。
3. Sequenced Collections 提供了统一 API，但仍要注意底层集合实现的特性。
4. Scoped Values 等扩展能力建议在明确需求后再单独引入，不要在第一轮学习中把稳定特性和扩展主题混在一起。

## 本章小结

JDK 21 的代表性价值在于：它同时推进了并发能力和语言表达能力，而且这些推进都足够贴近实际开发。

本模块当前已经配套实现了以下示例：

1. Virtual Threads
2. Record Patterns
3. Pattern Matching for switch
4. Sequenced Collections

## 编写说明

后续如果继续细化 JDK 21 章节，可以补充：

1. Virtual Threads 与传统线程池的对照示例
2. Record Patterns 的更深层嵌套解构案例
3. switch 模式匹配的更多 guard 条件示例
4. Scoped Values 与结构化并发的扩展专题
