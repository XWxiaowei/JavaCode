import java.util.List;
import java.util.Map;

/**
*
* @author generator.wei
*
*/
public interface ShDepartmentService {
	/**
	* 分页查询
	* @param ShDepartment
	* @return
	*/
	List<ShDepartment> queryPageList(ShDepartment ShDepartment);

	/**
	* 新增数据
	* @param ShDepartment
	* @return
	*/
	int  saveShDepartment(ShDepartment ShDepartment);

	/**
	* 修改数据
	* @param ShDepartment
	* @return
	*/
	int  modifyShDepartment(ShDepartment ShDepartment);
	


}
