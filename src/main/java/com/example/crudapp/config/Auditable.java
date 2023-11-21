package com.example.crudapp.config;


import com.example.crudapp.model.User;

import java.io.Serializable;
import java.util.Date;

public interface Auditable extends Serializable {
    User getCreatedBy();

    void setCreatedBy(User var1);

    Date getDateCreated();

    void setDateCreated(Date var1);

    User getChangedBy();

    void setChangedBy(User var1);

    Date getDateChanged();

    void setDateChanged(Date var1);
}
