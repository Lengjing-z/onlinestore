package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.Jdbcutil_new;
import com.cn.vo.order;

public class OrderDao {
	Jdbcutil_new  jp=null;
	
	public OrderDao() {
		jp=new Jdbcutil_new("onlinestore");
	}
	
	public List<order> allOrder(){
		List<order> list = new ArrayList<order>();
		String sql = "select * from orders";
		Object params[] = {};
		ResultSet rSet = jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				order order = new order();
				order.setPerson(rSet.getString("contactman"));
				order.setOrderid(rSet.getInt("order_id"));
				order.setGoodsid(rSet.getInt("goods_id"));
				order.setUserid(rSet.getInt("user_id"));
				order.setOrderdate(rSet.getString("orderDate"));
				order.setAddress(rSet.getString("address"));
				order.setEmailcode(rSet.getString("postcode"));
				order.setGoodsprice(rSet.getFloat("goods_price"));
				order.setQty(rSet.getInt("qty"));
				order.setOrdersum(rSet.getFloat("orderSum"));
				order.setStatus(Integer.parseInt(rSet.getString("status")));
				order.setNote(rSet.getString("note"));
				order.setMum(rSet.getInt("mum"));
				list.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<order> getOrderByStatus(int status){
		List<order> list = new ArrayList<order>();
		String sql = "select * from orders where status =?";
		Object params[] = {status};
		ResultSet rSet = jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				order order = new order();
				order.setPerson(rSet.getString("contactman"));
				order.setOrderid(rSet.getInt("order_id"));
				order.setGoodsid(rSet.getInt("goods_id"));
				order.setUserid(rSet.getInt("user_id"));
				order.setOrderdate(rSet.getString("orderDate"));
				order.setAddress(rSet.getString("address"));
				order.setEmailcode(rSet.getString("postcode"));
				order.setGoodsprice(rSet.getFloat("goods_price"));
				order.setQty(rSet.getInt("qty"));
				order.setOrdersum(rSet.getFloat("orderSum"));
				order.setStatus(Integer.parseInt(rSet.getString("status")));
				order.setNote(rSet.getString("note"));
				order.setMum(rSet.getInt("mum"));
				list.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public int updateOrder(int status,int id) {
		String sql = "update orders set status = ? where order_id = ?";
		Object params[] = {status,id};
		return jp.updateData(sql, params);
	}

}
