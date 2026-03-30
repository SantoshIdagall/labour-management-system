package com.labourmanagement.labourmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourmanagement.labourmanagement.entity.Labour;
import com.labourmanagement.labourmanagement.repository.LabourRepository;
import com.labourmanagement.labourmanagement.service.LabourService;

@Service
public class LabourServiceImpl implements LabourService {

    @Autowired
    private LabourRepository repo;

    public Labour register(Labour labour) {
        return repo.save(labour);
    }

    public List<Labour> getAll() {
        return repo.findAll();
    }

    public Labour getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    @Override
    public Labour update(Long id, Labour newData) {
        Labour existing = repo.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setFullname(newData.getFullname());
        existing.setAge(newData.getAge());
        existing.setLocation(newData.getLocation());
        existing.setSkills(newData.getSkills());
        existing.setContactNumber(newData.getContactNumber());

        return repo.save(existing);
    }

	@Override
	public void deleteall() {
		repo.deleteAll();
		
	}
}
