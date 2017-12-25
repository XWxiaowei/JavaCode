import java.util.List;
import java.util.Map;

/**
*
* @author generator.wei
*
*/
public interface ${className?cap_first}Service {
	/**
	* 分页查询
	* @param ${className}
	* @return
	*/
	List<${className?cap_first}> queryPageList(${className?cap_first} ${className});

	/**
	* 新增数据
	* @param ${className}
	* @return
	*/
	int  save${className}(${className?cap_first} ${className});

	/**
	* 修改数据
	* @param ${className}
	* @return
	*/
	int  modify${className}(${className?cap_first} ${className});
	


}
