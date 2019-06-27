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

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/admin/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goods = request.getParameter("goods");
		
		if(goods==null || goods.equals("")) {
			request.getRequestDispatcher("QueryGoodsServlet").forward(request, response);
		}else {
			GoodsService service = new GoodsService();
			List<Goods> list = service.selectGoods("%"+goods+"%");
			request.getSession().setAttribute("Goodslist",list);
			response.sendRedirect("goodsManager.jsp");
		}
	}

}
