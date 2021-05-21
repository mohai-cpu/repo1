package cn.itcast.study.controller;

import cn.itcast.study.utils.SignUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/tokentest")
public class TokenTestController {
    private Logger logger = LoggerFactory.getLogger(TokenTestController.class);
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    //登录时用
    @RequestMapping(value = "/loginTest",method = RequestMethod.GET)
    public String loginTest(String userid){
        String token = UUID.randomUUID().toString();
        //存cookie
        //Cookie backcookie = new Cookie("tokentest", token);
        //存入redis
        redisTemplate.opsForValue().set(userid,token);
        return token;
    }
    @RequestMapping(value = "/signTest",method = RequestMethod.GET)
    public String signTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        //get请求
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        if(parameterMap==null){
            return "请求参数为空";
        }
        //将map的数组的值String[]转换成string
        Map<String, String> stringMap = SignUtil.toVerifyMap(parameterMap, false);
        // 供应商的id，验证用户的真实性
        String agentid = stringMap.get("agentid");
        // 请求发起的时间
        //String timestamp = stringMap.get("timestamp");
        // 随机数
       // String nonce = stringMap.get("nonce");
        // 签名算法生成的签名
        String sign = stringMap.get("sign");
        if(StringUtils.isAnyBlank(agentid,sign)){
            return "请求参数为空";
        }
        //添加密钥（不通过参数传递的）
        String secretKey = "dsafsafsdfffafsa";
        stringMap.put("secretKey",secretKey);
        //签名处理  获取生成后的签名map
        Map<String, String> signMap = SignUtil.sign(stringMap);
        String mysign = signMap.get("sign");
        // 验证签名
        if (!mysign.equals(sign)) {
            return "令牌校验失败";
        }else{
            return "令牌校验成功";
        }
    }
}
