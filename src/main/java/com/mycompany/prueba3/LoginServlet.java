package com.mycompany.prueba3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet LoginServlet</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
out.println("</body>");
out.println("</html>");
}
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

String usuario = request.getParameter("usuario");
String password = request.getParameter("password");

String url = "jdbc:mysql://localhost:3307/prueba";
Connection conexion;
Statement st;
ResultSet rs;

try {
Class.forName("com.mysql.cj.jdbc.Driver");
conexion = DriverManager.getConnection(url, "root", "1234");
st = conexion.createStatement();
rs = st.executeQuery("SELECT * FROM usuarios WHERE nomusu='" + usuario + "' AND passusu='" + password + "'");

if (rs.next()) {
request.getSession().setAttribute("nomusu", usuario);
response.sendRedirect("panel.jsp");
} else {
response.sendRedirect("index.html");
}

} catch (ClassNotFoundException | SQLException ex) {
Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
}
}

@Override
public String getServletInfo() {
return "Servlet de validacion de usuario";
}
}