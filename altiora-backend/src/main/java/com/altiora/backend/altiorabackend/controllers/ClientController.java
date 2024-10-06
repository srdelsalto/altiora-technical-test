package com.altiora.backend.altiorabackend.controllers;

import com.altiora.backend.altiorabackend.application.dtos.request.CreateClientRequest;
import com.altiora.backend.altiorabackend.application.dtos.request.UpdateClientRequest;
import com.altiora.backend.altiorabackend.application.dtos.response.CreateUpdateClientResponse;
import com.altiora.backend.altiorabackend.application.dtos.response.DeleteClientResponse;
import com.altiora.backend.altiorabackend.domain.entities.Client;
import com.altiora.backend.altiorabackend.models.ClientModel;
import com.altiora.backend.altiorabackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.listClients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateUpdateClientResponse> createClient(@RequestBody CreateClientRequest client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CreateUpdateClientResponse> updateClient(@RequestBody UpdateClientRequest client) {
        return new ResponseEntity<>(clientService.updateClient(client), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DeleteClientResponse> deleteClientById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
    }
}
