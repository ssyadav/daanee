/**
 * 
 */
package com.daanee.daaneeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daanee.daaneeapp.entity.Emergency;

/**
 * @author satyaveer.yadav
 *
 */
@Repository("emergencyRepository")
public interface EmergencyRepository extends JpaRepository<Emergency, Long> {

	Emergency findById(int id);

}
