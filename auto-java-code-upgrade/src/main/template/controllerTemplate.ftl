package ${packageName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ${modelPackageName}.${className?cap_first};
import ${modelPackageName}.${className?cap_first};


/**
*
* @author xiang.wei
*
*/
@Controller
@RequestMapping("/${className}")
public class ${className?cap_first}Controller {
	
	@Autowired
	private ${className?cap_first}Service ${className}Service;


}
