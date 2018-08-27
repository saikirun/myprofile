/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "TRACKING_ID")
    private String trackingId;
    
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    
    @Column(name = "LINK_ACCESSD_DATE")
    private Date linkAccessedDate;
    
    @Column(name = "USER_ID")
    private String userId;
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
    
}