# JDK 17

## 版本简介

JDK 17 是新一代主流长期支持版本之一。它的重要性不只在于“又一个 LTS”，更在于它把 Java 在建模能力、类型表达和代码可读性上的一批关键改进集中带进了生产视野。

如果说 JDK 8 更像是现代 Java 编程风格的起点，JDK 17 则更像是对“如何更清晰地表达模型和意图”给出了一轮成熟回答。

## 为什么这个版本值得重点学习

JDK 17 值得重点学习，主要因为它在几个核心方向上都很实用：

1. Record 让数据载体类的定义明显更简洁。
2. Sealed Class 让继承层次的约束能力更强。
3. Pattern Matching for instanceof 提高了类型判断后的表达效率。
4. Text Blocks 让多行文本的可读性提升很明显。
5. 更友好的空指针异常信息降低了排查成本。

## 计划覆盖的主要特性

- Record
- Sealed Class
- Pattern Matching for instanceof
- Text Blocks
- 改进的空指针异常信息

## 对应模块

- jdk-17-demo

## 代码入口

- 统一运行入口：[../jdk-17-demo/src/main/java/com/juice/jdk17/DemoApplication.java](../jdk-17-demo/src/main/java/com/juice/jdk17/DemoApplication.java)
- Record 示例：[../jdk-17-demo/src/main/java/com/juice/jdk17/records/RecordExample.java](../jdk-17-demo/src/main/java/com/juice/jdk17/records/RecordExample.java)
- Sealed Class 示例：[../jdk-17-demo/src/main/java/com/juice/jdk17/sealed/SealedClassExample.java](../jdk-17-demo/src/main/java/com/juice/jdk17/sealed/SealedClassExample.java)
- Pattern Matching 示例：[../jdk-17-demo/src/main/java/com/juice/jdk17/patternmatching/PatternMatchingExample.java](../jdk-17-demo/src/main/java/com/juice/jdk17/patternmatching/PatternMatchingExample.java)
- Text Blocks 示例：[../jdk-17-demo/src/main/java/com/juice/jdk17/textblocks/TextBlocksExample.java](../jdk-17-demo/src/main/java/com/juice/jdk17/textblocks/TextBlocksExample.java)
- 改进的空指针异常信息示例：[../jdk-17-demo/src/main/java/com/juice/jdk17/helpfulnpe/HelpfulNullPointerExample.java](../jdk-17-demo/src/main/java/com/juice/jdk17/helpfulnpe/HelpfulNullPointerExample.java)

## 各特性详解

### 1. Record

#### 背景与痛点

在传统 Java 写法里，如果只是想定义一个简单的数据载体类，往往也要手写字段、构造器、getter、equals、hashCode 和 toString。逻辑很少，样板很多。

Record 的价值在于：它把“我需要一个不可变、以数据为中心的类型”这件事直接表达出来。

#### 示例代码

```java
public record FeatureNote(String name, int releaseYear) {

	public String summary() {
		return name + " (" + releaseYear + ")";
	}
}
```

```java
FeatureNote record = new FeatureNote("record", 2021);
FeatureNote sameRecord = new FeatureNote("record", 2021);
```

这个例子展示了三点：

1. 字段定义和主构造器声明可以合并在一行里。
2. 访问器方法会自动生成，例如 name()。
3. equals 和 hashCode 默认按值语义工作。

#### 适用场景

- DTO
- 配置对象
- 查询结果承载对象
- 以数据为核心、行为较少的模型

### 2. Sealed Class

#### 背景与痛点

传统继承体系里，一个公开父类往往无法很好地限制谁可以继承自己。Sealed Class 提供了更明确的继承边界，让类型层次的设计更可控。

#### 示例代码

```java
public sealed interface Shape permits Circle, Rectangle {

	double area();
}
```

```java
public final class Circle implements Shape {
	// ...
}
```

```java
public final class Rectangle implements Shape {
	// ...
}
```

这个示例的重点是：

1. Shape 只允许 Circle 和 Rectangle 实现。
2. 受限子类型本身也必须明确声明为 final、sealed 或 non-sealed。

