/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.signup;

import javax.faces.bean.ManagedBean;

import com.myprofile.model.Signup;
import com.myprofile.web.base.BaseCntrl;
import com.myprofile.web.signup.helper.SignupWebHelper;

/**
 * @author venkatasaikiran
 * @date Mar 29, 2018 12:01:58 AM
 */
@ManagedBean(name = "SignupCntrl")
public class SignupCntrl extends BaseCntrl {
    /**
     * @return
     */
    public String redirectToSignupPage() {
        getSignup();
        return "signup";
    }

    /**
     * @return
     */
    public String signupAction() {
        Signup signup = getSignup();
        return SignupWebHelper.getInstance().signupAction(signup);
    }
    
    public void verificationCodeAction(){
        Signup signup = getSignup();
        SignupWebHelper.getInstance().verifyActivationCode(signup);
    }
}
