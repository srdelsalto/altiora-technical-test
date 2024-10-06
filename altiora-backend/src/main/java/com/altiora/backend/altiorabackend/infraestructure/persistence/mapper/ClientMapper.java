package com.altiora.backend.altiorabackend.infraestructure.persistence.mapper;

import com.altiora.backend.altiorabackend.domain.entities.Client;
import com.altiora.backend.altiorabackend.models.ClientModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    Client toClient(ClientModel client);
    List<Client> toClients(List<ClientModel> clients);
    @InheritInverseConfiguration
    ClientModel toClientModel(Client client);
}
