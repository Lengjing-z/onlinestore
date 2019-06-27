package com.cn.service;

import java.util.List;

import com.cn.dao.OrderDao;
import com.cn.vo.order;

public class OrderService {
	OrderDao dao = new OrderDao();
	public List<order> allOrder(){
		return dao.allOrder();
	}
	public List<order> getOrderByStatus(int status){
		return dao.getOrderByStatus(status);
	}
	public int updateOrder(int status,int id) {
		return dao.updateOrder(status, id);
	}

}
