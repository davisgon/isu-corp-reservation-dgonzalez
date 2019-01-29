package com.dgonzalez.reservation.controller;

import com.dgonzalez.reservation.exception.ResourceNotFoundException;
import com.dgonzalez.reservation.model.Contact_backup;
import com.dgonzalez.reservation.repository.Contact_backupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Expert system of management of reservations of places of interest, this
 * application is made based on the requirements and points of pain exposed by
 * the Client. As part of the technical test.
 *
 * @version 1.00.0
 * @autor David Gonzalez
 * @client ISUCorp
 * Contact backup Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class Contact_backupController {

    @Autowired
    Contact_backupRepository contact_backupRepository;

    @GetMapping("/contact_backup")
    public List<Contact_backup> getAllContactType() {
        return contact_backupRepository.findAll();
    }

    @PostMapping("/contact_backup")
    public Contact_backup createContactType(@Valid @RequestBody Contact_backup contact_backup) {
        return contact_backupRepository.save(contact_backup);
    }

    @GetMapping("/contact_backup/{id}")
    public Contact_backup getContact_backupById(@PathVariable(value = "id") Long contact_backupId) {
        return contact_backupRepository.findById(contact_backupId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contact_backupId));
    }

    @PutMapping("/contact_backup/{id}")
    public Contact_backup updateContact_backup(@PathVariable(value = "id") Long contact_backupId,
            @Valid @RequestBody Contact_backup contact_backupDetails) {

        Contact_backup Contact_backup = contact_backupRepository.findById(contact_backupId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact_backup", "id", contact_backupId));
        Contact_backup updatedContact_backup = contact_backupRepository.save(Contact_backup);
        return updatedContact_backup;
    }

    @DeleteMapping("/contact_backup/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long contactId) {
        Contact_backup contact = contact_backupRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));
        contact_backupRepository.delete(contact);
        return ResponseEntity.ok().build();
    }
}
