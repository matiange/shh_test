import com.matinge.entity.Students;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.Configuration;

public class Main {


    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getL
        //1：获取配置
        org.hibernate.cfg.Configuration configure = new org.hibernate.cfg.Configuration().configure();
        //2：创建Session工厂
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //3：获取当前session
        Session session = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();
        sessionFactory.openSession();

        Students matiange = new Students("matiange", 23, "15393702296");
        try {
            //开启事务
            session.beginTransaction();
            session.save(matiange);
            //提交事务
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();//回滚
        }
        System.out.println(session==session2);
    }
}
