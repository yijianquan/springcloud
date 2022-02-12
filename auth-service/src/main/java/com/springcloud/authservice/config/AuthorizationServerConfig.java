package com.springcloud.authservice.config;

import com.springcloud.authservice.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    // 加密的方式
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 认证管理器
    @Autowired
    private AuthenticationManager authenticationManager;

    // 用户信息管理服务, 比如权限, user信息, 最终的principle信息由他控制
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private Environment env;

    /**
     * 还需要设置密码进行认证的, 通过这个方法配置.
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailService);
    }

    // 允许进入服务器认证的通过这种方式. 在这里配置.
    // authorizedGrantTypes赋予了认证的权限 :
    // refresh_token: 赋予可以刷新token的权限, 用户的access_token一般比较短, 有了refreshtoken后在一定时间内可以重新获取新的token,
    // client_credentials : 加上这个后, 发送请求不必带着 clientId和clientScret,带着token访问就可以了.
    // password: 用户通过用户名和密码换取子的凭证,
    // implicit: 较弱的认证方式, 用于跳转请求
    // authorization_code: 最普通的方式, 需要 clientId + clientSecret + redirectUrl 才能获取令牌
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("browser")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui")
                .and()
                .withClient("account-service")
                .secret(/*passwordEncoder.encode("123456")*/env.getProperty("ACCOUNT_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("service");//配置grant_type，表示授权类型


//                    .withClient("admin")//配置client_id
//                .secret(passwordEncoder.encode("123456"))//配置client_secret
//                .accessTokenValiditySeconds(3600)//配置访问token的有效期
//                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
////                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
//                .scopes("all")//配置申请的权限范围
//                .authorizedGrantTypes("authorization_code", "password")
//                .and()
    }
}
