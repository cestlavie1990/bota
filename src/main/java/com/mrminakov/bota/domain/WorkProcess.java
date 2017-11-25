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
import javax.persistence.Lob;
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
public class WorkProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "quantity")
    private String quantity;

    @Lob
    @Size(max = 65535)
    @Column(name = "notes")
    private String notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recordIdWorkProcess")
    private Collection<Types> typesCollection;

    @JoinColumn(name = "record_id_work", referencedColumnName = "record_id")
    @ManyToOne(optional = false)
    private Works recordIdWork;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Collection<Types> getTypesCollection() {
        return typesCollection;
    }

    public void setTypesCollection(Collection<Types> typesCollection) {
        this.typesCollection = typesCollection;
    }

    public Works getRecordIdWork() {
        return recordIdWork;
    }

    public void setRecordIdWork(Works recordIdWork) {
        this.recordIdWork = recordIdWork;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof WorkProcess)) {
            return false;
        }
        WorkProcess other = (WorkProcess) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WorkProcess[ recordId=" + recordId + " ]";
    }

}
