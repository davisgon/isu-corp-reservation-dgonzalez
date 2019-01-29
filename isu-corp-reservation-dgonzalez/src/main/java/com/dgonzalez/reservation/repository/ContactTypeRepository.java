package com.dgonzalez.reservation.repository;

import com.dgonzalez.reservation.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author donzalez
 */
@Repository
public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {

}
