package com.jay.ssh.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiang.wei
 * @create 2017/10/26 11:13
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractActionTest extends StrutsSpringTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        SessionFactory sessionFactory = lookupSessionFactory(request);
        Session hibernateSession= getSession(sessionFactory);
        TransactionSynchronizationManager.bindResource(sessionFactory,
                new SessionHolder(hibernateSession));
        //在只读模式下(FlushMode.NEVER/MANUAL)写操作不被允许
        hibernateSession.setFlushMode(FlushMode.AUTO);
    }
    private Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
        Session session = sessionFactory.openSession();
        FlushMode flushMode = FlushMode.NEVER;
        if (flushMode != null) {
            session.setFlushMode(flushMode);
        }
        return session;
    }
    private SessionFactory lookupSessionFactory(HttpServletRequest request) {
        //“sessionFactory”是你spring配置文件（通常是application.xml）中的SessionFactory。
        //如：org.springframework.orm.hibernate4.annotation.AnnotationSessionFactoryBean
        return (SessionFactory)this.applicationContext.getBean("sessionFactory");
    }
    @Override
    public String getContextLocations() {
        return "file:src/main/resources/spring.xml";
    }

}
