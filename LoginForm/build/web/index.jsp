<%-- 
    Document   : index
    Created on : 26-Nov-2023, 2:32:09 am
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .tr,td{
                background-color:red;
                color: yellow;
            }
            
            
        </style>    
    </head>
    <body style="background-color:green">
        <table align="center" height="70%",width="70%" border="8px">
        <form action="ram" method="post">
            <marquee style="background-color: blue">raushan.com</marquee>
            <tr>
                <td>Enter Name:<input type="text" name="uname" placeholder="Enter the name"><td><br><!-- comment -->
            </tr>
            <tr>
                <td>Enter email:<input type="email" name="uemail" placeholder="Enter the emails"><br></td><!-- comment -->
            </tr>
            <tr>
                <td>Enter password:<input type="password" name="upass" placeholder="Enter the password"><br></td><!-- comment -->
            </tr>
            <tr>
                <td>Gender:<input type="radio" name="gender1" value="male"/>male<input type="radio" name="gender1" value="female"/>female</td>
            </tr>
            <br><!-- comment -->
            <tr>
            city:
            <td><select name="city1">
                
                <option>select the city</option><!-- comment -->
                <option>sumbha</option><!-- comment -->
                <option>pipra</option><!-- comment -->
                <option>bangrathatta</option>
                <option>singhia</option>
                <option>samastipur</option><!-- comment -->
                <option>durgapatti</option>
                <option>madhubani</option>
                
                
                </select></td><!-- comment -->  
        </tr>
            <br><br><!-- comment -->
            <input type="submit" value="register"><!-- comment -->
            
            
        </form>
        </table>
    </body>
</html>
