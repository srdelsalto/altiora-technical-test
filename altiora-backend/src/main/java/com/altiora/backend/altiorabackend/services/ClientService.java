package com.altiora.backend.altiorabackend.services;

import com.altiora.backend.altiorabackend.application.dtos.request.CreateClientRequest;
import com.altiora.backend.altiorabackend.application.dtos.request.UpdateClientRequest;
import com.altiora.backend.altiorabackend.application.dtos.response.CreateUpdateClientResponse;
import com.altiora.backend.altiorabackend.application.dtos.response.DeleteClientResponse;
import com.altiora.backend.altiorabackend.domain.entities.Client;
import com.altiora.backend.altiorabackend.infraestructure.repositories.client.ClientRepository;
import com.altiora.backend.altiorabackend.infraestructure.repositories.jpa.ClientRepositoryJPA;
import com.altiora.backend.altiorabackend.models.ClientModel;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientRepositoryJPA clientRepositoryJPA;

    public CreateUpdateClientResponse createClient(CreateClientRequest client) {
        CreateUpdateClientResponse createClientResponse = new CreateUpdateClientResponse();
        createClientResponse.setClient(clientRepository.save(client));
        createClientResponse.setMessage("Client created");

        return createClientResponse;
    }

    public List<Client> listClients(){
        return clientRepository.findAll();
    }

    public ClientModel getClient(Long id){
        return clientRepositoryJPA.getClientById(id);
    }

    public DeleteClientResponse deleteClient(Long id) {
        DeleteClientResponse deleteClientResponse = new DeleteClientResponse();

        try {
            clientRepository.delete(id);
            deleteClientResponse.setMessage("Client deleted");
        } catch (Exception e) {
            deleteClientResponse.setMessage("Client not deleted");

        }
        return deleteClientResponse;
    }

    public CreateUpdateClientResponse updateClient(UpdateClientRequest client) {
        CreateUpdateClientResponse updateClientResponse = new CreateUpdateClientResponse();
        String message = "";

        try {
            Client updatedClient = clientRepository.update(client);
            updateClientResponse.setClient(updatedClient);

            message = "Client updated";
        } catch (Exception e) {
            message = "Error en update cliente!";
        } finally {
            updateClientResponse.setMessage(message);
        }

        return updateClientResponse;
    }
}
