package com.cn.service;

import java.util.List;

import com.cn.dao.UserDao;
import com.cn.vo.User;

public class userservice {
	UserDao dao = new UserDao();
	public List<User> login(String user,String pass) {
		return dao.selectUser(user, pass);
	}
	public int addUser(String name,String pass,String email) {
		return dao.addUser(name, pass, email);
	}

}
