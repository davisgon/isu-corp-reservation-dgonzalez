package com.dgonzalez.reservation.controller;

import com.dgonzalez.reservation.exception.ResourceNotFoundException;
import com.dgonzalez.reservation.model.ContactType;
import com.dgonzalez.reservation.repository.ContactTypeRepository;
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
 * Contact Type Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ContactTypeController {

    @Autowired
    ContactTypeRepository contactTypeRepository;

    @GetMapping("/contact_type")
    public List<ContactType> getAllContactType() {
        return contactTypeRepository.findAll();
    }

    @PostMapping("/contact_type")
    public ContactType createContactType(@Valid @RequestBody ContactType contactType) {
        return contactTypeRepository.save(contactType);
    }

    @GetMapping("/contact_type/{id}")
    public ContactType getContactTypeById(@PathVariable(value = "id") Long contactTypeId) {
        return contactTypeRepository.findById(contactTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact_type", "id", contactTypeId));
    }

    @PutMapping("/contact_type/{id}")
    public ContactType updateNote(@PathVariable(value = "id") Long contactTypeId,
            @Valid @RequestBody ContactType noteDetails) {

        ContactType contactType = contactTypeRepository.findById(contactTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact_type", "id", contactTypeId));

        ContactType updatedNote = contactTypeRepository.save(contactType);
        return updatedNote;
    }

    @DeleteMapping("/contact_type/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long contactTypeId) {
        ContactType contactType = contactTypeRepository.findById(contactTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact_type", "id", contactTypeId));

        contactTypeRepository.delete(contactType);

        return ResponseEntity.ok().build();
    }
}
