import com.myself.dao.LogDAO;
import com.myself.dao.UserDAO;
import com.myself.model.Log;
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
        Log log = new Log();
        UserService usersc = new UserService();

        /*获取bean*/
        UserDAO userDAO = (UserDAO) factory.getBean("user");
        LogDAO logDAO = (LogDAO) factory.getBean("log");

        usersc.setUserDAO(userDAO);
        usersc.setLogDAO(logDAO);

        user.setName("name");
        user.setPassword("password");
        log.setMessage("message");

        usersc.add(user);
        usersc.add(log);
        usersc.delete(user);
        usersc.delete(log);

        /*删除bean*/
        ctx.destroy();
    }
}
