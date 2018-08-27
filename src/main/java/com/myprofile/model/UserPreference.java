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
 * @date Apr 8, 2018 12:55:55 PM
 *
 */
@ManagedBean(name="UserPreference")
@Entity
@Table(name = "mp_user_prefs")
public class UserPreference {

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    @Id
    @Column(name = "PREF_ID")
    private String prefId;
    
    @Column(name = "PREF_CODE")
    private String prefCode;
    
    @Column(name = "PREF_DESCRIPTION")
    private String prefDescription;
    
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