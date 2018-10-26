/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.myprofile.web.helper.ViewProfileWebHelper;


/**
 * @author venkatasaikiran
 * @date Oct 25, 2018 2:06:48 PM
 *
 */
@WebServlet(name = "ViewProfile", urlPatterns = {"/ViewProfile"})
public class ViewProfile extends HttpServlet {

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public String getProfileLink(String link) {
        return link;
    }
    //------------------------------------------------------- Protected Methods
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("uId");
        String trackingCode = request.getParameter("tCode");
        String ip = captureIPAddress(request);
        getProfileLink(ViewProfileWebHelper.getInstance().initiateViewerHome(userId, trackingCode, ip));
        response.sendRedirect("http://localhost:8080/myprofile/profile/viewerHome.jsf?");
    }
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    private String captureIPAddress(HttpServletRequest request) {
        String ip = "None";
        ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
}