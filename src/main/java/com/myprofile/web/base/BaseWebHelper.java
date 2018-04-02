/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.base;

import com.myprofile.service.SignupService;
import com.myprofile.web.util.WebSpringContext;

/**
 * @author Shanmu
 * @date Apr 2, 2018 12:50:32 AM
 */
public class BaseWebHelper {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @return
     */
    public SignupService getSignupService() {
        return (SignupService) WebSpringContext
                .getBean(SignupService.SERVICE_NAME);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
