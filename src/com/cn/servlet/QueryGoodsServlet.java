package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.GoodsService;
import com.cn.vo.Goods;
import com.cn.vo.GoodsType;

/**
 * Servlet implementation class QueryGoodsServlet
 */
@WebServlet("/admin/QueryGoodsServlet")
public class QueryGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService service = new GoodsService();
		List<Goods> list = service.allGoods();
		request.getSession().setAttribute("Goodslist",list);
		GoodsService goodsService = new  GoodsService();
		List<GoodsType> tlist = goodsService.allClassify();
		request.getSession().setAttribute("classifylist", tlist);
		response.sendRedirect("goodsManager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
