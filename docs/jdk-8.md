# JDK 8

## 版本简介

JDK 8 是 Java 发展过程中的一个关键版本。它不仅补充了一批新 API，更重要的是引入了函数式编程风格、方法引用、流式数据处理方式，以及一套更现代的日期时间 API。

很多今天已经被视为“Java 常规写法”的能力，例如 Lambda、方法引用、Stream、Collectors、Optional、CompletableFuture，本质上都从 JDK 8 开始进入主流开发实践。

## 为什么这个版本值得重点学习

JDK 8 的价值不只在于“新增了几个语法点”，而在于它改变了开发者组织代码的方式：

1. 用 Lambda 表达式减少匿名内部类的样板代码。
2. 用函数式接口把行为当作参数传递。
3. 用 Stream 把集合处理写得更偏向声明式。
4. 用 Optional 显式表达“值可能不存在”。
5. 用新的日期时间 API 替代旧版 Date 和 Calendar 的易错写法。
6. 用 CompletableFuture 编排异步任务。

对于后续 JDK 11、17、21 的很多新特性来说，JDK 8 也是理解它们的起点。

## 计划覆盖的主要特性

- Lambda 表达式
- 方法引用
- 函数式接口
- Stream API
- Collectors 进阶
- Optional
- 接口默认方法与静态方法
- 新日期时间 API
- CompletableFuture

## 对应模块

- jdk-8-demo

## 代码入口

- 统一运行入口：[../jdk-8-demo/src/main/java/com/juice/jdk8/DemoApplication.java](../jdk-8-demo/src/main/java/com/juice/jdk8/DemoApplication.java)
- Lambda 示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/lambda/LambdaExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/lambda/LambdaExample.java)
- 方法引用示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/methodreference/MethodReferenceExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/methodreference/MethodReferenceExample.java)
- 函数式接口示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/functionalinterface/FunctionalInterfaceExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/functionalinterface/FunctionalInterfaceExample.java)
- Stream 示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/stream/StreamExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/stream/StreamExample.java)
- Collectors 示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/collectors/CollectorsExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/collectors/CollectorsExample.java)
- Optional 示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/optional/OptionalExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/optional/OptionalExample.java)
- 接口默认方法示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/defaultmethod/DefaultMethodExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/defaultmethod/DefaultMethodExample.java)
- 日期时间 API 示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/datetime/DateTimeExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/datetime/DateTimeExample.java)
- CompletableFuture 示例：[../jdk-8-demo/src/main/java/com/juice/jdk8/completablefuture/CompletableFutureExample.java](../jdk-8-demo/src/main/java/com/juice/jdk8/completablefuture/CompletableFutureExample.java)

## 各特性详解

### 1. Lambda 表达式

#### 背景与痛点

在 JDK 8 之前，如果想把一段行为传给方法，经常需要写匿名内部类。这样虽然可行，但样板代码很多，真正的业务意图反而不够突出。

#### 核心语法

Lambda 的基本形式是：

```java
(参数) -> 表达式
```

或者：

```java
(参数) -> {
	// 多行逻辑
}
```

#### 示例代码

```java
public static List<String> sortByLength(List<String> words) {
	return words.stream()
			.sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
			.collect(Collectors.toList());
}
```

这个示例对应模块中的 LambdaExample。它展示了两层变化：

1. 使用 Lambda 和方法引用表达排序规则。
2. 结合 Stream 让“排序后收集结果”的意图直接暴露出来。

#### 适用场景

- 集合排序
- 回调逻辑传递
- 简单策略替换
- 与 Stream 搭配的数据处理

#### 与旧写法对比

旧写法通常需要显式创建 Comparator 匿名内部类；JDK 8 后可以直接把比较规则写成 Lambda 或方法引用，代码更聚焦于“按什么比较”。

#### 延伸：方法引用

方法引用可以看作 Lambda 的进一步简化。当 Lambda 只是“把现有方法转交出去”时，用方法引用通常更简洁。

#### 示例代码

```java
List<Integer> parsedNumbers = map(rawNumbers, Integer::parseInt);
List<String> trimmedWords = map(rawWords, String::trim);
Supplier<StringBuilder> builderSupplier = StringBuilder::new;
```

这个示例分别演示了三种常见形式：

1. 类名::静态方法，例如 Integer::parseInt。
2. 类名::实例方法，例如 String::trim。
3. 类名::new，也就是构造方法引用。

