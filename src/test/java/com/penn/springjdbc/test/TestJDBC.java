package com.penn.springjdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author penn
 * @since 2019/12/13
 */
public class TestJDBC {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            Statement stm=connection.createStatement();
            stm.execute("insert into t_user values (5, 'joy.john', 28)");
//
////            ResultSet rs=stm.executeQuery("select * from t_user");
////
////            while(rs.next()) {
////                System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));
////            }
//            stm.execute("insert into t_user values (5, 'joy.john', 28)");

//            stm.execute("delete from t_user where user_name = " + "'' or true or ''");

//            PreparedStatement statement = connection.prepareStatement("delete from t_user where user_name = ?");
//            statement.setString(1, "'' or true or ''");
//            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
