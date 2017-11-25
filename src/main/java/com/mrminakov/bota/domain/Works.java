package com.mrminakov.bota.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mr.Minakov
 */
public class Works implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @JoinColumn(name = "record_id_place", referencedColumnName = "record_id")
    @ManyToOne(optional = false)
    private Places recordIdPlace;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recordIdWork")
    private Collection<WorkProcess> workProcessCollection;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Places getRecordIdPlace() {
        return recordIdPlace;
    }

    public void setRecordIdPlace(Places recordIdPlace) {
        this.recordIdPlace = recordIdPlace;
    }

    public Collection<WorkProcess> getWorkProcessCollection() {
        return workProcessCollection;
    }

    public void setWorkProcessCollection(Collection<WorkProcess> workProcessCollection) {
        this.workProcessCollection = workProcessCollection;
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
        if (!(object instanceof Works)) {
            return false;
        }
        Works other = (Works) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Works[ recordId=" + recordId + " ]";
    }
}
