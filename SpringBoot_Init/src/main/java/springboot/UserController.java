package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
@RestController
public class UserController {

    @Autowired
    private UserProperties userProperties;

    private UserData userData;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userStart(

        @RequestParam(value = "boot",required = false,defaultValue = "booting") String name){
        name += " "+userProperties.getId()+" "+userProperties.getName()+" "+userProperties.getAge()+" "+
                    userData.getId()+" "+userData.getName()+" "+userData.getAge();
        System.out.println(name);
        return name;
    }

}
