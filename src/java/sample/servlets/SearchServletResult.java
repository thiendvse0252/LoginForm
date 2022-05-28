/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDTO;

/**
 *
 * @author Thien
 */
public class SearchServletResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServletResult: " + request.getContextPath() + "</h1>");
//            HttpSession session = request.getSession();
//            out.println("<h1>Welcome: " + session.getAttribute("LOGIN_USER") + "</h1>");
//            if (list != null) {
//                if (!list.isEmpty()) {
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>No</th>");
            out.println("<th>User ID</th>");
            out.println("<th>Full Name</th>");
            out.println("<th>Role ID</th>");
            out.println("<th>Password</th>");
            out.println("</tr>");
            out.println("</thead>");

            out.println("<tbody>");
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");

            int no = 1;
            for (UserDTO user : list) {

                out.println("<tr>");
                out.println("<td>" + no++ + "</td>");
                out.println("<td>" + user.getUserID() + "</td>");
                out.println("<td>" + user.getFullName() + "</td>");
                out.println("<td>" + user.getRoleID() + "</td>");
                out.println("<td>" + user.getPassword() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
