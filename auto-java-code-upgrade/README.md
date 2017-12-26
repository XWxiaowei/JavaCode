## 自动生成代码
## 实现功能
1. 通用的新增方法
2. 通用的分页方法
3. 通用的修改方法
## 注意事项
1. 需要修改的位置 
### generatorConfig.properties文件中
1. 项目路径
2. jdbcConnection 连接的相关配置
### generatorConfig.xml文件中
1. 生成对应表及类名 这个配置需要修改，你需要对哪些表生产代码就添加哪些表
## 运行
直接运行GeneratorStartUp类即可
## 相关技术探究


### 参考文档：
http://www.mybatis.org/generator/index.html