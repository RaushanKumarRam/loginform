/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ram")
public class Register extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        PrintWriter outr=response.getWriter();
        String myname=request.getParameter("uname");
        String mypass=request.getParameter("upass");
        String myemail=request.getParameter("uemail");
        String gen=request.getParameter("gender1");
        String mycity=request.getParameter("city1");
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","1234");
        PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
        ps.setString(1, myname);
        ps.setString(2, mypass);
        ps.setString(3, myemail);
        ps.setString(4, gen);
        ps.setString(5, mycity);
        
        int count=ps.executeUpdate();
        if(count>0)
        {
            outr.println("its sucess");
            
            response.setContentType("text/html");
            outr.println("<h1 style='color:green'>Register Sucessfully</h1>");
            
           
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
            
        }
        else
        {
            response.setContentType("text/html");
            outr.println("<h1 style='color:red'>Register not due to some error</h1>");
           outr.println("its fetching the data");
           
           
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
            
        }
        
            
        }catch(Exception ex)
        {
            
              ex.printStackTrace();
              response.setContentType("text/html");
              outr.println("<h1 style='color:green'></h1>");
              outr.println(ex.getMessage());
              outr.println("its fetching the data");  
           
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
            
        }
        
                
        
    }
}