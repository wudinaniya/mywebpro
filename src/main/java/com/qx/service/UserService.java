package com.qx.service;

import java.util.List;

import com.qx.pojo.User;
import com.qx.utils.UserMutate;

public interface UserService {

	public List<UserMutate> findAll() throws Exception;
	
}
