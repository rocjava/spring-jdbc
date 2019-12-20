####jdbc源码示例  
com.penn.springjdbc.test.TestJDBC
#####jdbc流程  
1.读取并解析配置文件  
2.实例化DataSource,并放入spring容器  
3.获取连接getConnection,实际调用mysql驱动包中接口  
4.创建statement,编译sql  
5.执行，并解析结果  
6.关闭连接  

#####jdbc总结  
1.prepareStatement会预编译sql，可以有效防止sql注入攻击，其原理也简单，就是会转义其中的特殊字符。

****