package glebdyakovcompany.app.shop.connections;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SimpleElephantSQLExample
{
  public static void main(String []args)
  {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
    DataSource ds = (DataSource)applicationContext.getBean("dataSource");
    JdbcTemplate jt = new JdbcTemplate(ds);

    jt.execute("create table elephant (id int, name varchar)");
    jt.execute("insert into elephant (id, name) values (1, 'elephant_1')");
    jt.execute("insert into elephant (id, name) values (2, 'elephant_2')");

    Object[] parameters = new Object[] {new Integer(2)};
    Object o = jt.queryForObject("select name from elephant where id = ?",
      parameters, String.class);
    System.out.println((String)o);
  }
}