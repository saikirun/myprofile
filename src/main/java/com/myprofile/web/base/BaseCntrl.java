/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.base;

import javax.faces.context.FacesContext;

import com.myprofile.model.Signup;
import com.myprofile.model.User;

/**
 * @author venkatasaikiran
 * @date Mar 30, 2018 4:54:55 PM
 */
public class BaseCntrl {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    public void forwardFromEvent(String pageName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getApplication().getNavigationHandler().handleNavigation(fc, null,
                pageName);
    }

    public void addObjectToSession(Object obj, String sessionId) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc == null || fc.getExternalContext() == null
                || fc.getExternalContext().getSessionMap() == null) {
            return;
        }
        fc.getExternalContext().getSessionMap().put(sessionId, obj);
    }

    public Object getObjectFromSession(String sessionId) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc == null || fc.getExternalContext() == null
                || fc.getExternalContext().getSessionMap() == null) {
            return null;
        }
        Object obj = fc.getExternalContext().getSessionMap().get(sessionId);
        return obj;
    }

    public User getUser() {
        User user = (User) getObjectFromSession("User");
        if (user == null) {
            user = new User();
            addObjectToSession(user, "User");
        }
        return user;
    }

    public Signup getSignup() {
        Signup signup = (Signup) getObjectFromSession("Signup");
        if (signup == null) {
            signup = new Signup();
            addObjectToSession(signup, "Signup");
        }
        return signup;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
