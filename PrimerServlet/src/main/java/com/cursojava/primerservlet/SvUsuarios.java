/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cursojava.primerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Usuario;

/**
 *
 * @author Gersson
 */
@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvUsuarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Usuario> listaUsuarios = new ArrayList<>();
        
        listaUsuarios.add(new Usuario("123","Felipe","Alvarez","999999999"));
        listaUsuarios.add(new Usuario("456","Flor","Sandoval","444444444"));
        listaUsuarios.add(new Usuario("789","Clinton","Arica","444555666"));
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaUsuarios",listaUsuarios);
      
        response.sendRedirect("mostrarUsuarios.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        System.out.println("DNI es: "+ dni);
        System.out.println("Nombre es: "+ nombre);
        System.out.println("Apellido es: "+ apellido);
        System.out.println("Telefono es: "+ telefono);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
