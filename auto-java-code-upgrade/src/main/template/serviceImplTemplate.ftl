import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ${className?cap_first}ServiceImpl implements ${className?cap_first}Service{
	
	@Autowired
	${className?cap_first}Mapper ${className}Mapper;
    //分页查询
	public List<${className?cap_first}> queryPageList(${className?cap_first} ${className}){
		  List<${className?cap_first}> list = ${className}Mapper.queryPageList(${className});
		  return list;	  
	}

	//新增
	public int ${className}Save(${className?cap_first} ${className}){
		  int result = ${className}Mapper.insert(${className});
		  return result;
	}
	
	//修改
	public int ${className}Modify(${className?cap_first} ${className}){
		  int result = ${className}Mapper.${className}Modify(${className});
		  return result;
	}

}