#### 适用场景

- 有明确边界的领域模型
- 状态机建模
- 希望约束扩展点的继承层次

### 3. Pattern Matching for instanceof

#### 背景与痛点

传统 instanceof 写法经常是两步：先判断，再强转。重复变量声明和强制类型转换会带来额外噪音。

#### 示例代码

```java
if (value instanceof String text) {
	return "string length=" + text.length();
}
if (value instanceof Circle circle) {
	return "circle radius=" + circle.radius();
}
```

JDK 17 的这项改进，让“类型判断 + 绑定变量”一步完成，代码更自然。

#### 适用场景

- 类型分支处理
- 对多态对象做轻量判断
- 减少样板式强转代码

### 4. Text Blocks

#### 背景与痛点

在旧写法里，多行 JSON、SQL、HTML 片段通常要大量拼接字符串，转义和缩进都不友好。Text Blocks 解决的不是性能问题，而是可读性问题。

#### 示例代码

```java
String json = """
		{
		  "project": "juice",
		  "topic": "JDK 17",
		  "feature": "text blocks"
		}
		""";
```

```java
String sql = """
		SELECT feature_name, release_year
		FROM jdk_features
		WHERE release_year >= 2021
		ORDER BY feature_name
		""";
```

#### 适用场景

- 嵌入 JSON
- 嵌入 SQL
- 多行模板文本
- 教学和演示代码中的结构化文本

### 5. 改进的空指针异常信息

#### 背景与痛点

早期 Java 里的 NullPointerException 往往只告诉你“发生了空指针”，但不一定直接说明是哪一段链路出了问题。更详细的异常信息能明显降低定位成本。

#### 示例代码

```java
public static int lengthOfOwnerName(Project project) {
	return project.owner().name().length();
}
```

```java
try {
	lengthOfOwnerName(new Project(new Owner(null)));
} catch (NullPointerException exception) {
	System.out.println(exception.getMessage());
}
```

这个示例演示的是：当链式调用中的某一段返回 null 时，异常消息会更明确地指出问题位置。

#### 适用场景

- 日常调试
- 排查复杂对象链上的空值问题
- 降低日志定位成本

## 与旧版本写法对比

JDK 17 和更早版本相比，最明显的变化不是“会不会写出来”，而是“能不能写得更接近设计意图”。

1. Record 让数据模型定义更直接。
2. Sealed Class 让继承边界更明确。
3. Pattern Matching 让类型判断更紧凑。
4. Text Blocks 让多行文本不再充满转义噪音。
5. 更友好的异常信息让排查问题更高效。

## 适用场景与落地建议

如果是在真实项目中落地 JDK 17，建议优先关注：

1. 哪些 DTO 或配置对象适合改成 record。
2. 哪些枚举化程度较高的层次结构适合改成 sealed 类型体系。
3. 哪些地方存在大量 instanceof + 强转的样板代码。
4. 哪些 JSON、SQL 或模板字符串适合改成 text blocks。

## 升级或使用注意事项

1. Record 更适合数据载体，不适合强行为复杂领域对象套用。
2. Sealed Class 的价值在于边界清晰，只有在模型层次明确时才值得引入。
3. Text Blocks 可以提升可读性，但也要注意缩进和输出内容的精确控制。
4. 改进的空指针异常信息是排查问题的辅助，不是替代空值设计的手段。

## 本章小结

JDK 17 的核心价值在于，它把 Java 的表达方式继续往“更清晰、更可控、更接近意图”的方向推进了一步。

本模块当前已经配套实现了以下示例：

1. Record
2. Sealed Class
3. Pattern Matching for instanceof
4. Text Blocks
5. 改进的空指针异常信息

## 编写说明

后续如果继续细化 JDK 17 章节，可以补充：

1. Record 的构造约束与校验示例
2. Sealed Class 与模式匹配配合的更完整示例
3. Text Blocks 的缩进控制案例
4. 旧版 instanceof + 强转写法与新写法的对照案例
