spring-framework 源码阅读环境
---


### 搭建环境
- 我的JDK版本`1.8.0_281`。IDEA版本2020.2之后发布的就可以，之前IDEA的没有试过`https://www.jetbrains.com/idea/download/other.html`
- 使用IDEA克隆并打开项目
- IDEA会提示找不到gradle-6.7的压缩包👇，修改`/gradle/wrapper/gradle-wrapper.properties`指定自己gradle压缩包的位置
- (下载gradle`https://downloads.gradle-dn.com/distributions/gradle-6.7-bin.zip`)
- 指定好gradle的位置之后刷新IDEA就行了，等待下载依赖(👇可以指定依赖下载的位置)
- (自定义依赖的下载位置需要添加环境变量`GRADLE_USER_HOME=自己的文件夹绝对路径`)
- 先编译后打包，看项目根目录下面的图片👇👇`spring-source-env\gradle编译打包.PNG`
- 打包完成去`aa-test`工程下面愉快玩耍


### 做了一些修改
1、不在依赖`spring-core`，直接引用maven包。core中有很多依赖很难搞，避免一大堆依赖异常
2、使用阿里镜像源加速gradle下载jar包
3、自定义gradle压缩包的位置（推荐使用迅雷下载到本地，修改/gradle/wrapper/gradle-wrapper.properties配置文件指定自己下载的gradle）


### 碎碎
- 看spring源码不需要去用学gradle，导入依赖有下面两种方式👇(编译期依赖和maven差不多)
- 导入maven仓库中的依赖：`compile 'org.springframework:spring-core:5.3.1'`，项目maven仓库已经替换为阿里的镜像地址了
- 模块间依赖：`compile(project(":spring-context"))`
- 如果IDEA版本较高的话可以直接往xxx.gradle中粘贴maven的依赖，IDEA会直接转化为gradle格式的依赖
- maven项目可以转化为gradle，但是会出现跟多问题

 
**希望用不到**
如果IDEA编译出现了问题可以试着在控制台执行这个命令，再导入IDEA：`./gradlew :spring-oxm:compileTestJava -x test -x javadoc -x dokka -x asciidoctor -x asciidoctorPdf`
