/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        PrintWriter outr=resp.getWriter();
        String myname=req.getParameter("uname");
        String mypass=req.getParameter("upass");
        
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","1234");
        //PreparedStatement ps=con.prepareStatement("select * from register");
        PreparedStatement ps=con.prepareStatement("select * from register where name=?,password=?");
        ps.setString(1, myname);
        ps.setString(2,mypass);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            HttpSession session=req.getSession();
            session.setAttribute("session_name",rs.getString("name"));
            
            outr.println("its match");
            RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
           rd.include(req, resp);
            
            
          
            
        }
        else
        {
            outr.println("its failsed");
            resp.setContentType("text/html");
            outr.println("<h1 style='color:red'>email and password cannot be match</h1>");
           RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
           rd.include(req, resp);
           
        }
        
        
        
        }catch(Exception ex)
        {
              resp.setContentType("text/html");
            outr.println("<h1 style='color:red'>email and password cannot be match</h1>");
           RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
           rd.include(req, resp);
           
            
        }
        
        
        
        
    }
    
}

