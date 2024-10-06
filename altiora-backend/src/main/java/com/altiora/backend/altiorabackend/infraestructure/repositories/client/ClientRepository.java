package com.altiora.backend.altiorabackend.infraestructure.repositories.client;

import com.altiora.backend.altiorabackend.application.dtos.request.CreateClientRequest;
import com.altiora.backend.altiorabackend.application.dtos.request.UpdateClientRequest;
import com.altiora.backend.altiorabackend.domain.entities.Client;
import com.altiora.backend.altiorabackend.domain.interfaces.IClientRepository;
import com.altiora.backend.altiorabackend.infraestructure.persistence.mapper.ClientMapper;
import com.altiora.backend.altiorabackend.infraestructure.repositories.jpa.ClientRepositoryJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepository implements IClientRepository {
    @Autowired
    private ClientRepositoryJPA clientRepositoryJPA;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    @Transactional
    public Client save(CreateClientRequest client) {
        Client newClient = new Client();
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());

        return clientMapper.toClient(clientRepositoryJPA.save(clientMapper.toClientModel(newClient)));
    }

    @Override
    public Client findById(Long id) {
        var obj = clientRepositoryJPA.findById(id).map(model -> clientMapper.toClient(model));
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return clientMapper.toClients(clientRepositoryJPA.findAll());
    }

    @Override
    public void delete(Long id) {
        clientRepositoryJPA.deleteById(id);
    }

    @Override
    @Transactional
    public Client update(UpdateClientRequest client) {
        Client clientFound = clientMapper.toClient(clientRepositoryJPA.getClientById(client.getId()));

        if (Objects.nonNull(client.getFirstName()) && !"".equalsIgnoreCase(client.getFirstName())) {
            clientFound.setFirstName(client.getFirstName());
        }
        if (Objects.nonNull(client.getLastName()) && !"".equalsIgnoreCase(client.getLastName())) {
            clientFound.setLastName(client.getLastName());
        }

        var model = clientMapper.toClientModel(clientFound);

        Client clientUpdated = clientMapper.toClient(clientRepositoryJPA.save(model));

        return clientUpdated;
    }
}