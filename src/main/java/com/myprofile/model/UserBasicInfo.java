/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author venkatasaikiran
 * @date Apr 4, 2018 12:48:27 AM
 *
 */
@ManagedBean(name="UserBasicInfo")
@Entity
@Table(name = "mp_user_basic_info")
public class UserBasicInfo {


    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    @Id
    @Column(name = "USER_ID")
    private String userId;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "PHONE_NUM")
    private long phoneNum;
    
    @Column(name = "ADDRESS_LINE_ONE")
    private String addressOne;
    
    @Column(name = "ADDRESS_LINE_TWO")
    private String addressTwo;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "ZIP")
    private String zip;
    
    @Column(name = "COUNTRY_ID")
    private String country;
    
    @Lob
    @Column(name = "PROFILE_IMAGE")
    private byte[] profileImage;
    
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public long getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getAddressOne() {
        return addressOne;
    }
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }
    public String getAddressTwo() {
        return addressTwo;
    }
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public byte[] getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }
    
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
    
}