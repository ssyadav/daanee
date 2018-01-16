/**
 * 
 */
package com.daanee.daaneeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daanee.daaneeapp.entity.Ambulance;


/**
 * @author satyaveer.yadav
 *
 */
@Repository("ambulanceRepository")
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {

	Ambulance findById(int id);
}
