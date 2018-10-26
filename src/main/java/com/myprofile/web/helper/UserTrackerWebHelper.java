/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.helper;

import java.util.ArrayList;

import com.myprofile.model.UserProfileTracker;
import com.myprofile.service.UserService;
import com.myprofile.web.base.BaseWebHelper;

/**
 * @author venkatasaikiran
 * @date Oct 25, 2018 10:03:38 AM
 *
 */
public class UserTrackerWebHelper extends BaseWebHelper{

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    private static UserTrackerWebHelper instance = new UserTrackerWebHelper();
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public ArrayList<UserProfileTracker> getTrackerInfo(String userId) {
        ArrayList<UserProfileTracker> trackerList = new ArrayList<UserProfileTracker>();
        UserService userService = getUserService();

        try {
            trackerList = userService.getTrackerInfo(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trackerList;
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    public static UserTrackerWebHelper getInstance() {
        return instance;
    }
    //----------------------------------------------------------- Inner Classes
}