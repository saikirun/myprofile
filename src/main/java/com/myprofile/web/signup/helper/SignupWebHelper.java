/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.signup.helper;

import com.myprofile.model.Signup;
import com.myprofile.service.SignupService;
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
        signup.setActivationCode("TEST");
        /** pass userId to dao to retrieve values */
        Signup signupList = null;
        SignupService signupService = getSignupService();
        try {
            signupList = signupService.getAllByEmailId(emailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /** if signupResource not null then get status field */
        if (signupList != null) {
            int status = signupList.getStatus();
            /** If Status = 0 */
            if (status == 0) {
                /** show re-send activation link option */
            } else {
                /** continue to login page */
                return ("login");
            }
        } else {
            Signup userCreation = null;
            /** Create user by passing session values to DAO method **/
            try {
                userCreation = signupService.createUser(signup);
            } catch (Exception e) {
                e.printStackTrace();
            }
            /** If user creation was sucess **/
            if (userCreation != null) {
                /** Send Activation link to user emailId **/
                /** Display message "Activation link emailed. Please verify" **/
                System.out.println("Activation link emailed. Please verify");
            }
        }
        return "signup";
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
