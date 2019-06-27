package com.cn.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cn.service.GoodsService;
import com.cn.vo.Goods;


/**
 * Servlet implementation class AddGoodsServlet
 */
@MultipartConfig
@WebServlet(name = "AddGoodsServlet", urlPatterns = {"/admin/AddGoodsServlet"})

public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contextPath;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
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
		   String  goods_name=request.getParameter("goods_name");
			String  type_id=request.getParameter("type_id");
			String  goods_price=request.getParameter("goods_price");
			String  goods_desc=request.getParameter("goods_desc");
			String  supplier=request.getParameter("supplier");
			String  qty=request.getParameter("qty");
			System.out.println(goods_name);
			System.out.println(type_id);
			System.out.println(goods_price);
			System.out.println(goods_desc);
			System.out.println(supplier);
			System.out.println(qty);
//			String proClassPath = this.getClass().getResource("").getPath();
//			System.out.println(proClassPath);
			
			Part part = request.getPart("goods_pic");
		    String fileName = getFileName(part);//获取文件名
		    File tempFile =new File( fileName.trim());
		    System.out.println(tempFile.getName());
	        writeTo(fileName, part);
	        //forward到显示
	        
	        Goods goods = new Goods();
			goods.setGoods_name(goods_name);
			goods.setType_id(Integer.parseInt(type_id));
			goods.setGoods_price(Float.parseFloat(goods_price));
			goods.setGoods_desc(goods_desc);
			goods.setSupplier(supplier);
			goods.setQty(Integer.parseInt(qty));
			goods.setGoods_pic("images/"+tempFile.getName());
	        
	        int i;
			GoodsService goodsService = new GoodsService();
			i=goodsService.AddGoods(goods);
	        if(i>0) {
	        	request.getRequestDispatcher("QueryGoodsServlet").forward(request, response);
	        }else {
	        	request.getRequestDispatcher("fail.jsp").forward(request, response);
	        }
	    }
	  
	    //取得上传文件名
	    private String getFileName(Part part) {
	        String header = part.getHeader("Content-Disposition");
	        String fileName = header.substring(header.indexOf("filename=\"") + 10,
	                header.lastIndexOf("\""));
	        return fileName.replaceAll("\\\\", "/");
 }

	    private void writeTo(String fileName, Part part) throws IOException, FileNotFoundException {
//	        InputStream in = part.getInputStream();
//	        OutputStream out = new FileOutputStream(contextPath + fileName);
	    	File tempFile =new File( fileName.trim());
	    	
	    	FileInputStream in = new FileInputStream(tempFile);
	    	FileOutputStream out = new FileOutputStream(new File("D:/eclipse/eclipse-workspace/onlinestore/WebContent/images/"+tempFile.getName()));
	        byte[] buffer = new byte[10240];
	        int length = -1;
	        while ((length = in.read(buffer)) != -1) {
	            out.write(buffer, 0, length);
	        }
	        in.close();
	        out.close();
	}

}
