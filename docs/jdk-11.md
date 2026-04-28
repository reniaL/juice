# JDK 11

## 版本简介

JDK 11 是 JDK 8 之后非常重要的一个长期支持版本。相比 JDK 8 更偏向“编程范式变化”，JDK 11 的代表性价值更集中在标准库增强、语法细节补充，以及开发体验的改善。

很多团队在生产环境里从 JDK 8 升级时，JDK 11 往往是第一个现实的目标版本。因此，这一章的重点不仅是“新增了什么”，还包括“这些变化为什么更适合落地”。

## 为什么这个版本值得重点学习

JDK 11 值得重点学习，主要有三个原因：

1. 它是一个长期支持版本，很多企业级项目会把它作为升级落点。
2. 它补齐了标准库中一些长期缺失但实际开发里很常用的能力，例如官方 HttpClient。
3. 它延续了 JDK 8 之后的现代化方向，让一些细节写法更顺手，例如 String、Files、Optional、lambda 参数语法的增强。

## 计划覆盖的主要特性

- HttpClient API
- 单文件源码运行
- String API 增强
- Files API 增强
- var 在 Lambda 参数中的使用
- Optional 与集合相关 API 的补充能力

## 对应模块

- jdk-11-demo

## 代码入口

- 统一运行入口：[../jdk-11-demo/src/main/java/com/juice/jdk11/DemoApplication.java](../jdk-11-demo/src/main/java/com/juice/jdk11/DemoApplication.java)
- HttpClient 示例：[../jdk-11-demo/src/main/java/com/juice/jdk11/httpclient/HttpClientExample.java](../jdk-11-demo/src/main/java/com/juice/jdk11/httpclient/HttpClientExample.java)
- 单文件源码运行示例：[../jdk-11-demo/single-file/SingleFileHello.java](../jdk-11-demo/single-file/SingleFileHello.java)
- String API 示例：[../jdk-11-demo/src/main/java/com/juice/jdk11/stringapi/StringApiExample.java](../jdk-11-demo/src/main/java/com/juice/jdk11/stringapi/StringApiExample.java)
- Files API 示例：[../jdk-11-demo/src/main/java/com/juice/jdk11/filesapi/FilesApiExample.java](../jdk-11-demo/src/main/java/com/juice/jdk11/filesapi/FilesApiExample.java)
- var in lambda 示例：[../jdk-11-demo/src/main/java/com/juice/jdk11/varlambda/VarInLambdaExample.java](../jdk-11-demo/src/main/java/com/juice/jdk11/varlambda/VarInLambdaExample.java)
- Optional 与集合相关 API 示例：[../jdk-11-demo/src/main/java/com/juice/jdk11/optionalcollection/OptionalCollectionExample.java](../jdk-11-demo/src/main/java/com/juice/jdk11/optionalcollection/OptionalCollectionExample.java)

## 各特性详解

### 1. HttpClient API

#### 背景与痛点

在较早的 Java 版本里，如果想发 HTTP 请求，常见选择要么是 HttpURLConnection，要么是引入第三方库。前者接口陈旧、使用体验一般，后者虽然强大，但并不是每个项目都希望为了基础 HTTP 调用额外增加依赖。

JDK 11 提供了正式的 HttpClient API，用统一、现代的方式处理请求构建、同步调用和异步调用。

#### 示例代码

```java
HttpClient client = HttpClient.newBuilder()
	.connectTimeout(Duration.ofSeconds(2))
	.version(HttpClient.Version.HTTP_2)
	.build();

HttpRequest request = HttpRequest.newBuilder(URI.create("https://example.com/api/health"))
	.timeout(Duration.ofSeconds(5))
	.header("Accept", "application/json")
	.GET()
	.build();
```

这个示例重点展示 API 结构本身，而不依赖真实网络请求。这样做的目的是让示例保持稳定，突出 JDK 11 官方 HTTP 客户端的构建方式。

#### 适用场景

- 简单的 HTTP 调用
- 无需额外引入第三方依赖的工具型程序
- 需要同步或异步请求能力的标准库场景

### 2. 单文件源码运行

#### 背景与痛点

对于很小的脚本式程序，过去通常要先编译再运行。JDK 11 提供了单文件源码运行能力，可以直接用 java 命令执行源文件。

#### 示例代码

```java
public class SingleFileHello {

    public static void main(String[] args) {
	System.out.println("Run me with: java SingleFileHello.java");
	System.out.println("This demonstrates the JDK 11 single-file source launcher.");
    }
}
```

可以直接执行：

```bash
java SingleFileHello.java
```

#### 适用场景

- 临时脚本
- 轻量工具程序
- 演示或教学中的最小示例

#### 注意事项

- 这种方式更适合单文件或小规模场景，不适合替代正常的项目构建方式。

### 3. String API 增强

#### 背景与痛点

