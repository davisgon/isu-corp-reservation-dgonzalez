package com.dgonzalez.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author dgonzalez
 */
@Entity
@Table(name = "contact_type")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@XmlRootElement

public class ContactType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contact_type")
    private Long id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "contactoType", cascade = CascadeType.ALL)
    private Set<Contact> contacts;

    public ContactType() {
    }

    public ContactType(Long idContactType) {
        this.id = idContactType;
    }

    public ContactType(Long idContactType, String description) {
        this.id = idContactType;
        this.description = description;
    }

    public Long getIdContactType() {
        return id;
    }

    public void setIdContactType(Long idContactType) {
        this.id = idContactType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactType)) {
            return false;
        }
        ContactType other = (ContactType) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "gt.com.mavenproject1.ContactType[ idContactType=" + id + " ]";
    }

}
