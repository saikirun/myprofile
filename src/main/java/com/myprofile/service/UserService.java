/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.myprofile.model.Signup;
import com.myprofile.model.User;
import com.myprofile.model.UserBasicInfo;
import com.myprofile.model.UserProfile;
import com.myprofile.model.UserProfileTracker;
import com.myprofile.repository.SignupResource;
import com.myprofile.repository.UserBascInfoResource;
import com.myprofile.repository.UserProfileResource;
import com.myprofile.repository.UserProfileTrackerResource;
import com.myprofile.repository.UserResource;
import com.myprofile.web.util.RandomCodeGenerator;

/**
 * @author venkatasaikiran
 * @date Mar 30, 2018 6:56:13 PM
 */
public class UserService {
    // --------------------------------------------------------- Class Variables
    // --------------------------------------------------------------- Constants
    public static final String SERVICE_NAME = "userService";
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    SignupResource signupResource;
    
    @Autowired
    UserResource userResource;
    
    @Autowired
    UserProfileResource userProfileResource;
    
    @Autowired
    UserProfileTrackerResource userProfileTrackerResource;
    
    @Autowired
    UserBascInfoResource userBasicInfoResource;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    public Signup getByEmailId(String emailId) {
        return signupResource.findByEmailId(emailId);
    }

    @Transactional
    public Signup createUser(Signup signup) {
        signup.setDateCreated(Calendar.getInstance().getTime());
        signup.setPassword(bCryptPasswordEncoder.encode(signup.getPassword()));
        signup.setActivationCode(RandomCodeGenerator.randomCodeGenerator());
        
        Signup userCreation = signupResource.save(signup);
        /** If user creation was sucess **/
        if (userCreation != null) {
            /** Send Activation link to user emailId **/
            try {
                emailServiceImpl.sendMail(userCreation.getEmailId(), "Myprofile Activation Code",
                        "<html><body style=\" padding:10px; background-color:#f8f9fa; border:1px solid #d1d7dd;\">"
                        + "<p>Your Myprofile Activation Code is:</p>"+
            "<b>"+userCreation.getActivationCode()+"</b></body></html>");
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            /** Display message "Activation link emailed. Please verify" **/
            System.out.println("Activation link emailed. Please verify");
        }
        return userCreation;
    }
    
    public User findUser(String userId){
        return userResource.findByUserId(userId);
    }
    
    public User saveUser(User userList){
        return userResource.save(userList);
    }
    
    public UserBasicInfo findUserBasicInfo(String userId) {
        return userBasicInfoResource.findByUserId(userId);
    }
    
    public UserBasicInfo saveUserBasicInfo(UserBasicInfo userBasicInfo) {
        return userBasicInfoResource.save(userBasicInfo);
    }
    
    public UserProfile findUserProfile(String userId) {
        return userProfileResource.findByUserId(userId);
    }
    
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileResource.save(userProfile);
    }
    
    public ArrayList<UserProfileTracker> getTrackerInfo(String userId){
        return userProfileTrackerResource.findAllByUserId(userId);
    }
    
    public UserProfileTracker saveUserProfileTracker(UserProfileTracker userProfileTracker) {
        return userProfileTrackerResource.save(userProfileTracker);
    }
    
    @Transactional
    public void activateUser(Signup signupUser){
        signupUser.setStatus(1);
        signupResource.save(signupUser);
        
        User user = new User();
        user.setUserId(signupUser.getEmailId());
        user.setPassword(signupUser.getPassword());
        user.setRole(0);
        user.setStatus(1);
        user.setLastLoginDate(Calendar.getInstance().getTime());
        
        userResource.save(user);
    }
    
    public String updateUserAction() {
        return "accountBasicInfo";
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
