import com.myself.dao.UserDAO;
import com.myself.model.User;
import com.myself.service.UserService;
import com.myself.spring.BeanFactorry;
import com.myself.spring.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
public class test {

    @Test
    public void test() throws Exception {

        BeanFactorry factory = new ClassPathXmlApplicationContext();

        User user = new User();
        UserService usersc = new UserService();

        UserDAO userDAO = factory.getBean("user");

        user.setName("name");
        user.setPassword("password");

        usersc.add(user);
        usersc.setUserDAO(userDAO);
        usersc.delete(user);

    }

}
