import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*
* @author generator.wei
*
*/
@Controller
public class ${className?cap_first}Controller {
	
	@Autowired
	${className?cap_first}Service ${className}Service;

	/**
	* 分页查询
	* @param ${className}
	* @return
	*/
	@RequestMapping("/query")
	@ResponseBody
	public List<${className?cap_first}> queryPageList(${className?cap_first} ${className}){
          List<${className?cap_first}> list = ${className}Service.queryPageList(${className});
		  return list;	  
	}

	/**
	* 新增数据
	* @param ${className}
	* @return
	*/
	@RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
	public int  save${className}(${className?cap_first} ${className}){
		  int result = ${className}Service.${className}Save(${className});
		  return result;
	}

	/**
	* 修改数据
	* @param ${className}
	* @return
	*/
	@RequestMapping("/mod")
	@ResponseBody
	public int modify${className}(${className?cap_first} ${className}){
		  int result = ${className}Service.${className}Modify(${className});
		  return result;
	}
}
