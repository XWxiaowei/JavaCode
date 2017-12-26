package ${packageName};
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import ${packageName}.${className?cap_first}Service;
import ${modelPackageName}.${className?cap_first};
import com.jay.generator.pagehelper.PageInfo;

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
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	*/
	@RequestMapping("/query")
	@ResponseBody
	public String queryPageList(Model model, Integer pageNum, Integer pageSize){
			PageInfo<${className?cap_first}> pageInfo =new PageInfo<${className?cap_first}>();
				if (pageNum != null && pageNum > 0) {
				pageInfo.setPageNum(pageNum);
				}
				if (pageSize != null && pageSize > 0) {
				pageInfo.setPageSize(pageSize);
				}
          List<${className?cap_first}> list = ${className}Service.queryPageList(pageInfo);
		  return "";
	}

	/**
	* 新增数据
	* @param ${className}
	* @return
	*/
	@RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
	public int  save${className}(${className?cap_first} ${className}){
		  int result = ${className}Service.save${className?cap_first}(${className});
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
		  int result = ${className}Service.modify${className?cap_first}(${className});
		  return result;
	}
}
