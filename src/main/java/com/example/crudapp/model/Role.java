package com.example.crudapp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Role extends BaseEntity{
    private String name;
    private String description;
    private Set<Permission> permissions;
    private Set<User> users;

    public Role() {
    }
    public Role(String name, String description, Set<Permission> permissions, Set<User> users) {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
        this.users = users;
    }

    @Column(
            name = "role_name",
            nullable = false
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(
            name = "description",
            nullable = false
    )
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "role_permissions",
            joinColumns = {@JoinColumn(
                    name = "role_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "permission_id"
            )}
    )
    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(
            mappedBy = "roles"
    )
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
