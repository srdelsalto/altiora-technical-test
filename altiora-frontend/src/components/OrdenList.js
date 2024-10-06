import React from "react";

const OrdenList = ({ ordenes }) => {
    return (
        <div className="container">
            <h3>Lista de Órdenes</h3>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Fecha</th>
                        <th>Cliente</th>
                        <th>Artículos</th>
                    </tr>
                </thead>
                <tbody>
                    {ordenes.map((orden) => (
                        <tr key={orden.id}>
                            <td>{orden.code}</td>
                            <td>{orden.date}</td>
                            <td>
                                {orden.client.firstName} {orden.client.lastName}
                            </td>
                            <td>
                                <ul>
                                    {orden.articles.map((articulo) => (
                                        <li key={articulo.id}>
                                            {articulo.name} - ${articulo.unitaryPrice}
                                        </li>
                                    ))}
                                </ul>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default OrdenList;
