/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myprofile.model.UserBasicInfo;

/**
 * @author venkatasaikiran
 * @date Apr 4, 2018 12:49:12 AM
 *
 */
@Repository
public interface UserBascInfoResource extends JpaRepository<UserBasicInfo, Long> {
    

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    @Query(" from UserBasicInfo u where lower(u.userId) = lower (:userId)")
    public UserBasicInfo findByUserId(@Param("userId") String userId);
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