package ${packageName};
import java.util.List;
import java.util.Map;
import ${modelPackageName}.${className?cap_first};
import com.jay.generator.pagehelper.PageInfo;

/**
*
* @author generator.wei
*
*/
public interface ${className?cap_first}Service {
	/**
	* 分页查询
	* @param pageInfo
	* @return
	*/
    PageInfo<${className?cap_first}> queryPageList(PageInfo<${className?cap_first}> pageInfo);

	/**
	* 新增数据
	* @param ${className}
	* @return
	*/
	int  save${className?cap_first}(${className?cap_first} ${className});

	/**
	* 修改数据
	* @param ${className}
	* @return
	*/
	int  modify${className?cap_first}(${className?cap_first} ${className});
	


}