JDK 11 在 String 上补充了一些非常实用的方法，解决了很多日常开发中必须自己手写工具逻辑的问题。

#### 示例代码

```java
String raw = "  juice java\nstream api\n\n";
String blank = "   \t";

blank.isBlank();
raw.strip();
"na".repeat(3);
raw.lines();
```

这个示例体现了四个常用增强：

1. isBlank：判断字符串是否只包含空白字符。
2. strip：去除 Unicode 感知的首尾空白。
3. repeat：重复字符串。
4. lines：按行拆分内容并返回 Stream。

#### 适用场景

- 文本预处理
- 多行文本解析
- 简化原本零散的字符串工具代码

### 4. Files API 增强

#### 背景与痛点

读写文本文件原本要先把字节和字符流拼起来，代码不长但容易显得啰嗦。JDK 11 为 Files 提供了更直接的 writeString 和 readString。

#### 示例代码

```java
Path tempFile = Files.createTempFile("juice-jdk11-", ".txt");
Files.writeString(tempFile, "JDK 11 Files API");
String content = Files.readString(tempFile);
```

#### 适用场景

- 简单文本配置读写
- 小型文件处理脚本
- 替代样板较多的 Reader/Writer 写法

### 5. var 在 Lambda 参数中的使用

#### 背景与痛点

JDK 10 引入了局部变量类型推断 var，但最初不能直接用于 lambda 参数。JDK 11 补上了这一点，让 lambda 参数在某些场景下也能使用统一的写法。

#### 示例代码

```java
BiFunction<String, String, String> joiner = (var left, var right) -> left + " -> " + right;
```

#### 说明

这个特性本身不是为了让所有 lambda 都改写成 var，而是为了让参数写法更一致，尤其是在需要附加注解时更有价值。

#### 注意事项

- 一旦使用 var，lambda 的所有参数都必须统一使用 var。
- 如果本来写成显式类型或省略类型更清晰，就没有必要强行改成 var。

### 6. Optional 与集合相关 API 的补充能力

#### 背景与痛点

JDK 11 没有像 JDK 8 那样引入一个全新的集合体系，但它确实补了一些在集合处理和空值表达中很顺手的小增强。

#### 示例代码

```java
Optional<String> empty = Optional.empty();
boolean missing = empty.isEmpty();
```

```java
List<String> filtered = values.stream()
	.filter(Predicate.not(String::isBlank))
	.collect(Collectors.toList());

String[] array = filtered.toArray(String[]::new);
```

这个示例重点展示了三点：

1. Optional.isEmpty 让“为空”的判断更直接。
2. Predicate.not 可以让过滤条件表达得更自然。
3. Collection.toArray(IntFunction) 让数组转换更简洁。

#### 适用场景

- 更清晰地表达 Optional 空值判断
- 对集合进行过滤和数组化输出
- 简化工具型代码里的细节写法

## 与旧版本写法对比

如果把 JDK 11 和 JDK 8 相比，可以看到一个明显区别：

1. JDK 8 更像是“编程风格的转折点”。
2. JDK 11 更像是“把现代写法真正补顺手”。

在 JDK 11 中，很多变化都不是颠覆式的，但非常实用。例如 String、Files、Optional 的补强，都会直接减少样板代码；HttpClient 则补齐了标准库层面的关键空缺。

## 适用场景与落地建议

如果是在真实项目中落地 JDK 11，建议优先关注：

1. HttpClient 是否可以替代部分旧的轻量 HTTP 场景。
2. String 和 Files 的增强是否可以直接清理一批工具方法。
3. 在合适的地方使用 Optional.isEmpty、Predicate.not 这类细节增强，提高表达力。

## 升级或使用注意事项

1. JDK 11 的很多增强点都偏“小而实用”，不要低估它们对代码整洁度的价值。
2. 单文件源码运行适合脚本和演示，不是正式项目结构的替代方案。
3. HttpClient 示例在演示中可以不发实际请求，但真实项目里要进一步考虑超时、重试、异常处理等问题。

## 本章小结

JDK 11 是一个很适合作为生产升级目标的版本。它不像 JDK 8 那样带来强烈的范式冲击，但它把很多开发者真正会用到的能力补到了标准库和语言细节里。

本模块当前已经配套实现了以下示例：

1. HttpClient API
2. 单文件源码运行
3. String API 增强
4. Files API 增强
5. var 在 Lambda 参数中的使用
6. Optional 与集合相关 API 的补充能力

## 编写说明

后续如果继续细化 JDK 11 章节，可以补充：

1. HttpClient 的同步与异步请求对照示例
2. String.lines 与文件读取组合的更完整案例
3. Optional.isEmpty 与旧写法的迁移对照
4. 单文件源码运行与正式项目构建边界的说明

## 编写说明

本专题后续会围绕背景、示例代码、典型场景和注意事项逐步补齐内容。
