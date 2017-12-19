package com.mrminakov.bota.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mr.Minakov
 */
@Entity
@Table(name = "objects")
public class Objects implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Size(max = 255)
    @Column(name = "customer")
    private String customer;

    @Size(max = 255)
    @Column(name = "general_builder")
    private String generalBuilder;

    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "is_active")
    private Boolean isActive;

    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "uq_key")
    private String uqKey;

    @JoinTable(name = "users_and_objects", joinColumns = {
        @JoinColumn(name = "record_id_object", referencedColumnName = "record_id")}, inverseJoinColumns = {
        @JoinColumn(name = "record_id_user", referencedColumnName = "record_id")})
    @ManyToMany//(mappedBy = "objectsCollection")
    private Collection<Users> usersCollection = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recordIdObject")
    private Collection<Places> placesCollection;

    @JoinColumn(name = "record_id_company", referencedColumnName = "record_id")
    @ManyToOne(optional = false)
    private Companies recordIdCompany;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getGeneralBuilder() {
        return generalBuilder;
    }

    public void setGeneralBuilder(String generalBuilder) {
        this.generalBuilder = generalBuilder;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getUqKey() {
        return uqKey;
    }

    public void setUqKey(String uqKey) {
        this.uqKey = uqKey;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Collection<Places> getPlacesCollection() {
        return placesCollection;
    }

    public void setPlacesCollection(Collection<Places> placesCollection) {
        this.placesCollection = placesCollection;
    }

    public Companies getRecordIdCompany() {
        return recordIdCompany;
    }

    public void setRecordIdCompany(Companies recordIdCompany) {
        this.recordIdCompany = recordIdCompany;
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
        if (!(object instanceof Objects)) {
            return false;
        }
        Objects other = (Objects) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Objects[ recordId=" + recordId + " ]";
    }

}