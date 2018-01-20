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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Mr.Minakov
 */
@Entity
@Table(name = "companies")
public class Companies implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String EMAIL_REGEXP = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)"
            + "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)"
            + "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)"
            + "+(?:[a-zA-Z]){2,}\\.?)$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @NotNull
    @Size(min = 3, max = 255, message = "Название должно быть длиной не менее 3 символов")
    @Column(name = "name")
    private String name;

    @Column(name = "date_registration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistration;

    @NotNull
    @Size(min = 6, max = 255, message = "Слишком короткий адрес")
    @Pattern(regexp = EMAIL_REGEXP, message = "Заданный email не может существовать")
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 3, max = 32, message = "Логин должен быть длиной от 3 до 32 символов")
    @Column(name = "company_login")
    private String companyLogin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recordIdCompany")
    private Collection<Objects> objectsCollection = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recordIdCompany")
    private Collection<Users> usersCollection = new ArrayList<>();

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

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Objects> getObjectsCollection() {
        return objectsCollection;
    }

    public void setObjectsCollection(Collection<Objects> objectsCollection) {
        this.objectsCollection = objectsCollection;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public String getCompanyLogin() {
        return companyLogin;
    }

    public void setCompanyLogin(String companyLogin) {
        this.companyLogin = companyLogin;
    }

    public void addUserToCollection(Users user) {
        this.usersCollection.add(user);
    }

    public void deleteUserFromCollection(Users user) {
        this.usersCollection.remove(user);
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
        if (!(object instanceof Companies)) {
            return false;
        }
        Companies other = (Companies) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Companies[ recordId=" + recordId + " ]";
    }

}
