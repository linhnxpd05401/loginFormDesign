package com.fpoly.swing.table;

import com.fpoly.models.ModelStudent;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);
}
