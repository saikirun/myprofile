/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.helper;

import java.util.Map;

import com.myprofile.model.User;
import com.myprofile.model.UserBasicInfo;
import com.myprofile.service.UserService;
import com.myprofile.web.base.BaseWebHelper;
import com.myprofile.web.util.CountryStatesList;

/**
 * @author venkatasaikiran
 * @date Oct 25, 2018 1:39:28 PM
 *
 */
public class UserInfoWebHelper extends BaseWebHelper {
    private static UserInfoWebHelper instance = new UserInfoWebHelper();

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public UserBasicInfo initiateUserBasicInfo(User user) {
        UserBasicInfo userBasicInfo = null;
        UserService userService = this.getUserService();

        try {
            userBasicInfo = userService.findUserBasicInfo(user.getUserId());
            if (userBasicInfo == null) {
                this.addFacesMsg("UserInfo not found. Please logout and login. ");
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return userBasicInfo;
    }

    public String updateUserBasicInfo(User user, UserBasicInfo userBasicInfo) {
        String screen = "accountBasicInfo";
        UserService userService = this.getUserService();
        if (userBasicInfo == null) {
            screen = "home";
        }

        try {
            if (userBasicInfo != null) {
                if (userBasicInfo.getUserId() == null) {
                    userBasicInfo.setUserId(user.getUserId());
                }

                userService.saveUserBasicInfo(userBasicInfo);
                this.addFacesMsg("Updated User Info");
            } else {
                this.addFacesMsg("Unable to update User Info");
                screen = "";
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return screen;
    }

    public boolean isUserImageAvailable(String userId) {
        boolean isAvailable = false;
        UserService userService = this.getUserService();
        UserBasicInfo userBasicInfo = null;

        try {
            userBasicInfo = userService.findUserBasicInfo(userId);
            if (userBasicInfo != null && userBasicInfo.getProfileImage() != null
                    && userBasicInfo.getProfileImage().length > 0) {
                isAvailable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAvailable;
    }

    public Map<String, String> getUsStatesList() {
        return CountryStatesList.getUsStatesList();
    }

    public Map<String, String> getCountryList() {
        return CountryStatesList.getCountryList();
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    public static UserInfoWebHelper getInstance() {
        return instance;
    }
    //----------------------------------------------------------- Inner Classes
}