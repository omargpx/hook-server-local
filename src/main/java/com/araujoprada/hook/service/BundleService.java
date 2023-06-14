package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Bundle;

import java.time.LocalDate;
import java.util.List;

public interface BundleService {
    List<Bundle> getAll();
    Bundle getById(int id);
    Bundle save(Bundle bundle);

    //filter
    List<Bundle> getBundlesByDate(LocalDate init, LocalDate end);
}
