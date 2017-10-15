package com.jay.ssh.dao.impl;

import com.jay.ssh.dao.DepartmentDao;
import com.jay.ssh.entity.Department;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by xiang.wei on 2017/10/14
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    //不添加项目中所有Dao实现类都继承了HibernateDaoSupport接口，
    // 如果Dao或配置文件中没有'sessionFactory' 或者'hibernateTemplate'就会报错
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }
    //TODO hibernate的数据操作接口
    @Override
    public List<Department> findAll() {
        return (List<Department>) this.getHibernateTemplate().find("select * from Department");
    }

    @Override
    public Department findById(Integer did) {
        return this.getHibernateTemplate().get(Department.class, did);
    }

    @Override
    public void insert(Department department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }
}
