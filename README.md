#### shiro.shiro

##### 1 `shiro_1` - 使用 `shiro.shiro` 跑起一个 HelloWorld

##### 2 `shiro_2` - 认证 使用 jdbcRealm (数据库表名必须为`users`,字段名必须为`username`和`password`)才可以自动认证用户

##### 3 `shiro_3` - 授权 (role and permissions)
[main]
authc.loginUrl=/login //认证不通过(登录不成功)时跳转 `/login`
roles.unauthorrizedUrl=/unauthorrized.jsp //角色验证不通过跳转`/unauthorrized.jsp`
perms.unauthorrizedUrl=/unauthorrized.jsp //权限验证不通过跳转`unauthorrized.jsp`

[urls]
/login=anon     anon:对访问的请求不进行拦截
/index=authc    authc:对访问的请求进行拦截,如果登录才放行
/index=roles[role1,role2...]    对访问的请求进行角色验证,验证通过才放行
/index=perms["user:create","user:update"]   对访问的请求进行权限验证,验证通过才放行
/index?=authc   `?`通配符,表示一个字符,如/index1 /indexa /index- (不能匹配/index) ,将符合这种规则的请求进行`authc`拦截
/index*=authc   `*`通配符,表示零个或一个或多个字符,如/index1213asd /index /index2 ,将符合这种规则的请求进行`authc`拦截
/index/**=authc `**`表示匹配零个或一个或多个路径,如/index/create /index/create/update/...  ,将符合这种规则的请求进行`authc`拦截
/index*/**authc  可以匹配 /index12/create/update/...
