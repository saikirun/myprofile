/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.myprofile.model.User;
import com.myprofile.model.UserBasicInfo;
import com.myprofile.model.UserProfile;
import com.myprofile.web.base.BaseCntrl;
import com.myprofile.web.helper.FileUploadWebHelper;

/**
 * @author venkatasaikiran
 * @date Oct 8, 2018 11:51:04 AM
 */
@ManagedBean(name = "FileUploadCntrl")
@RequestScoped
public class FileUploadCntrl extends BaseCntrl {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Part file;
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }    

    public byte[] getProfileImage() {
        User user = getUser();
        return FileUploadWebHelper.getInstance().getProfileImage(user.getUserId());
    }
    
    public void uploadProfileImage() {
        UserBasicInfo userBasicInfo = getUserBasicInfo();
        FileUploadWebHelper.getInstance().uploadProfileImage(userBasicInfo, file);
    }
    
    public void validateProfile(FacesContext ctx, UIComponent comp, Object value) {
        file = (Part) value;
        FileUploadWebHelper.getInstance().profileUploadValidator(file);
    }
    
    public void validateImageUpload(FacesContext ctx, UIComponent comp, Object value) {
        file = (Part) value;
        FileUploadWebHelper.getInstance().imageUploadValidator(file);
    }

    public String uploadProfile() {
        User user = getUser();
        UserProfile userProfile = getUserProfile();
        return FileUploadWebHelper.getInstance().uploadProfile(userProfile, user, file);
    }
    
    public String getProfile() {
        UserProfile userProfile = getUserProfile();
        User user = getUser();
        String userId = user.getUserId();
        FileUploadWebHelper.getInstance().downloadProfile(userProfile, userId);
        return "";
    }
    
    public String getProfileLink() {
        UserProfile userProfile = getUserProfile();
        User user = getUser();
        String userId = user.getUserId();
        return FileUploadWebHelper.getInstance().profileLink(userProfile, userId);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
