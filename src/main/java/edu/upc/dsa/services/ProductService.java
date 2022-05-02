package edu.upc.dsa.services;

import edu.upc.dsa.ProductManager;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Api(value = "/Product", description = "Endpoint to Product Service")
@Path("/Pedidos")
public class ProductService {
    private ProductManager manager;//- Listado de productos ordenado (ascendentemente) por precio
    @GET
    @ApiOperation(value = "get products by price", notes = "ascendente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
    })
    @Path("/listaProductosPorPrecio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsPorPrecio() {

        List<Producto> products = this.manager.listaPedidosPorPrecio();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(products) {};
        return Response.status(201).entity(entity).build();
    }
    //- Listado de productos ordenado (descendentemente) por número de ventas
    @ApiOperation(value = "get products by sold", notes = "descendente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
    })
    @Path("/listaProductosPorVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsPorVentas() {
        List<Producto> products = this.manager.listaProductosDescendiente();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(products) {};
        return Response.status(201).entity(entity).build();
    }
    //- Realizar un pedido por parte de un usuario identificado
    //- Servir un pedido en orden de llegadas
    //- Listado de pedidos de un usuario que ya hayan sido realizados


}

