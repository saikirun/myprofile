/**
 * Alll Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.util;

import java.io.File;

import javax.faces.context.FacesContext;

import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

/**
 * @author Shanmu
 * @date Mar 7, 2014 10:55:36 PM
 */
public abstract class WebSpringContext {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    private static WebApplicationContext context = null;

    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    /**
     * @param name
     * @return
     */
    public static Object getBean(final String name) {
        setContext();
        return context.getBean(name);
    }

    /**
     * @param fileName
     * @return
     */
    public static Resource getTemplateResource(final String fileName) {
        return context.getResource(
                "classpath:template" + File.separatorChar + fileName);
    }

    /**
     * @param fileName
     * @return
     */
    public static Resource getXMLResource(final String fileName) {
        return context.getResource(
                "classpath:xmldoc" + File.separatorChar + fileName);
    }

    public static Resource getFormResource(final String fileName) {
        return context
                .getResource("classpath:forms" + File.separatorChar + fileName);
    }

    /**
     * Checks if context is null , pulls from webapplication context
     */
    private static void setContext() {
        if (context == null) {
            context = FacesContextUtils.getWebApplicationContext(
                    FacesContext.getCurrentInstance());
        }
    }
    // ----------------------------------------------------------- Inner Classes
}
