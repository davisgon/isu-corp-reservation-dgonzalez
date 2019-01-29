package com.dgonzalez.reservation.controller;

import com.dgonzalez.reservation.exception.ResourceNotFoundException;
import com.dgonzalez.reservation.repository.ReservationRepository;
import com.dgonzalez.reservation.model.Reservation;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.http.MediaType;

/**
 * Expert system of management of reservations of places of interest, this
 * application is made based on the requirements and points of pain exposed by
 * the Client. As part of the technical test.
 *
 * @version 1.00.0
 * @autor David Gonzalez
 * @client ISUCorp
 * Reservation Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservation")
    public List<Reservation> getAllContactType() {
        return reservationRepository.findAll();
    }

    @PostMapping("/reservation")
    public Reservation createContactType(@Valid @RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @GetMapping(path = "/reservation/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Reservation getContactTypeById(@PathVariable(value = "id") Integer reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("reservation", "id", reservationId));
    }

    @GetMapping(path = "/reservation/contact/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Collection<Reservation> findAllReservationByIdContact(@PathVariable(value = "id") Integer reservationId) {
        return reservationRepository.findAllReservationByIdContact(reservationId);
    }

    @PutMapping("/reservation")
    public Reservation updateReservation(@Valid @RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId));

        reservationRepository.delete(reservation);

        return ResponseEntity.ok().build();
    }
}
