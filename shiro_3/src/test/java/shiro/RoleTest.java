package shiro;


import java.util.Arrays;

import common.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class RoleTest {

//	使用 checkRole 来检验角色时,若权限不足会返回 false
	@Test
	public void testHasRole() {
		Subject currentUser= ShiroUtil.login("classpath:shiro_role.ini", "acey", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");
		System.out.println(currentUser.hasRole("role1")?"has role1":"has not role1");
		currentUser.logout();
	}

	//	使用 checkRole 来检验角色时,若权限不足会抛出异常
	@Test
	public void testCheckRole() {
		Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "acey", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");
		currentUser.checkRole("role1");

		currentUser.logout();
	}
}
