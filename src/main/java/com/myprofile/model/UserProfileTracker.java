/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author venkatasaikiran
 * @date Apr 8, 2018 12:56:15 PM
 *
 */
@ManagedBean(name="UserProfileTracker")
@Entity
@Table(name = "mp_user_profile_tracker")
public class UserProfileTracker {

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "TRACKING_ID")
    private long trackingId;
    
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    
    @Column(name = "LINK_ACCESSD_DATE")
    private Date linkAccessedDate;
    
    @Column(name = "USER_ID")
    private String userId;
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods

    public long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(long trackingId) {
        this.trackingId = trackingId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getLinkAccessedDate() {
        return linkAccessedDate;
    }

    public void setLinkAccessedDate(Date linkAccessedDate) {
        this.linkAccessedDate = linkAccessedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
    
}