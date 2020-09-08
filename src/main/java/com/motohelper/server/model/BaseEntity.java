package com.motohelper.server.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp created = Timestamp.valueOf(LocalDateTime.now());

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp updated = Timestamp.valueOf(LocalDateTime.now());

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    public BaseEntity() {
    }

    public BaseEntity(Long id, Timestamp created, Timestamp updated, Status status) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
