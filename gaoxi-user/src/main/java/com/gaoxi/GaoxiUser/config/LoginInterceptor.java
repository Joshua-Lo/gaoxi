package com.gaoxi.GaoxiUser.config;
import com.gaoxi.GaoxiUser.domain.User;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger log = Logger.getLogger(LoginInterceptor.class);

    /*@Autowired
    UserService userService;*/
      
    /*@Value("${IGNORE_LOGIN}")
    Boolean IGNORE_LOGIN;*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String basePath = request.getContextPath();
        String path = request.getRequestURI();
        path=path.substring(basePath.length());
        if(path.equals("/login/submitLogin")
                ||path.equals("/login")
                ||path.equals("/reg")
                ||path.equals("/reg/submitRegister")){
            return true;
        }
        //如果登录了，会把用户信息存进session  
        HttpSession session = request.getSession();
        User users = (User) session.getAttribute("user");
        if(users==null){
            String requestType = request.getHeader("X-Requested-With");
            if(requestType!=null && requestType.equals("XMLHttpRequest")){
                response.setHeader("sessionstatus","timeout");
                response.getWriter().print("LoginTimeout");
                return false;
            } else {
                log.info("尚未登录，跳转到登录界面");
                response.sendRedirect("/login");
            }
            return false;
        }else {
            log.info("用户已登录,userName:"+users.getUsername());
            return true;
        }

    }
    /**
     * 是否进行登陆过滤 
     * @param path
     * @param basePath
     * @return
     */
    /*private boolean doLoginInterceptor(String path,String basePath){
        path = path.substring(basePath.length());
        Set<String> notLoginPaths = new HashSet<>();
        //设置不进行登录拦截的路径：登录注册和验证码  
        //notLoginPaths.add("/");  
        notLoginPaths.add("/index");
        notLoginPaths.add("/signin");
        notLoginPaths.add("/login");
        notLoginPaths.add("/login/submitLogin");
        notLoginPaths.add("/reg/submitRegister");
        notLoginPaths.add("/kaptcha.jpg");
        notLoginPaths.add("/kaptcha");
        //notLoginPaths.add("/sys/logout");  
        //notLoginPaths.add("/loginTimeout");  

        if(notLoginPaths.contains(path)) return false;
        return true;
    }*/
}