package com.cn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbcutil_new {
  Connection connection=null;
  PreparedStatement preparedStatement=null;
  ResultSet  rSet=null;

  public Jdbcutil_new(String database) {
	  getConnection(database);
  }
  
  public void getConnection(String database) {
	  try {
		String url = "jdbc:mysql://rm-bp1ibe8e4r252kt353o.mysql.rds.aliyuncs.com:3306/"+database;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root_leng", "Z582453n");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public int updateData(String sql,Object[]params) {//����ɾ���ĵķ���
	 int result=-1;
	  try {
		preparedStatement=connection.prepareStatement(sql);
		  if(params!=null) {
			  for(int i=0;i<params.length;i++) {
				  preparedStatement.setObject(i+1, params[i]); 
			  }
		  }
		  result=  preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return result; 
	  
  }
  
  public ResultSet QueryData(String sql,Object[]params) {//��ѯ
		 
		  try {
			preparedStatement=connection.prepareStatement(sql);
			  if(params!=null) {
				  for(int i=0;i<params.length;i++) {
					  preparedStatement.setObject(i+1, params[i]); 
				  }
			  }
			  rSet=  preparedStatement.executeQuery();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return rSet; 
		  
	  }
  public void close() {
		try {
			if (rSet != null) {
				rSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}