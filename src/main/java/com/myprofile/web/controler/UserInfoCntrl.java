/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.controler;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.myprofile.model.User;
import com.myprofile.model.UserBasicInfo;
import com.myprofile.repository.UserBascInfoResource;
import com.myprofile.web.base.BaseCntrl;
import com.myprofile.web.helper.UserInfoWebHelper;

/**
 * @author venkatasaikiran
 * @date Oct 4, 2018 7:13:16 PM
 *
 */
@ManagedBean(name = "UserInfoCntrl")
@RequestScoped
public class UserInfoCntrl extends BaseCntrl{

    @Autowired
    UserBascInfoResource userBasicInfoResource;
    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public String redirectToUserInfoAction() {
        String screen = "accountBasicInfo";
        /** get values from session(userId) */
        User user = getUser();
        /** pass values to serviceLayer and fetch data */
        UserBasicInfo userBasicInfo = UserInfoWebHelper.getInstance().initiateUserBasicInfo(user);
        if(userBasicInfo != null) {
            addObjectToSession(userBasicInfo, "UserBasicInfo");
        } else {
            screen = "";
        }
        
        return screen;
    }
    
    public boolean isUserImageAvailable() {
        User user = getUser();
        return UserInfoWebHelper.getInstance().isUserImageAvailable(user.getUserId());
    }
    public String initiateUpdateAccount() {
        
        return "updateAccountBasicInfo";
    }
    public String updateAccount() {
        UserBasicInfo userBasicInfo = getUserBasicInfo();
        User user = getUser();
        return UserInfoWebHelper.getInstance().updateUserBasicInfo(user, userBasicInfo);
    }
    
    public Map<String, String> getUsStatesList(){
        return UserInfoWebHelper.getInstance().getUsStatesList();
    }
    
    public Map<String, String> getCountryList(){
        return UserInfoWebHelper.getInstance().getCountryList();
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
    
}