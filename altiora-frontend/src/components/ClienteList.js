import React from "react";

const ClienteList = ({ clientes, onEditar, onEliminar }) => {
    return (
        <div className="container">
            <h3>Lista de Clientes</h3>
            <table className="table table-dark table-striped-columns table-hover">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {clientes.map((cliente) => (
                        <tr key={cliente.id}>
                            <td>{cliente.firstName}</td>
                            <td>{cliente.lastName}</td>
                            <td><button className="btn btn-primary " onClick={() => onEditar(cliente)}>Editar</button></td>
                            <td><button className="btn btn-danger" onClick={() => onEliminar(cliente.id)}>Eliminar</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ClienteList;
