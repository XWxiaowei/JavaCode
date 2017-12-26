## 自动生成代码
## 实现功能
1. 通用的新增方法
2. 通用的分页方法
3. 通用的修改方法
## 注意事项
- 需要修改的位置 
### generatorConfig.properties文件中
 1. 项目路径
 2. jdbcConnection 连接的相关配置
### generatorConfig.xml文件中
 1. 生成对应表及类名 这个配置需要修改，你需要对哪些表生产代码就添加哪些表
## 运行
直接运行GeneratorStartUp类即可
## 相关技术探究
### 涉及到的设计模式
1.适配器模式
### 业务流转
1. `MyIntrospectedTableMyBatis3SimpleImpl`继承自`IntrospectedTableMyBatis3Impl`实现了`IntrospectedTable`接口
该`IntrospectedTableMyBatis3Impl`类是生成文件的主控制类
2. 扩展方法的话只需要修改 `MySimpleXMLMapperGenerator`类的`getSqlMapElement`方法，以及修改
`MySimpleJavaClientGenerator`类的`getCompilationUnits`方法。在这儿添加你需要添加或者修改的方法。
3. 类 `MyPluginAdapter`允许我们做一些额外的设置，如不需要某些方法生成

### 参考文档：
http://www.mybatis.org/generator/index.html