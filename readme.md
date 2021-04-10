spring-framework 源码阅读环境
---

网络不好修改这里：
- 修改此配置文件：`/gradle/gradle-wrapper.properties`
  </br>
` distributionUrl=file\:///d\:/env/zip/gradle-6.7-bin.zip`


    

gradle使用阿里镜像源
移除spring-core，直接依赖spring-core.jar，避免一大堆异常，jdk8直接跑