package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by acey on 4/29/17.
 */
public class HelloWorld {

    public static void main(String[] args) {
//        加载配置文件,初始化 SecurityManager 工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        获取 SecurityManager 实例
        SecurityManager securityManager = factory.getInstance();
//        把 SecurityManager 绑定到 SecurityUtils 中
        SecurityUtils.setSecurityManager(securityManager);
//        得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();
//        创建 token 令牌,用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken("acey", "123456");
        try {
//            身份验证
            currentUser.login(token);
            System.out.println("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录失败");
        }
    }
}
