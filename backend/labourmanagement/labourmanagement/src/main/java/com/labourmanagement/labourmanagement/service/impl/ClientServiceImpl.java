package com.labourmanagement.labourmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourmanagement.labourmanagement.entity.Client;
import com.labourmanagement.labourmanagement.repository.ClientRepository;
import com.labourmanagement.labourmanagement.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repo;

    public Client register(Client client) {
        return repo.save(client);
    }

    public List<Client> getAll() {
        return repo.findAll();
    }

    public Client getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Client update(Long id, Client newData) {
        Client existing = repo.findById(id).orElse(null);

        if (existing == null) 
            return null;

        existing.setFullName(newData.getFullName());
        existing.setLocation(newData.getLocation());
        existing.setPhoneNumber(newData.getPhoneNumber());

        return repo.save(existing);
    }

    @Override
    public boolean delete(Long id) {
        if (!repo.existsById(id)) 
            return false;

        repo.deleteById(id);
        return true;
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

}

