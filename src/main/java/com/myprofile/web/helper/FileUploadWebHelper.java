/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.hibernate.metamodel.ValidationException;

import com.myprofile.model.User;
import com.myprofile.model.UserBasicInfo;
import com.myprofile.model.UserProfile;
import com.myprofile.service.UserService;
import com.myprofile.web.base.BaseWebHelper;
import com.myprofile.web.util.RandomCodeGenerator;

/**
 * @author venkatasaikiran
 * @date Oct 8, 2018 11:51:45 AM
 *
 */
public class FileUploadWebHelper extends BaseWebHelper{

    //--------------------------------------------------------------- Constants
    private static final int MAX_FILE_SIZE =  10485760;
    //--------------------------------------------------------- Class Variables
    private static FileUploadWebHelper instance = new FileUploadWebHelper();
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    public void profileUploadValidator(Part file) {
        FacesMessage msg = null;
        try {
            if (file == null || file.getSize()<=0 || file.getContentType().isEmpty()) {
                msg = new FacesMessage("Please upload a valid file.");
            }
            else if (file.getSize() > MAX_FILE_SIZE) {
                msg = new FacesMessage("Uploaded file size is (" + file.getSize() + ") too big. File size should be below 10MB.");
            }
            else if (!"application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                    .equals(file.getContentType())) {
                msg = new FacesMessage("not a .docx file");
            }
            if(msg != null && !msg.getDetail().isEmpty()) {
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidationException(msg.getSummary());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void imageUploadValidator(Part file) {
        if (file == null) {
            addFacesMsg("Empty file can't be uploaded.");
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            addFacesMsg("Uploaded file size is (" + file.getSize() + ") too big. File size should be below 10MB.");
        }
    }
    
    public byte[] getProfileImage(String userId) {
        byte[] image = null;
        UserBasicInfo userBasicInfo = null;
        
        try {
            UserService userService = getUserService();
            userBasicInfo = userService.findUserBasicInfo(userId);
            if(userBasicInfo != null) {
                image = userBasicInfo.getProfileImage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return image;
    }
    
    public void uploadProfileImage(UserBasicInfo userBasicInfo, Part file) {
        try {
            UserService userService = getUserService();
            byte[] image = IOUtils.toByteArray(file.getInputStream());
            if(userBasicInfo != null) {
                userBasicInfo.setProfileImage(image);
                userService.saveUserBasicInfo(userBasicInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String uploadProfile(UserProfile userProfile, User user, Part file) {
        String rootPath = System.getProperty("catalina.home");
        
        InputStream inputStream = null;
        
        try {
            UserService userService = getUserService();
            userProfile = userService.findUserProfile(user.getUserId());
            inputStream = file.getInputStream();
            
            String outputFile = rootPath+File.separator+file.getSubmittedFileName();

            byte[] byteFile = IOUtils.toByteArray(file.getInputStream()); //fileContent.getBytes();
            
            FileOutputStream os = new FileOutputStream(outputFile);
            
            // write bytes taken from uploaded file to target file
            int fileSize = inputStream.read();
               while (fileSize != -1) {
                    os.write(fileSize);
                    fileSize = inputStream.read();
               }
            os.close();
            
            inputStream.close();
            
            if(inputStream != null) { 
                if(userProfile.getUserId() == null) {
                    userProfile.setUserId(user.getUserId());
                    userProfile.setTrackingCode(RandomCodeGenerator.randomCodeTrackerGenerator());
                }
                
               
                userProfile.setProfile(byteFile);
                
                userService.saveUserProfile(userProfile);
                addFacesMsg("Profile Uploaded Successfully. Please use below URL to share your profile");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return"";
    }
    
    public void downloadProfile(UserProfile userProfile, String userId) {
        String rootPath = System.getProperty("catalina.home");
        
        UserService userService = getUserService();
        try {
            userProfile = userService.findUserProfile(userId);
            if(userProfile.getProfile() != null) {
                
             // Create the file on server
                File file = new File(rootPath+File.separator+userProfile.getTrackingCode()+".docx");
                
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(file));
                stream.write(userProfile.getProfile());
                stream.close();
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public String profileLink(UserProfile userProfile, String userId) {
        String rootPath = System.getProperty("catalina.home");
        UserService userService = getUserService();
        String fileURL = "";
        try {
            userProfile = userService.findUserProfile(userId);
            if (userProfile.getProfile() != null) {
                // Create the file on server
                File file = new File(rootPath + File.separator
                        + userProfile.getTrackingCode() + ".docx");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(file));
                stream.write(userProfile.getProfile());
                stream.close();
                fileURL = file.toURI().toURL().getPath();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return fileURL;
    }
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    public static FileUploadWebHelper getInstance() {
        return instance;
    }
    //----------------------------------------------------------- Inner Classes
}