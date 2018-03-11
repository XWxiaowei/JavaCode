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
public class ShEmployeeController {
	
	@Autowired
	ShEmployeeService ShEmployeeService;

	/**
	* 分页查询
	* @param ShEmployee
	* @return
	*/
	@RequestMapping("/query")
	@ResponseBody
	public List<ShEmployee> queryPageList(ShEmployee ShEmployee){
          List<ShEmployee> list = ShEmployeeService.queryPageList(ShEmployee);
		  return list;	  
	}

	/**
	* 新增数据
	* @param ShEmployee
	* @return
	*/
	@RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
	public int  saveShEmployee(ShEmployee ShEmployee){
		  int result = ShEmployeeService.ShEmployeeSave(ShEmployee);
		  return result;
	}

	/**
	* 修改数据
	* @param ShEmployee
	* @return
	*/
	@RequestMapping("/mod")
	@ResponseBody
	public int modifyShEmployee(ShEmployee ShEmployee){
		  int result = ShEmployeeService.ShEmployeeModify(ShEmployee);
		  return result;
	}
}
