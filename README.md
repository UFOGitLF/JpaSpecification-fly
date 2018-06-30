1:测试的时候只要将ddl-auto: none 改为：create新建表结构即可
2:初始化数据 init.sql
问题1:解决Method threw 'java.lang.StackOverflowError'异常
解决方法：
可以将多的一方对象里面重写的toString方法去掉，或者两个对象里面重写的toString方法都去掉。
注意：两个对象里面的toString都去掉的话，打印出来不方便查看，所以建议去掉一方。
问题2:解决数据重复问题
解决方法：
可以用将返回对象List<XXX> 转为Set<XXX> 并且重写该对象的equals()方法,一般根据ID主键去判断是否一致。