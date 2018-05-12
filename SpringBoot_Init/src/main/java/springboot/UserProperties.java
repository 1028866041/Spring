package springboot;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
@RestController(value = "userProperties")
public class UserProperties {

    private int id;
    /*@Value("${name}"*/
    private String name;
    private int age;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 不指定方法则get与post均被响应
     * @param str
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userProperties(
            @RequestParam(value = "user",required = false, defaultValue = "userSpring") String str){
        return str;
    }

    public String getPassword() {
        return password;
    }

}
