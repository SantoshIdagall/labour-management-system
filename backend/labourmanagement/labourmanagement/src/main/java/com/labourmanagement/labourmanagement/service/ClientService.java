package com.labourmanagement.labourmanagement.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.labourmanagement.labourmanagement.entity.Client;


@Repository
public interface ClientService {

    Client register(Client client);
    List<Client> getAll();
    Client update(Long id, Client client);
    Client getById(Long id);
    boolean delete(Long id);   // NEW
    void deleteAll();          // NEW
}
