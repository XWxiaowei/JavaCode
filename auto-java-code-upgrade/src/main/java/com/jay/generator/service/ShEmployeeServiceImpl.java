import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ShEmployeeServiceImpl implements ShEmployeeService{
	
	@Autowired
	ShEmployeeMapper ShEmployeeMapper;
    //分页查询
	public List<ShEmployee> queryPageList(ShEmployee ShEmployee){
		  List<ShEmployee> list = ShEmployeeMapper.queryPageList(ShEmployee);
		  return list;	  
	}

	//新增
	public int ShEmployeeSave(ShEmployee ShEmployee){
		  int result = ShEmployeeMapper.insert(ShEmployee);
		  return result;
	}
	
	//修改
	public int ShEmployeeModify(ShEmployee ShEmployee){
		  int result = ShEmployeeMapper.ShEmployeeModify(ShEmployee);
		  return result;
	}

}
