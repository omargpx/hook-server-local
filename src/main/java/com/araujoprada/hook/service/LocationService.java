package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAll();
    Location save(Location location);
    Location getById(int id);
}
