package com.currentbp.test.javaBaseTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author current_bp
 * @createTime 20160808
 *
 */
public class OutOfMemoryErrorTest {

	/*
	 * 测试此种方法是否正确
	 */
	public static void main(String[] args) {
		Map<Long, Long> map = new HashMap<Long, Long>();
		map.put(1L, 2L);
		map.put(2L, 3L);
		map.put(3L, 4L);
		map.put(4L, 5L);

		List<Long> l1 = new ArrayList<Long>();
		l1.add(5L);
		System.out.println("l1:" + l1);
		for (int i = 0; i < l1.size(); i++) {
			Long newId = map.get(l1.get(i));
//			if (null != newId) {//如果没有判断为空，则将空添加到list中，然后就挂了。。。。。
				l1.add(newId);
//			}
		}
		System.out.println("l1:" + l1);
	}
	
	
	/*
2016-08-08 15:06:14.010  INFO 8286 --- [http-nio-8082-exec-7] com.lecloud.sports.filter.LoginFilter    : requestURI = /file/list
2016-08-08 15:06:14.023  INFO 8286 --- [http-nio-8082-exec-2] com.lecloud.sports.filter.LoginFilter    : requestURI = /file/dir
2016-08-08 15:06:14.029  INFO 8286 --- [http-nio-8082-exec-10] com.lecloud.sports.filter.LoginFilter    : requestURI = /customer/space
2016-08-08 15:06:18.854  INFO 8286 --- [http-nio-8082-exec-7] c.l.sports.controller.FileController     : ===> fileList: customerId = 400076, name = null, type = null, pid = 0, pageIndex = 1, pageSize = 100
2016-08-08 15:06:18.855  INFO 8286 --- [http-nio-8082-exec-2] c.l.sports.controller.FileController     : ===>fileDir: customerId = 400076, pid = 0
2016-08-08 15:06:26.516 ERROR 8286 --- [http-nio-8082-exec-3] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Handler processing failed; nested exception is java.lang.OutOfMemoryError: Java heap space] with root cause

java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)//此处是重点
	at com.lecloud.sports.service.impl.FileServiceImpl.updateUpFileStatus(FileServiceImpl.java:1447)//此处是重点
	at com.lecloud.sports.service.impl.FileServiceImpl.changeFileStatusRelationGarbage(FileServiceImpl.java:1365)
	at com.lecloud.sports.service.impl.FileServiceImpl.restore(FileServiceImpl.java:1263)
	at com.alibaba.dubbo.common.bytecode.Wrapper4.invokeMethod(Wrapper4.java)
	at com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory$1.doInvoke(JavassistProxyFactory.java:46)
	at com.alibaba.dubbo.rpc.proxy.AbstractProxyInvoker.invoke(AbstractProxyInvoker.java:72)
	at com.alibaba.dubbo.rpc.protocol.InvokerWrapper.invoke(InvokerWrapper.java:53)
	at com.alibaba.dubbo.rpc.filter.ExceptionFilter.invoke(ExceptionFilter.java:64)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.monitor.support.MonitorFilter.invoke(MonitorFilter.java:75)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.filter.TimeoutFilter.invoke(TimeoutFilter.java:42)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.protocol.dubbo.filter.TraceFilter.invoke(TraceFilter.java:78)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.filter.ContextFilter.invoke(ContextFilter.java:60)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.filter.GenericFilter.invoke(GenericFilter.java:112)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.filter.ClassLoaderFilter.invoke(ClassLoaderFilter.java:38)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.filter.EchoFilter.invoke(EchoFilter.java:38)
	at com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)
	at com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol$1.reply(DubboProtocol.java:108)
	at com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeHandler.handleRequest(HeaderExchangeHandler.java:84)
	at com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeHandler.received(HeaderExchangeHandler.java:170)
	at com.alibaba.dubbo.remoting.transport.DecodeHandler.received(DecodeHandler.java:52)


	 */

}
