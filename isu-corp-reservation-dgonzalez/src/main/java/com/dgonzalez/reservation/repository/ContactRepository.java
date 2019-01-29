package com.dgonzalez.reservation.repository;

import com.dgonzalez.reservation.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Author donzalez
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM contact c where c.name = ?1 ", nativeQuery = true)
    Contact  findAllContactByName(String name);
}
