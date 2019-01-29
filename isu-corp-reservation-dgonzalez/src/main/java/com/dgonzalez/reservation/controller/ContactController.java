package com.dgonzalez.reservation.controller;

import com.dgonzalez.reservation.exception.ResourceNotFoundException;
import com.dgonzalez.reservation.model.Contact;

import com.dgonzalez.reservation.repository.ContactRepository;
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
 * Contact Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/contact")
    public List<Contact> getAllContactType() {
        return contactRepository.findAll();
    }

    @PostMapping("/contact")
    public Contact createContactType(@Valid @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @GetMapping("/contact/{id}")
    public Contact getContactTypeById(@PathVariable(value = "id") Long contactId) {
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));
    }

    @GetMapping(path = "/contact/contact/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Contact getContactByName(@PathVariable(value = "name") String name) {
        return contactRepository.findAllContactByName(name);
    }

    @PutMapping("/contact/{id}")
    public Contact updateContact(@PathVariable(value = "id") Long contactId,
            @Valid @RequestBody Contact contactDetails) {

        Contact Contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        Contact updatedContact = contactRepository.save(Contact);
        return updatedContact;
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contactRepository.delete(contact);

        return ResponseEntity.ok().build();
    }
}
