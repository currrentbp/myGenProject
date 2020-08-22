#日志测试

> 关于日志的测试，
> LogTest做的测试是使用自定义添加字段模式，
例如：自定了一个currentOperatorId新字段，在logback.xml中添加[%X{currentOperatorId}]。

> 日志结果如下:
> 2020-08-15 10:58:57.741[22222] [192.168.1.6]  INFO   --- [main] com.currentbp.test.LogTest.LogTest       : 11111111111111

> 2020-08-15 10:58:57.835[444444] [192.168.1.6]  INFO   --- [Thread-0] com.currentbp.test.LogTest.LogTest       : 3333333333

> 2020-08-15 10:58:57.836[666] [192.168.1.6]  INFO   --- [Thread-1] com.currentbp.test.LogTest.LogTest       : 555555555555

