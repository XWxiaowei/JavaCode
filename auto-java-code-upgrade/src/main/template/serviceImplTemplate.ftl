package ${packageName};
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${mapperPackageName}.${className?cap_first}Mapper;
import ${packageName}.${className?cap_first}Service;
import ${modelPackageName}.${className?cap_first};
import com.jay.generator.pagehelper.PageInfo;




@Service("${className}Service")
public class ${className?cap_first}ServiceImpl implements ${className?cap_first}Service{
	
	@Autowired
  private ${className?cap_first}Mapper ${className}Mapper;
 @Override
 public PageInfo<${className?cap_first}>  queryPageList(PageInfo<${className?cap_first}> pageInfo){
     try {
       int total = ${className}Mapper.countList();
		if(total>0){
			List<${className?cap_first}> list = ${className}Mapper.queryPageList((pageInfo.getPageNum()-1)* pageInfo.getPageSize(), pageInfo.getPageSize());
			pageInfo.setList(list);
			pageInfo.setTotal(total);
           }
		} catch (Exception e) {

		return null;
		}
        return pageInfo;
	}
	@Override
	public int save${className?cap_first}(${className?cap_first} ${className}){
		  int result = ${className}Mapper.insert(${className});
		  return result;
	}
    @Override
	public int  modify${className?cap_first}(${className?cap_first} ${className}){
		  int result = ${className}Mapper.updateByPrimaryKey(${className});
		  return result;
	}

}