#### 适用场景

- 与 map、filter、sorted 等 Stream 操作配合
- 把已有工具方法直接作为行为传递
- 用构造方法引用替代简单工厂 Lambda

### 2. 函数式接口

#### 背景与痛点

Lambda 不是孤立能力，它需要一个可以接收“行为”的目标类型。函数式接口就是这个基础。

函数式接口的定义是：只包含一个抽象方法的接口。JDK 8 提供了 @FunctionalInterface 注解来帮助约束这种接口。

#### 示例代码

```java
@FunctionalInterface
public interface TextFormatter {

	String format(String text);

	default String formatWithPrefix(String prefix, String text) {
		return prefix + format(text);
	}
}
```

```java
TextFormatter formatter = text -> text.trim().toUpperCase();
String formatted = apply("  juice and java  ", formatter);
```

这个示例说明：

1. 函数式接口只有一个抽象方法。
2. 它仍然可以带 default 方法。
3. 一旦接口满足函数式接口条件，就可以直接用 Lambda 实现。

#### 适用场景

- 格式化逻辑
- 参数校验逻辑
- 过滤条件传递
- 简单转换规则封装

### 3. Stream API

#### 背景与痛点

在旧写法里，集合处理经常充满 for 循环、临时变量和显式结果容器。代码虽然直接，但容易把“做什么”淹没在“怎么做”的细节里。

#### 示例代码

```java
public static List<Integer> collectEvenSquares(List<Integer> numbers) {
	return numbers.stream()
			.filter(number -> number % 2 == 0)
			.map(number -> number * number)
			.collect(Collectors.toList());
}
```

```java
public static Map<String, List<String>> groupNamesByFirstLetter(List<String> names) {
	return names.stream()
			.collect(Collectors.groupingBy(name -> String.valueOf(name.charAt(0))));
}
```

这里分别展示了：

1. filter + map + collect 的典型流水线。
2. Collectors.groupingBy 的分组能力。

#### 适用场景

- 过滤、映射、聚合集合数据
- 统计和分组
- 从命令式循环切换到声明式处理

#### 注意事项

- Stream 更适合表达数据处理流程，不适合承载复杂副作用。
- 如果流水线过长，应该拆分中间步骤，提高可读性。

#### 延伸：Collectors 进阶

Collectors 是 Stream 体系里非常关键的一组终结操作工具。除了最常见的 toList 之外，它还能表达连接、分区、统计、映射汇总等需求。

#### 示例代码

```java
Map<Boolean, List<String>> partitioned = partitionByLength(features, 7);
String joined = joinUppercase(features);
IntSummaryStatistics statistics = summarizeLengths(features);
```

```java
return values.stream()
	.collect(Collectors.partitioningBy(value -> value.length() >= minLength));
```

```java
return values.stream()
	.collect(Collectors.summarizingInt(String::length));
```

这个示例重点展示了三类典型收集方式：

1. partitioningBy：按布尔条件把结果分成两组。
2. joining：把多个字符串拼接为一段结果。
3. summarizingInt：一次性拿到 count、min、max、average 等统计信息。

#### 适用场景

- 数据结果分类输出
- 列表内容拼接展示
- 对数值属性做汇总统计

### 4. Optional

#### 背景与痛点

NullPointerException 一直是 Java 常见问题之一。JDK 8 引入 Optional，不是为了彻底消灭 null，而是为了让“值可能不存在”这件事在 API 设计上更显式。

#### 示例代码

```java
public static Optional<String> findNickname(String account) {
	if ("juice".equals(account)) {
		return Optional.of("juicy-coder");
	}
	return Optional.empty();
}
```

```java
String nickname = findNickname("juice").orElse("guest");
String fallback = findNickname("unknown").orElseGet(() -> "default-user");
```

这个例子重点不在复杂逻辑，而在于：

1. 方法返回 Optional，明确告诉调用方需要处理“缺失值”。
2. 调用方可以选择 orElse 或 orElseGet 提供兜底值。

#### 适用场景

- 查询结果可能为空的方法返回值
- 减少直接暴露 null 的接口设计

#### 注意事项

- Optional 更适合做返回值，不适合滥用在字段和参数上。
- 不要把 Optional 当成普通容器到处传递。

### 5. 接口默认方法与静态方法

#### 背景与痛点

JDK 8 之前，接口只能定义抽象方法。如果想给已有接口增加新能力，就可能影响大量实现类。默认方法和静态方法让接口演进变得更可控。

