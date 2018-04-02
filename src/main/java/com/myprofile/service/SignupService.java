/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myprofile.model.Signup;
import com.myprofile.repository.SignupResource;

/**
 * @author venkatasaikiran
 * @date Mar 30, 2018 6:56:13 PM
 */
public class SignupService {
    // --------------------------------------------------------- Class Variables
    // --------------------------------------------------------------- Constants
    public static final String SERVICE_NAME = "signupService";
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    SignupResource signupResource;

    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    public Signup getAllByEmailId(String emailId) {
        return signupResource.findByEmailId(emailId);
    }

    public Signup createUser(Signup signup) {
        return signupResource.save(signup);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
