package com.mrminakov.bota.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Mr.Minakov
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @NotNull
    @Size(min = 3, max = 255, message = "Логин должен быть длиной не менее 3 символов")
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 4, max = 255, message = "Пароль должен быть длиной не менее 4 символов")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @NotNull
    @Size(min = 1, max = 255, message = "Имя не задано")
    @Column(name = "name")
    private String name;

    @Column(name = "date_registration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistration;

    @Column(name = "position")
    private String position;

    @JoinTable(name = "users_and_places", joinColumns = {
        @JoinColumn(name = "record_id_user", referencedColumnName = "record_id")}, inverseJoinColumns = {
        @JoinColumn(name = "record_id_place", referencedColumnName = "record_id")})
    @ManyToMany
    private Collection<Places> placesCollection = new ArrayList<>();

    @JoinTable(name = "users_and_objects", joinColumns = {
        @JoinColumn(name = "record_id_user", referencedColumnName = "record_id")}, inverseJoinColumns = {
        @JoinColumn(name = "record_id_object", referencedColumnName = "record_id")})
    @ManyToMany
    private Collection<Objects> objectsCollection = new ArrayList<>();

    @JoinColumn(name = "record_id_company", referencedColumnName = "record_id")
    @ManyToOne(optional = false)
    private Companies recordIdCompany;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {        
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Collection<Places> getPlacesCollection() {
        return placesCollection;
    }

    public void setPlacesCollection(Collection<Places> placesCollection) {
        this.placesCollection = placesCollection;
    }

    public Collection<Objects> getObjectsCollection() {
        return objectsCollection;
    }

    public void setObjectsCollection(Collection<Objects> objectsCollection) {
        this.objectsCollection = objectsCollection;
    }

    public Companies getRecordIdCompany() {
        return recordIdCompany;
    }

    public void setRecordIdCompany(Companies recordIdCompany) {
        this.recordIdCompany = recordIdCompany;
    }

    public void addObjectToCollection(Objects object) {
        this.objectsCollection.add(object);
    }

    public void deleteObjectFromCollection(Objects object) {
        this.objectsCollection.add(object);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ recordId=" + recordId + " ]";
    }

}
