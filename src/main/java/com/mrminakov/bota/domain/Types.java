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
@Table(name = "types")
public class Types implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "dimension")
    private String dimension;

    @NotNull
    @Column(name = "standart_consuption")
    private float standartConsuption;

    @JoinColumn(name = "record_id_work_process", referencedColumnName = "record_id")
    @ManyToOne(optional = false)
    private WorkProcess recordIdWorkProcess;

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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public float getStandartConsuption() {
        return standartConsuption;
    }

    public void setStandartConsuption(float standartConsuption) {
        this.standartConsuption = standartConsuption;
    }

    public WorkProcess getRecordIdWorkProcess() {
        return recordIdWorkProcess;
    }

    public void setRecordIdWorkProcess(WorkProcess recordIdWorkProcess) {
        this.recordIdWorkProcess = recordIdWorkProcess;
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
        if (!(object instanceof Types)) {
            return false;
        }
        Types other = (Types) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Types[ recordId=" + recordId + " ]";
    }
}