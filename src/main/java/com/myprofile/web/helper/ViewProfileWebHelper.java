/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.helper;

import java.util.Calendar;

import javax.faces.context.FacesContext;

import com.myprofile.model.UserBasicInfo;
import com.myprofile.model.UserProfile;
import com.myprofile.model.UserProfileTracker;
import com.myprofile.service.UserService;
import com.myprofile.web.base.BaseWebHelper;

/**
 * @author venkatasaikiran
 * @date Oct 25, 2018 2:00:15 PM
 *
 */
public class ViewProfileWebHelper extends BaseWebHelper {

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    private static ViewProfileWebHelper instance = new ViewProfileWebHelper();
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public String initiateViewerHome(String userId, String trackingCode, String ip) {
        UserProfile userProfile = new UserProfile();
        UserProfileTracker userProfileTracker = new UserProfileTracker();
        String fileLink = "";
        UserService userService = getUserService();

        try {
            UserBasicInfo userBasicInfo = userService.findUserBasicInfo(userId);
            addObjectToSession(userBasicInfo, "userBasicInfo");
            userProfileTracker.setUserId(userId);
            userProfileTracker.setIpAddress(ip);
            userProfileTracker.setLinkAccessedDate(Calendar.getInstance().getTime());
            userService.saveUserProfileTracker(userProfileTracker);
            fileLink = FileUploadWebHelper.getInstance().profileLink(userProfile, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileLink;
    }

    public void addObjectToSession(Object obj, String sessionId) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null && fc.getExternalContext() != null && fc.getExternalContext().getSessionMap() != null) {
            fc.getExternalContext().getSessionMap().put(sessionId, obj);
        }
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    public static ViewProfileWebHelper getInstance() {
        return instance;
    }
    //----------------------------------------------------------- Inner Classes
}