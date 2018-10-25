/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.helper;

import com.myprofile.model.Signup;
import com.myprofile.service.UserService;
import com.myprofile.web.base.BaseWebHelper;

/**
 * @author Shanmu
 * @date Apr 2, 2018 12:47:26 AM
 */
public class SignupWebHelper extends BaseWebHelper {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    private static SignupWebHelper instance = new SignupWebHelper();

    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
   
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    public String signupAction(Signup signup) {
        String emailId = signup.getEmailId();
        
        /** pass userId to dao to retrieve values */
        Signup signupList = null;
        UserService userService = getUserService();
        try {
            signupList = userService.getByEmailId(emailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /** if signupResource not null then get status field */
        if (signupList != null) {
            int status = signupList.getStatus();
            /** If Status = 0 */
            if (status == 0) {
                /** show re-send activation link option */
                addFacesMsg("Activation Code already sent. Please Check your Email Id.");
                return "verifyAccount";
            } else {
                /** continue to login page */
                return ("login");
            }
        } else {
           
            /** Create user by passing session values to DAO method **/
            try {
                userService.createUser(signup);
                addFacesMsg("Activation Code sent. Please Check your Email.");
                return "verifyAccount";
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return "signup";
    }
    
    public String verifyActivationCode(Signup signup){
        String code = signup.getActivationCode();
        String emailId = signup.getEmailId();
        /** pass userId to dao to retrieve values */
        Signup signupUser = null;
        UserService userService = getUserService();
        try {
            signupUser = userService.getByEmailId(emailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(signupUser != null){
            if(code.equals(signupUser.getActivationCode())){
                /** Show create password option***/
                userService.activateUser(signupUser);
                addFacesMsg("Account Verified! \n Please login. ");
                /**set password option to visible***/
                return "login";
            } else{
                addFacesMsg("Activation code not Valid. Please check your code");
                return "verifyAccount";
            }
        }
        return "login";
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods

    // ---------------------------------------------------------- Static Methods
    public static SignupWebHelper getInstance() {
        return instance;
    }
    // ----------------------------------------------------------- Inner Classes
}
