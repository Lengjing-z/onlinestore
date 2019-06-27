package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.GoodsService;
import com.cn.service.OrderService;
import com.cn.vo.Goods;
import com.cn.vo.order;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/admin/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderService();
		List<order> list =  service.allOrder();
		if(!list.isEmpty())
		{
			request.getSession().setAttribute("orderlist", list);
		}
		GoodsService gservice = new GoodsService();
		List<Goods> glist = gservice.allGoods();
		request.getSession().setAttribute("Goodslist",glist);
		response.sendRedirect("list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
