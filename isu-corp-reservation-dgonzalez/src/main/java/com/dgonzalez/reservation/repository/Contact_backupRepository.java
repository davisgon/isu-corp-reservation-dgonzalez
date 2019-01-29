package com.dgonzalez.reservation.repository;

import com.dgonzalez.reservation.model.Contact_backup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author donzalez
 */
@Repository
public interface Contact_backupRepository extends JpaRepository<Contact_backup, Long> {

}
