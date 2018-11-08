package ${packageName};
import ${modelPackageName}.${className?cap_first};
import com.aisino.projects.task.web.base.ServiceImpl;
import org.springframework.stereotype.Service;
import ${daoTargetPackage}.${daoTargetPackage?cap_first};


/**
*
* @author xiang.wei
*
*/
@Service
public class ${className?cap_first}ServiceImpl extends ServiceImpl<${className?cap_first}Mapper,${className?cap_first}> implements ${className?cap_first}Service {

}
