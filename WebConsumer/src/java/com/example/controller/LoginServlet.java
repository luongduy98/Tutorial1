/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYSTEM
 */
public class LoginServlet extends HttpServlet{

    private static boolean checkLogin(java.lang.String username, java.lang.String password) {
        services.LoginWebservice_Service service = new services.LoginWebservice_Service();
        services.LoginWebservice port = service.getLoginWebservicePort();
        return port.checkLogin(username, password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // processRequest(request, response);
    //Step 1
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    //Step 2
    boolean status = checkLogin(username, password);
    if(status)
        request.getRequestDispatcher("success.jsp").forward(request, response);
        //Step 3
    else
        request.getRequestDispatcher("fail.jsp").forward(request, response);
    }
    
}
