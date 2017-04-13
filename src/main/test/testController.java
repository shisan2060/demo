/**
 * User : shisan
 * DateTime : 2017/4/10 下午2:06
 */

import com.jy.demo.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * testController
 *
 * @author shisan
 * @create 2017-04-10 下午2:06
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(name = "parent", locations = "classpath:spring-mvc.xml")})
public class testController {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Mock
    private DemoService demoService;

    @Before
    public void setUp() throws Exception {
        // 构造appcontext
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        // 初始化Mock
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getString() {
        //System.out.println("测试开始。。。");
        //System.out.println(demoService.getString("shisan"));

        //TestModel tm = new TestModel();
        //Method[] methods = tm.getClass().getDeclaredMethods();
        //List<Method> list = Arrays.asList(methods);
        //tm.getClass().getDeclaredMethod();
        //for (Method method : list) {
        //    if ("getName".equals(method.getName())){
        //        method.invoke()
        //    }
        //}
        //Field[] fields = tm.getClass().getDeclaredFields();
        //for (int i = 0; i < fields.length; i++) {
        //    if (fields[i].getAnnotation(Deprecated.class) != null) {
        //        System.out.println(fields[i].toString());
        //    }
        //}

        char[] cs = "name".toCharArray();
        cs[0] -= 32;
        System.out.println("get" + String.valueOf(cs));
    }

}
