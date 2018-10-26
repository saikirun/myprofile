/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.controler;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.myprofile.model.User;
import com.myprofile.model.UserProfileTracker;
import com.myprofile.web.base.BaseCntrl;
import com.myprofile.web.helper.UserTrackerWebHelper;

/**
 * @author venkatasaikiran
 * @date Oct 25, 2018 10:03:16 AM
 *
 */
@ManagedBean(name = "UserTrackerCntrl")
@RequestScoped 
public class UserTrackerCntrl extends BaseCntrl {

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public String forwardToPage() {
        return "trackerInfo";
    }
    
    public int getTotalViews() {
        return getTrackerInfo().size();
    }
    public ArrayList<UserProfileTracker> getTrackerInfo(){
        User user = getUser();
        return UserTrackerWebHelper.getInstance().getTrackerInfo(user.getUserId());
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
}