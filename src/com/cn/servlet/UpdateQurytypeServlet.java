package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cn.service.GoodsService;
import com.cn.vo.GoodsType;

/**
 * Servlet implementation class UpdateQurytypeServlet
 */
@WebServlet("/admin/UpdateQurytypeServlet")
public class UpdateQurytypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQurytypeServlet() {
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
		String name = request.getParameter("name");
		System.out.println(name);
		GoodsService service = new GoodsService();
		GoodsType type = service.getTypeByName(name);
		JSONObject json=new JSONObject();
		json.put("id",type.getId());
		json.put("name",type.getName());
		json.put("desc", type.getDesc());
		
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(json.toJSONString());
		out.flush();
		out.close();
	}

}
