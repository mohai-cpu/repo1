package cn.itcast.study.controller;

import cn.itcast.study.constant.InformationEnum;
import cn.itcast.study.service.GroovyRule;
import cn.itcast.study.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @Title: HelloController
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@RestController
@RequestMapping("/hello")
//@ImportResource(locations={"classpath:spring-groovy.xml"})
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    private static AtomicInteger index = new AtomicInteger(0);
    @Autowired
    private UserService userService;
    @Resource(name = "springGroovyRule")
    private GroovyRule springGroovyRule;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request,HttpServletResponse response){
        logger.info("测试日志输出");
        int andIncrement = index.getAndIncrement();
        System.out.println(andIncrement);
        Cookie cookie = new Cookie("lisi", "ydsadsa");
        cookie.setPath("/");
        //cookie.setSecure(true);//如果设置了Secure，则只有当使用https协议连接时cookie才可以被页面访问
        //cookie.setHttpOnly(true);//如果设置了"HttpOnly"属性，那么通过程序(JS脚本、Applet等)将无法访问该Cookie
        cookie.setDomain(".zhangsan.com");
       // cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "springboot cookie test";
    }
    @GetMapping("/testGroovy")
    public String testGroovy(){
        springGroovyRule.printInfo();
        return "success";
    }
    @RequestMapping(value = "/cookie01",method = RequestMethod.GET)
    public String cookie01(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        StringBuilder sb = new StringBuilder();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                sb.append(cookie.getName()).append(",");
            }
        }
       return "cookie01:"+sb.toString();
       /* String newLoginToken = getUUID();
        Cookie backcookie = new Cookie(cookiename, newLoginToken);
        backcookie.setHttpOnly(true);
        backcookie.setMaxAge(60 * 60 * 24);
        response.addCookie(backcookie);*/
        /* String uri = "";
       response.encodeRedirectURL(uri);
       response.encodeURL(uri);*/
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest request){
        /*Long size = redisTemplate.opsForSet().size("99999999999999999999999999999");
        Set<String> members = redisTemplate.opsForSet().members("97894");
        if(members==null){
            System.out.println("null");
            return "null";
        }
        if(members.isEmpty()){
            System.out.println("000000");
        }
        if(size<3){
            System.out.println("2222222222");
        }else {
            System.out.println("3333333333333333");
        }
        System.out.println(size);*/
        String s = redisTemplate.opsForValue().get("3333333");
        if(StringUtils.isBlank(s)){
            System.out.println("*************");
        }
        Long size = redisTemplate.opsForList().size("582585");
        System.out.println(size);
        if(size<=0){
            System.out.println("666666666666666666");
        }
        return "test is success";
    }

  /*  @RequestMapping("/testAsync")
  // @ResponseBody   //@Controller注解时一定要加否则访问404
    public String testAsync(){
        for(int i=1;i<=20;){
            User user = userService.setMyUser();
            logger.info("testAsync;user:{}",JSONObject.toJSONString(user));
            logger.info("**********************");
            i+=5;
        }
        return "testAsync success";
    }*/
    /*public static void main(String[] args) {
        Random randomid = new Random();
        List<String> strs = new ArrayList<>();
        strs.add("1111");
        strs.add("1112");
        strs.add("1113");
        System.out.println(strs.size());
        strs.forEach(s ->{
            System.out.println(s);
        });
        System.out.println("********************");
        strs.remove(0);
        System.out.println(strs.size());
        strs.forEach(s ->{
            System.out.println(s);
        });



    }*/
    /*public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());
        //签名加密
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("agentid","123456");
        String secretKey = "dsafsafsdfffafsa";
        stringMap.put("secretKey",secretKey);
        Map<String, String> signMap = SignUtil.sign(stringMap);
        String mysign = signMap.get("sign");
        System.out.println(mysign);
    }*/
 /* public static void main(String[] args) {
      DecimalFormat df = new DecimalFormat("0.00");
      long red = 1000000000l;
      double reddd = (double)red/100;
      System.out.println(df.format( reddd));
  }*/
  /*public static void main(String[] args) {
      *//*String phone = "13194238516";
      String substring = phone.substring(7);
      System.out.println(substring);*//*
      Set<UserDto> set = new HashSet<>();
      for (int i = 0;i<5;i++){
          UserDto userDto = new UserDto();
         // userDto.setName("张三");
          set.add(userDto);
      }
      System.out.println(set.size()+":::"+JSONObject.toJSONString(set));
  }*/
  /*public static void main(String[] args) {
      int num1 = 7999999;
      int num2 = 10000;
// 创建一个数值格式化对象
      NumberFormat numberFormat = NumberFormat.getInstance();
// 设置精确到小数点后2位
      numberFormat.setMaximumFractionDigits(1);
      String result = numberFormat.format((float) num1 / (float) num2 * 100);
      System.out.println("num1和num2的百分比为:" + result);
  }
*/
    public static void main(String[] args) {
        /*LocalDate today = LocalDate.now();
        LocalDate ad = LocalDate.parse("2021-12-03");
        long between = ChronoUnit.DAYS.between(today, ad);
        System.out.println(between);*/
        System.out.println(new Random().nextDouble());
    }
}
