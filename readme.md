
spring-framework 源码阅读环境
---
spring-frame版本：5.3.1两年前搭的，没必要追求最新的最下面有搭建方式
仓库地址`https://github.com/SuperLaKer/spring-source-env.git`
5.3.1 我的JDK版本`1.8.0_281`。IDEA版本2020.3没问题
高版本IDEA会出现`Werror`的问题参考这个`https://blog.csdn.net/Summer_Xi/article/details/120779190`，每个模块都要去掉-Werror




### 搭建环境

- 
- 使用IDEA克隆并打开项目
- IDEA会提示找不到gradle-6.7的压缩包👇，修改`/gradle/wrapper/gradle-wrapper.properties`指定自己gradle压缩包的位置
- (下载gradle`https://downloads.gradle-dn.com/distributions/gradle-6.7-bin.zip`)
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/725fa9dd8dfa44f58e45d30ad66041b4.png#pic_center)
- 指定好gradle的位置之后刷新IDEA就行了，等待下载依赖。依赖仓库地址修改成了阿里的地址，速度应该还可以(下载的依赖共有3个G左右，默认下载到用户目录下的`.gradle文件夹`。也可以指定依赖下载的位置👇)
- 自定义依赖的下载位置需要添加环境变量`GRADLE_USER_HOME=自己的文件夹绝对路径`，也可以下载我的依赖👇，然后解压到自己的文件夹下`链接：https://pan.baidu.com/s/1R5-qzppPVXmz-EbDBXjP4w 提取码：like`
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/862f57fb03c24393b164e1860cf69b8c.png#pic_center)
- 先编译后打包
- `build`时会报`spring-oxm`错误，这个错误不用管，直接执行jar命令。
- 打包完成去`aa-test`工程下面愉快玩耍

编译build，打包jar
![在这里插入图片描述](https://img-blog.csdnimg.cn/a03e29609c4c4cd9932e1d6c219f1c3f.png#pic_center)

### 做了一些修改
1、不在依赖模`spring-core`模块，直接引用maven仓库中的jar包。core中有很多依赖很难搞，避免一大堆依赖异常。
2、使用阿里镜像源加速gradle下载jar包
3、自定义gradle压缩包的位置（推荐下载到本地，修改/gradle/wrapper/gradle-wrapper.properties配置文件指定自己下载的gradle）

### 其他
- 看spring源码不需要去用学太多gradle相关的东西，常用导入依赖的方式有下面两种👇
- 导入maven仓库中的依赖：`compile 'org.springframework:spring-core:5.3.1'`，项目maven仓库已经替换为阿里的镜像地址了
- 模块间依赖：`compile(project(":spring-core"))`，我就是把这里改了，改成上面那种方式了
- 使用阿里仓库：修改所有的`build.gradle`文件，👇首先使用阿里仓库，然后本地maven仓库，maven中心仓库，最后一个应该是gradle插件仓库吧
```gradle
repositories {
	maven {
		url 'https://maven.aliyun.com/repository/public/'
	}
	mavenLocal()
	mavenCentral()
	gradlePluginPortal()
}
```