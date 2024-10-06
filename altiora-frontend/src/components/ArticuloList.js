import React from "react";

const ArticuloList = ({ articulos }) => {
    return (
        <div className="container">
            <h3>Lista de Artículos</h3>
            <table className="table table-dark table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Nombre</th>
                        <th>Precio Unitario</th>
                    </tr>
                </thead>
                <tbody>
                    {articulos.map((articulo) => (
                        <tr key={articulo.id}>
                            <td>{articulo.id}</td>
                            <td>{articulo.name}</td>
                            <td>${articulo.unitaryPrice}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ArticuloList;
