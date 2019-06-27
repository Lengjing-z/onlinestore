package com.cn.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.Jdbcutil_new;
import com.cn.vo.User;

public class UserDao {
	
		Jdbcutil_new  jp=null;
		
		public UserDao() {
			jp=new Jdbcutil_new("onlinestore");
		}
		
		public List<User> selectUser(String user,String pass) {
			List<User> list = new ArrayList<User>();
			String sql="select * from userinfo where username=? and password=?";
			Object  param[]= {user,pass};
			ResultSet rSet=jp.QueryData(sql, param);
			try {
			while(rSet.next()) {
				  User user1 = new User();
				  user1.setUser_id(rSet.getInt("user_id"));
				  user1.setUsername(rSet.getString("username"));
				  user1.setPassword(rSet.getString("password"));
				  user1.setSex(rSet.getString("sex"));
				  user1.setType(rSet.getString("type"));
				  user1.setPhone(rSet.getString("phone"));
				  list.add(user1);
			  }
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  list;
		}
		public int addUser(String name,String pass,String email) {
			String sql = "insert into userinfo(userName,password,email,type) values(?,?,?,?)";
			Object params[] = {name,pass,email,"1"};
			return jp.updateData(sql, params);
		}

}
