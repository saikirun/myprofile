/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.base;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.myprofile.service.UserService;
import com.myprofile.web.util.WebSpringContext;

/**
 * @author Shanmu
 * @date Apr 2, 2018 12:50:32 AM
 */
public class BaseWebHelper{
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @return
     */
    public UserService getUserService() {
        return (UserService) WebSpringContext
                .getBean(UserService.SERVICE_NAME);
    }
    
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return (BCryptPasswordEncoder) WebSpringContext
                .getBean("bCryptPasswordEncoder");
    }
    
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfigurationFactoryBean(){
        return (FreeMarkerConfigurationFactoryBean)WebSpringContext
                .getBean("freemarkerConfig");
    }
    
    public void addFacesMsg(String msg){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null,  new FacesMessage(msg));
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
