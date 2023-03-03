package com.qf.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qf.dao.PicDao;
import com.qf.entity.User;

public class uploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**文件的上传*/
        //step1 创建一个工厂类的实例  该工厂对象可以为解析器提供了 缺省资源
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //step2 创建一个解析器,用于解析上传数据的工具类
        ServletFileUpload sfu=new ServletFileUpload(factory);
        //step3 使用解析器
        
        try {
        	//解析器解析数据后 会将表单中的数据转换成一个一个FileItem对象 ,一个表单域中的数据对应一个FileItem对象
            List<FileItem> items=sfu.parseRequest(request);   
//            System.out.println(items.size());
            /* 
             * 遍历 FileItem的集合(读取表单域中的数据时 要区分表单域的类型)
             * 循环判断每一个表单域是普通类型？还是上传的文件？
             * */
            for(FileItem it:items){
            	 //普通表单域
                if(it.isFormField()){
                    String name=it.getString();
                    System.out.println(name);
                }else{
                    //文件表单域
                    ServletContext ctx=getServletContext();
                    String pa=ctx.getRealPath("upload");
                    //获取文件名
                    String fileName=it.getName();
                  
                    String end=fileName.substring(fileName.lastIndexOf("."));
                    long now=System.currentTimeMillis();
                    fileName=now+end;
                    
                    File file=new File(pa+"\\"+fileName);
                    System.out.println(pa+"\\"+fileName);
                    it.write(file);
                    //session验证
                    HttpSession session=request.getSession();
                    User user=(User) session.getAttribute("user");
                    PicDao picDao=new PicDao();
                    picDao.add("upload/"+fileName,user.getId());
                    response.sendRedirect("detail?id="+user.getId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
