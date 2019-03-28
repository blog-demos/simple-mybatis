package git.simple.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:24 2019/03/28
 */
public class SessionFactoryUtil {

    private static SqlSessionFactory sessionFactory;

    private SessionFactoryUtil() {}

    public static synchronized SqlSession getSession() {
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            if (null == sessionFactory) {
                sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sessionFactory.openSession();
    }
}
