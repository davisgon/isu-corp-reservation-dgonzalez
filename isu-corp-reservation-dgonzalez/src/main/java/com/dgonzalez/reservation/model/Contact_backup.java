package com.dgonzalez.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 *
 * @author dgonzalez
 */
@Entity
@EnableAutoConfiguration
@Table(name = "contact_backup")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@XmlRootElement

public class Contact_backup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contact")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Lob
    @Column(name = "image")
    private byte[] image;

    @Basic(optional = false)
    @Column(name = "id_contact_type")
    private Long id_contact_type;

    public Contact_backup() {
    }

    public Contact_backup(Long idContact) {
        this.id = idContact;
    }

    public Contact_backup(Long idContact, String name, String phoneNumber) {
        this.id = idContact;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

//    @XmlTransient
//    public Collection<Reservation> getReservationCollection() {
//        return reservationCollection;
//    }
//
//    public void setReservationCollection(Collection<Reservation> reservationCollection) {
//        this.reservationCollection = reservationCollection;
//    }
//
//    public ContactType getIdContactType() {
//        return idContactType;
//    }
//
//    public void setIdContactType(ContactType idContactType) {
//        this.idContactType = idContactType;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact_backup)) {
            return false;
        }
        Contact_backup other = (Contact_backup) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "gt.com.mavenproject1.Contact[ idContact=" + id + " ]";
    }

}
