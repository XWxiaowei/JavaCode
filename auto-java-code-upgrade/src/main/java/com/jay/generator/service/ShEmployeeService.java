import java.util.List;
import java.util.Map;

/**
*
* @author generator.wei
*
*/
public interface ShEmployeeService {
	/**
	* 分页查询
	* @param ShEmployee
	* @return
	*/
	List<ShEmployee> queryPageList(ShEmployee ShEmployee);

	/**
	* 新增数据
	* @param ShEmployee
	* @return
	*/
	int  saveShEmployee(ShEmployee ShEmployee);

	/**
	* 修改数据
	* @param ShEmployee
	* @return
	*/
	int  modifyShEmployee(ShEmployee ShEmployee);
	


}
