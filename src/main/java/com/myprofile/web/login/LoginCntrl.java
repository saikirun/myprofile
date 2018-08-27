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
import com.myprofile.web.login.helper.LoginWebHelper;

/**
 * @author Shanmu
 * @date Mar 18, 2018 11:00:18 PM
 */
@ManagedBean(name = "LoginCntrl")
@RequestScoped 
public class LoginCntrl extends BaseCntrl {
    @Autowired
    UserResource userResource;

    public String loginAction() {
        /** get values from session(userId, pswd) */
        User user = getUser();
        /** pass values to serviceLayer and fetch data */
        return LoginWebHelper.getInstance().loginAction(user);
    }
}
