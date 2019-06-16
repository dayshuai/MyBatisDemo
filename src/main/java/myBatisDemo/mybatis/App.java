package myBatisDemo.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myBatisDemo.mybatis.mapper.UserDAO;
import myBatisDemo.mybatis.pojo.User;

/**
 * Mybatis demo
 * 
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		
		String resource = "config/mybatis/SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sessionFactory.openSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		List<User> userlist  = userDAO.getUsers();
		System.out.println(userlist);
	}
}
