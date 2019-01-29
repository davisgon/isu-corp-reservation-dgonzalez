package com.dgonzalez.reservation.repository;

import com.dgonzalez.reservation.model.Reservation;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Author donzalez
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT * FROM reservation r where r.id_Contact = ?1 ", nativeQuery = true)
    Collection<Reservation> findAllReservationByIdContact(Integer idContact);
}
