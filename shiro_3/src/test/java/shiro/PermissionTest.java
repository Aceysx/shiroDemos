package shiro;


import common.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class PermissionTest {

//	使用 checkPermission 来检验权限时,若权限不足会返回 false
	@Test
	public void testIsPermitted() {
		Subject currentUser= ShiroUtil.login("classpath:shiro_permission.ini", "acey", "123456");
		System.out.println(currentUser.isPermitted("user:select")?"has user:select":"hsa not user:select");

		currentUser.logout();
	}

//	使用 checkPermission 来检验权限时,若权限不足会抛出异常
	@Test
	public void testCheckPermitted() {
		Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "acey", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "jack", "123");
		currentUser.checkPermission("user:select");
		currentUser.logout();
	}
}
