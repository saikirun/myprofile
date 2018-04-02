/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.myprofile.model.User;
import com.myprofile.repository.UserResource;
import com.myprofile.web.base.BaseCntrl;

/**
 * @author Shanmu
 * @date Mar 18, 2018 11:00:18 PM
 */
@ManagedBean(name = "LoginCntrl")
@RequestScoped 
public class LoginCntrl extends BaseCntrl {
    @Autowired
    UserResource userResource;

    public void loginAction() {
        String redirectPage = "";
        /** get values from session(userId, pswd) */
        /** pass values to serviceLayer and fetch data */
        /** if null, send message and return */
        /**
         * else check for basic info by passing userId to UserBasicInfo Entity
         */
        /** if(null) set redirectPage to "basicInfoSetup" */
        /** else set redirectPage to "home" */
        forwardFromEvent(redirectPage);
    }

    public User findUser(String userId) {
        return userResource.findByUserId(userId);
    }
}
