package cn.itcast.study.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TokenUtils {
    /**
     * 签名算法使用的密钥，可以随机设置，但每个系统必须相同
     * 因为还需要密钥解码。
     */
    private static final String TOKEN_SECRET = "amberpaiosd@%#yq3e1";
    /**
     * 签发人
     */
    private static final String ISSUER = "test_amber";
    /**
     * 加密算法（需要输入密钥）
     */
    private static Algorithm JWTAlgorithm = null;
    /**
     * 验证器
     */
    private static JWTVerifier verifier = null;


    /**
     * 生成Token
     *
     * @return
     */
    public static String createToken() {
        String token = null;
        try {
            //过期时间10min
            Date expiresAt = new Date(System.currentTimeMillis() + 10L * 60L * 1000L);
            //签发日期
            Date issueAt = new Date(System.currentTimeMillis());
            token = JWT.create()
                    .withIssuer(ISSUER) //签发者
                    .withExpiresAt(expiresAt)   //过期时间
                    .withNotBefore(issueAt)  //签发日期
                    .withIssuedAt(issueAt)
                    .sign(getJWTAlgorithm());
        } catch (JWTCreationException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 解码Token
     *
     * @param token
     * @return
     */
    public static DecodedJWT deToken(String token) {
        return getVerifier().verify(token);
    }

    /**
     * 每次前端请求后，刷新token
     *
     * @param oldToken 请求时携带的token
     * @return new token
     */
    public static String refreshToken(String oldToken) {
        DecodedJWT decodedJWT = deToken(oldToken);
        if (decodedJWT == null) {
            return null;
        }
        //如果还有2min过期
        if (decodedJWT.getExpiresAt().getTime() - System.currentTimeMillis() < 2L * 60L * 1000L) {
            return createToken();
        }
        return oldToken;
    }

    /**
     * 根据密钥生成签名算法
     *
     * @return
     */
    public static Algorithm getJWTAlgorithm() {
        if (JWTAlgorithm == null) {
            JWTAlgorithm = Algorithm.HMAC256(TOKEN_SECRET);
        }
        return JWTAlgorithm;
    }

    /**
     * 根据签名算法与签发人，生成验证器
     *
     * @return
     */
    public static JWTVerifier getVerifier() {
        if (verifier == null) {
            verifier = JWT.require(getJWTAlgorithm())
                    .withIssuer(ISSUER)
                    .build();
        }
        return verifier;
    }
}
