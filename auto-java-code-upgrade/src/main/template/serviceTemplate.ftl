import java.util.List;
import java.util.Map;
public interface ${className?cap_first}Service {
    //分页查询
	List<${className?cap_first}> queryPageList(${className?cap_first} ${className});

	//新增
	int ${className}Save(${className?cap_first} ${className});
	
	//修改
	int ${className}Modify(${className?cap_first} ${className});
	


}
