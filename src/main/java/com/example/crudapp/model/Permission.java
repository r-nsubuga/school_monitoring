package com.example.crudapp.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "permissions"
)
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Permission extends BaseEntity {

    private String name;
    private String description;

    public Permission() {
    }

    public Permission(String description) {
        this.description = description;
    }

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(
            name = "permission_name"
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(
            name = "description"
    )
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
