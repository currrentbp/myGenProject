用于生产二维码的项目
首先需要JAR包，如果是MAVEN项目，
<dependencies>
<dependency>
<groupId>cn.bingoogolapple</groupId>
<artifactId>qrcodecore</artifactId>
<version>1.0.1</version>
<type>aar</type>
<scope>compile</scope>
</dependency>
<dependency>
<groupId>com.google.zxing</groupId>
<artifactId>core</artifactId>
<version>3.1.0</version>
<scope>compile</scope>
</dependency>
</dependencies>


如果不是maven项目，可以自己下载zxing的源码，https://github.com/zxing/zxing.git 
然后把源码中的两部分代码放到自己的一个新项目（xzing）中，代码：1）\zxing\javase\src\main\java\com
的所有文件放入新项目中，会有报错（忽略，反正我是没有管），然后导出jar包，其中有报错的（忽略），

