@[TOC](源码环境搭建)
spring-frame版本：5.3.1，2020年用最新版搭建的，不去搭最新的了方法都是一样的。
最下面有搭建方式看`gradle简单使用`。修改为国内镜像，修改`spirng-core`就差不多了</br>
源码仓库地址`https://github.com/SuperLaKer/spring-source-env.git`

## 搭建环境

- 我的JDK版本`1.8.0_281`。IDEA版本2020.3可以，最新版的也可以不过可能会出现一些问题，下面有解决方式
- IDEA下载`https://www.jetbrains.com/idea/download/other.html`
- 使用IDEA克隆并打开项目
- IDEA会提示找不到gradle-6.7的压缩包👇，修改`/gradle/wrapper/gradle-wrapper.properties`指定自己gradle压缩包的位置
- (下载gradle`https://downloads.gradle-dn.com/distributions/gradle-6.7-bin.zip`)
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/725fa9dd8dfa44f58e45d30ad66041b4.png#pic_center)
- 指定好gradle的位置之后刷新IDEA就行了，等待下载依赖。依赖仓库地址修改成了阿里的地址，速度应该还可以
- (下载的依赖共有3个G左右，默认下载到用户目录下的`.gradle文件夹`。也可以指定依赖下载的位置：配置环境变量`GRADLE_USER_HOME=绝对路径`，gradle下载的依赖会放到`GRADLE_USER_HOME`)

- 先编译后打包，`build`时可能会报错检查`codeStyle之类的`忽略直接执行jar命令就行。
- jar命令执行完就可以去`aa-test`工程运行`Main`看看能不能正常运行。环境到此就打搭好了
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/a03e29609c4c4cd9932e1d6c219f1c3f.png#pic_center)
---

## gradle简单使用
- 常用导入依赖的方式有下面两种👇
- 导入maven仓库中的依赖：`compile 'org.springframework:spring-core:5.3.1'`，项目maven仓库已经替换为阿里的镜像地址了
- 模块间依赖：`compile(project(":spring-core"))`，我就是把这里改了，改成上面那种方式了
- 使用阿里仓库：修改所有的`build.gradle`文件，👇首先使用阿里仓库，然后本地maven仓库，maven中心仓库，最后一个应该是gradle插件仓库吧
- 如果出现类在`运行期间`不存在的问题，可能是gradle依赖传递的问题。`implementation`会传递依赖，`compile`不会。如果没有用对可能会出现明明类存在但是运行或编译的时候报类不存在的问题。
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/3ee8165001844bdc95b53093f8fc7ad6.png#pic_center)
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

## 使用IDEA构建
默认情况使用gradle编译运行日志比较多，可以运行`aa-test/org.springframework.aa.Main`看看。
更改为使用IDEA构建和运行，没有gradle日志。
![在这里插入图片描述](https://img-blog.csdnimg.cn/6b1e664fa0174c0492ae0811c9371f70.png#pic_center)
使用IDEA编译和运行会产生一个问题`Kotlin: warnings found and -Werror specified`，解决方式如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/7479fa87b37a49e6aa8a79af5cffa951.png#pic_center)
