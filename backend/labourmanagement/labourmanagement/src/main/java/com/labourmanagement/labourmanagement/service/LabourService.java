package com.labourmanagement.labourmanagement.service;

import java.util.List;

import com.labourmanagement.labourmanagement.entity.Labour;

public interface LabourService {
    Labour register(Labour labour);
    List<Labour> getAll();
    Labour getById(Long id);
    Labour update(Long id, Labour labour);
    void delete(Long id);
    void deleteall();
}
