package com.acey.service;

import java.util.Set;

import com.acey.entity.User;

public interface UserService {

	/**
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	/**
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
}
