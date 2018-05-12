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

        BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

        User user = new User();
        UserService usersc = new UserService();

        UserDAO userDAO = (UserDAO) factory.getBean("user");

        user.setName("name");
        user.setPassword("password");

        usersc.add(user);
        usersc.setUserDAO(userDAO);
        usersc.delete(user);

    }

}
