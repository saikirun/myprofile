/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myprofile.model.Signup;

/**
 * @author venkatasaikiran
 * @date Mar 29, 2018 12:04:13 AM
 */
@Repository
public interface SignupResource extends JpaRepository<Signup, Long> {
    @Query(" from Signup m where lower(m.emailId) = lower(:emailId)")
    public Signup findByEmailId(@Param("emailId") String emailId);

}
