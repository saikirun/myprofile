/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author venkatasaikiran
 * @date Apr 8, 2018 12:55:34 PM
 *
 */
@ManagedBean(name="UserProfile")
@Entity
@Table(name = "mp_user_profile")
public class UserProfile {

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    @Id
    @Column(name = "USER_ID")
    private String userId;
    
    @Column(name = "PROFILE")
    private long profile;
    
    @Column(name = "TRACKING_CODE")
    private String trackingCode;
    
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getProfile() {
        return profile;
    }

    public void setProfile(long profile) {
        this.profile = profile;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }
    
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
    
}