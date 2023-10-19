package com.example.crudapp.forms;

public class DayPassForm {

    private String reason;

    private int parent_approval;
    private int res_parent_approval;
    private int guard_sign_off;

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
