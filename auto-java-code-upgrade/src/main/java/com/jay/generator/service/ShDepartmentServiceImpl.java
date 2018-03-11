import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ShDepartmentServiceImpl implements ShDepartmentService{
	
	@Autowired
	ShDepartmentMapper ShDepartmentMapper;
    //分页查询
	public List<ShDepartment> queryPageList(ShDepartment ShDepartment){
		  List<ShDepartment> list = ShDepartmentMapper.queryPageList(ShDepartment);
		  return list;	  
	}

	//新增
	public int ShDepartmentSave(ShDepartment ShDepartment){
		  int result = ShDepartmentMapper.insert(ShDepartment);
		  return result;
	}
	
	//修改
	public int ShDepartmentModify(ShDepartment ShDepartment){
		  int result = ShDepartmentMapper.ShDepartmentModify(ShDepartment);
		  return result;
	}

}
