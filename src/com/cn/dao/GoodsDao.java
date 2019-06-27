package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.Jdbcutil_new;
import com.cn.vo.Goods;
import com.cn.vo.GoodsType;

public class GoodsDao {
	Jdbcutil_new  jp=null;
	
	public GoodsDao() {
		jp=new Jdbcutil_new("onlinestore");
	}
	public List<GoodsType> allClassify(){
		List<GoodsType> list = new ArrayList<GoodsType>();
		String sql = "select * from type";
		Object params[] = {};
		ResultSet rSet=jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				GoodsType goodsType = new GoodsType();
				goodsType.setId(rSet.getInt("type_id"));
				goodsType.setName(rSet.getString("type_name"));
				goodsType.setDesc(rSet.getString("type_desc"));
				list.add(goodsType);
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return  list;
	}
	public int addType(String name,String desc) {
		String sql = "insert into type(type_name,type_desc) values(?,?)";
		Object params[] = {name,desc};
		return jp.updateData(sql, params);
	}
	public int delType(int id) {
		String sql = "delete from type where type_id = ?";
		Object params[] = {id};
		return jp.updateData(sql, params);
	}
	public GoodsType getTypeByName(String name) {
		String sql = "select * from type where type_name =?";
		Object params[] = {name};
		GoodsType type = new  GoodsType();
		ResultSet rSet=jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				type.setId(rSet.getInt("type_id"));
				type.setName(rSet.getString("type_name"));
				type.setDesc(rSet.getString("type_desc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	public int updateType(int id,String name,String desc) {
		String sql = "update type set type_name =?,type_desc=? where type_id =?";
		Object params[] = {name,desc,id};
		return jp.updateData(sql, params);
	}
	public List<Goods> allGoods(){
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods";
		Object params[] = {};
		ResultSet rSet=jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				Goods goods = new Goods();
				goods.setGoods_id(rSet.getInt("goods_id"));
				goods.setGoods_name(rSet.getString("goods_name"));
				goods.setType_id(rSet.getInt("type_id"));
				goods.setGoods_price(rSet.getFloat("goods_price"));
				goods.setGoods_desc(rSet.getString("goods_desc"));
				goods.setSupplier(rSet.getString("supplier"));
				goods.setQty(rSet.getInt("qty"));
				goods.setGoods_pic(rSet.getString("goods_pic"));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Goods getGoodsById(int id) {
		String sql="select * from goods where goods_id = ?";
		Object params[]= {id};
		Goods goods = new Goods();
		ResultSet rSet=jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				goods.setGoods_id(rSet.getInt("goods_id"));
				goods.setGoods_name(rSet.getString("goods_name"));
				goods.setType_id(rSet.getInt("type_id"));
				goods.setGoods_price(rSet.getFloat("goods_price"));
				goods.setGoods_desc(rSet.getString("goods_desc"));
				goods.setSupplier(rSet.getString("supplier"));
				goods.setQty(rSet.getInt("qty"));
				goods.setGoods_pic(rSet.getString("goods_pic"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}
	public int updateGoods(int id,String name,String desc,int qty,float price) {
		String sql = "update goods set goods_name = ? , goods_desc = ? ,goods_price = ?,qty = ? where goods_id = ?";
		Object params[] = {name,desc,price,qty,id};
		return jp.updateData(sql, params);
	}
	public int AddGoods(Goods goods) {
		String sql ="insert into goods(goods_name,type_id,supplier,qty,goods_price,goods_pic,goods_desc) values(?,?,?,?,?,?,?)";
		Object params[] = {goods.getGoods_name(),goods.getType_id(),goods.getSupplier(),goods.getQty(),goods.getGoods_price(),goods.getGoods_pic(),goods.getGoods_desc()};
		return jp.updateData(sql, params);
	}
	public List<Goods> selectGoods(String content){
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods where goods_name like ? or goods_desc like ? or supplier like ?";
		Object params[] = {content,content,content};
		ResultSet rSet=jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				Goods goods = new Goods();
				goods.setGoods_id(rSet.getInt("goods_id"));
				goods.setGoods_name(rSet.getString("goods_name"));
				goods.setType_id(rSet.getInt("type_id"));
				goods.setGoods_price(rSet.getFloat("goods_price"));
				goods.setGoods_desc(rSet.getString("goods_desc"));
				goods.setSupplier(rSet.getString("supplier"));
				goods.setQty(rSet.getInt("qty"));
				goods.setGoods_pic(rSet.getString("goods_pic"));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
