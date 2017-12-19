package com.mrminakov.bota.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mr.Minakov
 */
@Entity
@Table(name = "group_users")
public class GroupUsers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "group_name")
    private String groupName;

    @JoinColumn(name = "user_login", referencedColumnName = "login")
    @ManyToOne(optional = false)
    private Users userLogin;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Users getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(Users userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GroupUsers)) {
            return false;
        }
        GroupUsers other = (GroupUsers) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GroupUsers[ recordId=" + recordId + " ]";
    }
}