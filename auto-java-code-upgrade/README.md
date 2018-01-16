# 自动生成代码
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
## mybatis-generator-core相关技术探究
### 项目结构介绍
 1. `api`包主要提供外部接口，供扩展使用，切入点可以试`MyPluginAdapter`类
 2. `codegen` 包是生成文件的核心包，入口是`IntrospectedTableMyBatis3Impl`类，生成对应文件文件需要的类在对应的
 子包中，如：生成xml文件相关的类在 `xmlmapper`包中。
 3. `internal` 包下 `DefaultCommentGenerator` 类是用于生成对应的文档注释。可以扩展，扩展之后再修改一下generatorConfig.xml
 ```  <!--文档注释-->
            <commentGenerator type="com.jay.generator.internal.MyCommentGenerator">
                <property name="javaFileEncoding" value="UTF-8"/>
                <!--<property name="suppressDate" value="false"/> &lt;!&ndash; 是否生成注释代时间戳 &ndash;&gt;-->
                <!--<property name="suppressAllComments" value="true"/> &lt;!&ndash; 是否取消注释 &ndash;&gt;-->
            </commentGenerator>

   ```
### 涉及到的设计模式
1.适配器模式
### 业务流转
1. `MyIntrospectedTableMyBatis3SimpleImpl`继承自`IntrospectedTableMyBatis3Impl`实现了`IntrospectedTable`接口
该`IntrospectedTableMyBatis3Impl`类是生成Dao,model,xml文件的主控制类
2. 扩展方法的话只需要修改 `MySimpleXMLMapperGenerator`类的`getSqlMapElement`方法，以及修改
`MySimpleJavaClientGenerator`类的`getCompilationUnits`方法。在这儿添加你需要添加或者修改的方法。
3. 类 `MyPluginAdapter`允许我们做一些额外的设置，如不需要某些方法生成
4. 类 `AutoGenerationJavaCodeUpgrade` 主要生成为了生成service，controller文件，采用ftl变量替换预先定义的方法


### 参考文档：
http://www.mybatis.org/generator/index.html