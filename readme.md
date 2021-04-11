spring-framework 源码阅读环境
---

网络问题：
- 修改此配置文件：`/gradle/gradle-wrapper.properties`
  </br>
` distributionUrl=file\:///d\:/env/zip/gradle-6.7-bin.zip`

编译问题:
  </br>
gradlew build -x test -x javadoc -x dokka -x asciidoctor -x asciidoctorPdf -x checkstyleMain
  </br>
// to-idea
gradlew :spring-oxm:compileTestJava -x test -x javadoc -x dokka -x asciidoctor -x asciidoctorPdf
    

修改：
  </br>
gradle使用阿里镜像源
移除spring-core
直接依赖spring-core.jar避免一大堆异常
不直接依赖rt.jar jdk8直接跑（"1.8.0_281"）
