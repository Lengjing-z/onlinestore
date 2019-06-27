package com.cn.service;

import java.util.List;

import com.cn.dao.GoodsDao;
import com.cn.vo.Goods;
import com.cn.vo.GoodsType;

public class GoodsService {

	GoodsDao dao = new GoodsDao();
	public List<GoodsType> allClassify(){
		return dao.allClassify();
	}
	public int addType(String name,String desc) {
		return dao.addType(name, desc);
	}
	public int delType(int id) {
		return dao.delType(id);
	}
	public GoodsType getTypeByName(String name) {
		return dao.getTypeByName(name);
	}
	public int updateType(int id,String name,String desc) {
		return dao.updateType(id, name, desc);
	}
	public List<Goods> allGoods(){
		return dao.allGoods();
	}
	public Goods getGoodsById(int id) {
		return dao.getGoodsById(id);
	}
	public int updateGoods(int id,String name,String desc,int qty,float price) {
		return dao.updateGoods(id, name, desc, qty, price);
	}
	public int AddGoods(Goods goods) {
		return dao.AddGoods(goods);
	}
	public List<Goods> selectGoods(String content){
		return dao.selectGoods(content);
	}
}
