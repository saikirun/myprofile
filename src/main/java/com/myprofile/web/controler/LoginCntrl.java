/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.controler;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.myprofile.model.User;
import com.myprofile.web.base.BaseCntrl;
import com.myprofile.web.helper.LoginWebHelper;

/**
 * @author Shanmu
 * @date Mar 18, 2018 11:00:18 PM
 */
@ManagedBean(name = "LoginCntrl")
@RequestScoped 
public class LoginCntrl extends BaseCntrl {

    public String loginAction() throws ServletException, IOException {
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("/j_spring_security_check");
//        dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
//        FacesContext.getCurrentInstance().responseComplete();
        /** get values from session(userId, pswd) */
        User user = getUser();
        /** pass values to serviceLayer and fetch data */
        return LoginWebHelper.getInstance().loginAction(user);
    }
    
    public String logoutAction() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }
    
    public String redirectToForgotPswdPage() {
        User user = getUser();
        return "forgotPswd";
    }
    
    public String redirectToHomePage() {
        return"home";
    }
}
