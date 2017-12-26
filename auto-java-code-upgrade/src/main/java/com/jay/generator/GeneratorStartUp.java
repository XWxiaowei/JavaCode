package com.jay.generator;

import com.jay.generator.api.AutoGenerationJavaCodeUpgrade;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author generator.wei
 * @create 2017/12/7 15:45
 */
public class GeneratorStartUp {

    /**
     * @param args
     * @throws URISyntaxException
     *
     */
    public static void main(String[] args) throws URISyntaxException {
        try {
            //读取属性文件
            FileInputStream inStream  = new FileInputStream(new File(System.getProperty("user.dir") + "/auto-java-code-upgrade/src/main/resources/generatorConfig.properties"));
            Properties prop = new Properties();
            prop.load(inStream);
            String servicePackage = prop.getProperty("servicePath");

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            // 1、生成XML, Map, Model
            //直接获取generatorConfig.xml的文件路径 根据具体情况查看
            File configFile = new File(System.getProperty("user.dir") + "/auto-java-code-upgrade/src/main/resources/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            //获取包路径
            List<Context> contexts = config.getContexts();
            if (contexts == null || contexts.size() == 0) {
                return;
            }
            for (Context context : contexts) {
                List<TableConfiguration> tableConfigurations = context.getTableConfigurations();
                if (tableConfigurations != null && tableConfigurations.size() > 0) {
                    for (TableConfiguration tableConfiguration : tableConfigurations) {
                        //获取实体类类名
                        String domainObjectName=tableConfiguration.getDomainObjectName();
                        //生成service
                        AutoGenerationJavaCodeUpgrade autoGenerationJavaCodeUpgrade = new AutoGenerationJavaCodeUpgrade();
                        autoGenerationJavaCodeUpgrade.autoGenerationJavaCode(domainObjectName,System.getProperty("user.dir") + "/auto-java-code-upgrade/src/main/java/"+servicePackage);
                        //生成controller
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
