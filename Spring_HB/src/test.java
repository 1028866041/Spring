import com.myself.dao.UserDAO;
import com.myself.model.User;
import com.myself.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class test {

    @Test
    public void test() throws Exception {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        BeanFactory factory = ctx;

        User user = new User();
        UserService usersc = new UserService();

        /*获取bean*/
        UserDAO userDAO = (UserDAO) factory.getBean("user");

        /*meichao:由于dataSource连接在userBean init时创建
         *故需先载入userBean/否则出SQL nullpointer异常*/
        usersc.setUserDAO(userDAO);
        user.setId(1);
        user.setName("name");
        user.setPassword("password");

        usersc.add(user);
        usersc.delete(user);

        /*删除bean*/
        ctx.destroy();
    }
}
