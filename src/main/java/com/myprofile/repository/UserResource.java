/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myprofile.model.User;

/**
 * @author venkatasaikiran
 * @date Mar 26, 2018 12:09:17 AM
 */
@Repository
public interface UserResource extends JpaRepository<User, Long> {
    @Query(" from User u where lower(u.userId) = lower (:userId)")
    public User findByUserId(@Param("userId") String userId);
}
// --------------------------------------------------------------- Constants
// --------------------------------------------------------- Class Variables
// ----------------------------------------------------- Static Initializers
// ------------------------------------------------------ Instance Variables
// ------------------------------------------------------------ Constructors
// ---------------------------------------------------------- Public Methods
// ------------------------------------------------------- Protected Methods
// --------------------------------------------------------- Default Methods
// --------------------------------------------------------- Private Methods
// ---------------------------------------------------------- Static Methods
// ----------------------------------------------------------- Inner Classes
