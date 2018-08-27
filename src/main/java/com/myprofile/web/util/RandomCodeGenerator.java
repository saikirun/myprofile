/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.web.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author venkatasaikiran
 * @date Apr 2, 2018 6:31:33 PM
 *
 */
public class RandomCodeGenerator {

    //--------------------------------------------------------------- Constants
    public static final int CODE_GEN_SIZE = 5;
    //--------------------------------------------------------- Class Variables
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    
    public static String randomCodeGenerator(){
        
        return RandomStringUtils.random(CODE_GEN_SIZE, false, true);
    }
    //----------------------------------------------------------- Inner Classes
}