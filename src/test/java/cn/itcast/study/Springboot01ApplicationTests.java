//package cn.itcast.study;
//
//import cn.itcast.study.dao.RedisDao;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.TestTemplate;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.URL;
//
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertThat;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class Springboot01ApplicationTests {
//    @LocalServerPort
//    private int port;
//    private URL base;
//    @Autowired
//    private TestRestTemplate restTemplate;//远程调用接口
//    @Autowired
//    private RedisDao redisDao;
//    @Before
//    public void setUp() throws Exception {
//        this.base = new URL("http://localhost:"+port+"/hello/sayHello");
//    }
//    @Test
//    public void getHello() throws Exception{
//        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
//        assertThat(response.getBody(),equalTo("I miss you luo qing"));
//        System.out.println(response.getBody()+"**********************************");
//    }
//    @Test
//    public void testRedis(){
//        redisDao.addList();
//}
//}
