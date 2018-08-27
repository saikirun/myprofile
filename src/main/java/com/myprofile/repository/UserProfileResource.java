/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myprofile.model.UserProfile;

/**
 * @author venkatasaikiran
 * @date Apr 8, 2018 1:28:43 PM
 *
 */
public interface UserProfileResource extends JpaRepository<UserProfile, Long>{

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    @Query(" from UserProfile u where lower(u.userId) = lower (:userId)")
    public UserProfile findByUserId(@Param("userId") String userId);
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    //------------------------------------------------------- Protected Methods
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    //----------------------------------------------------------- Inner Classes
}