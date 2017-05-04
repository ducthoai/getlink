/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butchjgo;

import com.entity.URLData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author root
 */
@WebServlet(name = "Download", urlPatterns = {"/Download"})
public class Download extends HttpServlet {

    private String msg;
    private boolean valid;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GetLinkFsharePU");
    EntityManager em = emf.createEntityManager();
    private String identity;
    private String tmpURI;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Download</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Download at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            String link = request.getParameter("link");
            String password = request.getParameter("password");
            String capcha = request.getParameter("g-recaptcha-response");
            String userAgent = request.getHeader("User-Agent");
            if (userAgent == null || userAgent.isEmpty()) {
                userAgent = "Robot";
            }

            if (link == null || link.isEmpty()) {
                msg = "emty link request by: " + userAgent + " from " + request.getRemoteHost();
                log(msg);
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"msg\": \"You must provide a link\",\"field\":\"url\"}");
                return;
            }
            if (capcha == null || capcha.isEmpty()) {
                msg = "emty capcha submit by: " + userAgent + " from " + request.getRemoteHost();
                log(msg);
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"msg\": \"You must complete capcha\"}");
                return;
            }
            if (password == null || password.isEmpty()) {
                password = "";

            }
            valid = VerifyUtils.verify(capcha);
            if (!valid) {
                msg = "invalid capcha by: " + userAgent + " from " + request.getRemoteHost();
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"msg\": \"Please finish your capcha\"}");
                log(msg);
                return;
            }

            boolean isValidLink = VerifyUtils.verifyLink(link);
            if (!isValidLink) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"msg\": \"link not support\",\"field\":\"url\"}");
                msg = "request not support by: " + userAgent + " from " + request.getRemoteHost();
                log(msg);

                return;
            }

            String data = userAgent + request.getRemoteHost() + String.valueOf(new Date());
            String data2 = userAgent + request.getRemoteHost();
            tmpURI = DigestUtils.md5Hex(data);
            identity = DigestUtils.md5Hex(data2);

            URLData urld = new URLData(link, password, tmpURI, "", identity, 0, 0, false, false, false, new Date(), "");

            if (persist(urld)) {
                response.setStatus(HttpServletResponse.SC_OK);
                out.write("{\"msg\": \"Request successfull\",\"url\":\"http://localhost:8084/GetLinkFshare/Download?process="
                        + tmpURI
                        + "\""
                        + "}");
            } else {
                msg = "request not successfull at final step" + userAgent + " from " + request.getRemoteHost();
                log(msg);
                response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
                out.write("{\"msg\": \"Request not successfull\",\"url\":\"http://localhost:8084/GetLinkFshare/Download?process="
                        + tmpURI
                        + "\""
                        + "}");
            }
            return;
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
        processGetRequest(request, response);
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
        processPostRequest(request, response);
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

    public boolean persist(Object object) {
        boolean isSuccess = false;
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            isSuccess = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return isSuccess;
        }
    }

}
