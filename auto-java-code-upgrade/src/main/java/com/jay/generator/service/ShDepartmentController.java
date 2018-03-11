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
public class ShDepartmentController {
	
	@Autowired
	ShDepartmentService ShDepartmentService;

	/**
	* 分页查询
	* @param ShDepartment
	* @return
	*/
	@RequestMapping("/query")
	@ResponseBody
	public List<ShDepartment> queryPageList(ShDepartment ShDepartment){
          List<ShDepartment> list = ShDepartmentService.queryPageList(ShDepartment);
		  return list;	  
	}

	/**
	* 新增数据
	* @param ShDepartment
	* @return
	*/
	@RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
	public int  saveShDepartment(ShDepartment ShDepartment){
		  int result = ShDepartmentService.ShDepartmentSave(ShDepartment);
		  return result;
	}

	/**
	* 修改数据
	* @param ShDepartment
	* @return
	*/
	@RequestMapping("/mod")
	@ResponseBody
	public int modifyShDepartment(ShDepartment ShDepartment){
		  int result = ShDepartmentService.ShDepartmentModify(ShDepartment);
		  return result;
	}
}
