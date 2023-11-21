package com.example.crudapp.model;

import com.example.crudapp.config.Auditable;
import com.example.crudapp.constants.RecordStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Auditable {

    protected Long id= null;

    private RecordStatus recordStatus;
    private User createdBy;
    private User changedBy;
    private Date dateCreated;

    private Date dateChanged;

    public BaseEntity() {
        this.recordStatus = RecordStatus.ACTIVE;
        this.dateCreated = new Date();
        this.dateChanged = new Date();
    }

    public BaseEntity(Long id) {
        this.dateCreated = new Date();
        this.dateChanged = new Date();
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // getter and setter for the recordStatus
    @Enumerated(EnumType.ORDINAL)
    @Column(
            name = "record_status",
            nullable = false
    )
    public RecordStatus getRecordStatus() {
        return this.recordStatus;
    }
    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }


    @ManyToOne
    @JoinColumn(
            name = "created_by",
            nullable = true
    )
    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User userAccount) {
        this.createdBy = userAccount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "date_created",
            nullable = true
    )
    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @ManyToOne
    @JoinColumn(
            name = "changed_by",
            nullable = true
    )
    public User getChangedBy() {
        return this.changedBy;
    }

    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "date_changed",
            nullable = true
    )
    public Date getDateChanged() {
        return this.dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }
}