#### 示例代码

```java
public interface Notifier {

	String notifyMessage(String message);

	default String notifyWithTag(String tag, String message) {
		return "[" + tag + "] " + notifyMessage(message);
	}

	static String channel() {
		return "console";
	}
}
```

```java
Notifier notifier = new EmailNotifier();
System.out.println(notifier.notifyWithTag("INFO", "JDK 8 interface default method"));
System.out.println(Notifier.channel());
```

#### 适用场景

- 为现有接口增加兼容性扩展方法
- 在接口层提供少量共享行为
- 把与接口强相关的工具逻辑定义为静态方法

### 6. 新日期时间 API

#### 背景与痛点

旧版 Date 和 Calendar API 可读性差、设计偏旧，而且线程安全和时区处理也容易让人出错。JDK 8 引入 java.time 包后，日期时间建模明显更现代。

#### 示例代码

```java
LocalDate releaseDate = LocalDate.of(2014, 3, 18);
LocalDate projectStart = LocalDate.of(2026, 4, 28);
Period duration = Period.between(releaseDate, projectStart);
LocalDateTime meeting = LocalDateTime.of(projectStart, LocalTime.of(10, 30));
```

```java
meeting.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
```

这个例子体现了三点：

1. LocalDate、LocalTime、LocalDateTime 语义分明。
2. Period 可以直接表示日期之间的差值。
3. DateTimeFormatter 可以清晰地处理格式化输出。

#### 适用场景

- 业务日期处理
- 时间格式化与解析
- 计算日期差值

### 7. CompletableFuture

#### 背景与痛点

异步任务在 JDK 8 之前并不是不能写，但写法往往比较原始。CompletableFuture 的价值在于，它让异步结果的组合、转换和串联更加自然。

#### 示例代码

```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "juice")
		.thenApply(String::toUpperCase)
		.thenApply(value -> value + " uses CompletableFuture");

return future.get();
```

这里展示的是最基础的异步流水线：

1. supplyAsync 异步提供初始值。
2. thenApply 串联后续转换逻辑。
3. 最终通过 get 获取结果。

#### 适用场景

- 异步查询或远程调用结果转换
- 多阶段异步任务编排
- 从 Future 迁移到更易组合的异步模型

#### 注意事项

- 演示场景可以直接 get 或 join，但真实业务中要注意线程池和异常处理策略。

## 与旧版本写法对比

JDK 8 之前的 Java 更偏命令式和样板式，常见问题包括：

1. 匿名内部类冗长。
2. 集合处理依赖大量显式循环。
3. 空值处理容易散落在各层 if 判断里。
4. 日期时间 API 使用成本高。
5. 异步编排能力较弱。

JDK 8 并没有让 Java 变成另一门语言，但它显著提高了表达力。很多“意图明确、代码更短、组合能力更强”的写法，都从这个版本开始成为现实。

## 适用场景与落地建议

如果是在真实项目里落地 JDK 8 能力，建议优先顺序如下：

1. 先掌握 Lambda、函数式接口和 Stream，这三者最容易形成配套。
2. 在查询型方法上逐步引入 Optional，但避免滥用。
3. 新代码优先使用 java.time，不再继续扩散旧日期时间 API。
4. 在异步流程明确的场景中使用 CompletableFuture，而不是一开始就把所有并发逻辑都改成异步链。

## 升级或使用注意事项

1. 不要为了“用了新特性”而牺牲可读性。
2. Stream 和 Lambda 适合表达集合处理与行为传递，不适合承载复杂业务流程。
3. Optional 是用来表达缺失值语义的，不是所有地方都要包一层。
4. CompletableFuture 的真正难点是线程模型和异常传播，而不是 API 调用本身。

## 本章小结

JDK 8 是整个项目中最重要的基础章节，因为它决定了后续很多 Java 代码的现代写法。

本模块当前已经配套实现了以下示例：

1. Lambda 表达式
2. 方法引用
3. 函数式接口
4. Stream API
5. Collectors 进阶
6. Optional
7. 接口默认方法与静态方法
8. 新日期时间 API
9. CompletableFuture

## 编写说明

后续如果继续细化 JDK 8 章节，可以补充：

1. 方法引用的独立小节
2. Collectors 的更多聚合示例
3. CompletableFuture 的异常处理与组合示例
4. 从旧写法迁移到 JDK 8 写法的对照案例
