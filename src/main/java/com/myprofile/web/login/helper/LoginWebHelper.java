/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.login.helper;

import com.myprofile.model.User;
import com.myprofile.service.UserService;
import com.myprofile.web.base.BaseWebHelper;

/**
 * @author venkatasaikiran
 * @date Apr 3, 2018 10:22:23 PM
 *
 */
public class LoginWebHelper extends BaseWebHelper{


    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    private static LoginWebHelper instance = new LoginWebHelper();
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public String loginAction(User user){
        User userList = null;
        
        UserService userService = getUserService();
        try {
            userList = userService.findUser(user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /** if null, send message and return */
        if(userList == null){
            addFacesMsg("User Not Found, please Signup or check your Credentials.");
            return null;
        } 
            if(!getBCryptPasswordEncoder().matches(user.getPassword(), userList.getPassword())){
                addFacesMsg("Invalid Credentials.");
                return null;
            }
        /**
         * else check for basic info by passing userId to UserBasicInfo Entity
         */
        /** else set redirectPage to "home" */
        return "home";
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    public static LoginWebHelper getInstance(){
        return instance;
    }
    //----------------------------------------------------------- Inner Classes
}