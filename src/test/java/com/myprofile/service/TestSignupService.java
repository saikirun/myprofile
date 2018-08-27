/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.myprofile.model.Signup;

/**
 * @author Shanmu
 * @date Apr 2, 2018 12:15:03 AM
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestSignupService
        extends AbstractTransactionalJUnit4SpringContextTests {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private UserService userService;
    
    @Autowired
    private JavaMailSenderImpl mailSender;

    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    @Test
    public void testSignup() {
        Signup signup = userService.getByEmailId("test@gmail.com");
        Assert.assertNull(signup);
    }
    
    @Test
    public void testEmailSender(){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("kirun5535@gmail.com");
//        message.setSubject("Test myprofile");
//        message.setText("Test Myprofile service body");
//        message.setFrom("kirun6149@gmail.com");
//        mailSender.send(message);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
