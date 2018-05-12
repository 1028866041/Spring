import com.myself.dao.UserDAO;
import com.myself.model.User;
import com.myself.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

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

        /*meichao:sprin4这里ClassPathXmlApplicationContext与prototype联用并未init两次为何？
         *因为beans.xml定义default-lazy-init="true"导致usersc2未被引用时并未初始化*/
        UserService usersc2 = (UserService)ctx.getBean("userService");

        /*获取bean*/
        UserDAO userDAO = (UserDAO) factory.getBean("userDAOImpl");

        /*此处引用usersc将导致*/

        user.setName("name");
        user.setPassword("password");

        usersc.add(user);
        usersc.setUserDAO(userDAO);
        usersc.delete(user);

        /*meichao:此处引用usersc2将执行其init方法*/
        usersc2.add(user);
        usersc2.setUserDAO(userDAO);
        usersc2.delete(user);
        /*不同于Spring3/在Spring4中第2次getBean时init方法并不会被执行2次*/

        /*删除bean*/
        ctx.destroy();
    }

}
