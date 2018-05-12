package com.myself.spring;

import com.myself.dao.UserDAO;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
/*工厂模式复写spring加载xml的class/*/
public class ClassPathXmlApplicationContext implements BeanFactorry{

    Map<String, Object> beans = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext()   throws Exception{

        /*DOM树方式解析xml/再从classLoader获取resource*/
        SAXBuilder sber = new SAXBuilder();
        Document doc=  sber.build(/*this.getClass().getClassLoader().getResourceAsStream("user")*/"beans.xml");
        Element root = doc.getRootElement();

        List list = root.getChildren("bean");

        for(int i =0; i < list.size(); i++){
            Element element = (Element)list.get(i);

            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");

            //User class:
            Object obj = Class.forName(clazz).newInstance();
            beans.put(id, obj);
            System.out.println("id:"+id+" "+"class:"+clazz+"  "+"obj:"+beans.get(id).toString());

            /*反射机制:动态获取实际加载的serviceBean/此处调的好累...*/
            for(Element propertyElement: (List<Element>)element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name");
                //userService userDAO:
                String bean = propertyElement.getAttributeValue("bean");
                Object objbean = beans.get(bean);

                String methodName = "set"+ name.substring(0,1).toUpperCase()+ name.substring(1);
                System.out.println("ClassPathXmlApplicationContext:"+ methodName+" "+objbean.toString()+" "
                                    +objbean.getClass().getInterfaces()[0]);
                //方法setUserDAO+参数userSeervice接口实现
                Method method = obj.getClass().getMethod(methodName, objbean.getClass().getInterfaces()[0]);
                method.invoke(obj, objbean);
            }
        }
    }

    @Override
    public UserDAO getBean(String name) {
            /*依key从hashMap找obj*/
            return (UserDAO) beans.get(name);
    }
}
