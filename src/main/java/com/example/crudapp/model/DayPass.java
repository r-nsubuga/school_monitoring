package com.example.crudapp.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name="DayPass")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DayPass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reason;


    private int parent_approval;
    private int res_parent_approval;
    private int guard_sign_off;

    @ManyToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getParent_approval() {
        return parent_approval;
    }

    public void setParent_approval(int parent_approval) {
        this.parent_approval = parent_approval;
    }

    public int getRes_parent_approval() {
        return res_parent_approval;
    }

    public void setRes_parent_approval(int res_parent_approval) {
        this.res_parent_approval = res_parent_approval;
    }

    public int getGuard_sign_off() {
        return guard_sign_off;
    }

    public void setGuard_sign_off(int guard_sign_off) {
        this.guard_sign_off = guard_sign_off;
    }
}
