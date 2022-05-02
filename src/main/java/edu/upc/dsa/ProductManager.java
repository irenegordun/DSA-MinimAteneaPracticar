package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.List;

public interface ProductManager {
    public List<Producto> listaPedidosPorPrecio();
    //listado de productos ascendentememente por precio

    public void realizarPedido (String idUser, Pedido pedido);
    //Realizar un pedido por parte de un usuario

    public Pedido servirPedido();
    //Servir pedidos. Se sirve por orden de llegada

    public List<Pedido> listaPedidosUsuario(String userId);
    //listado de pedidos de un usaurio que ya hayan sido realizados

    public List<Producto> listaProductosDescendiente();
    //Listado de productos ordenado descendientemente por numero de ventas

    //extres
    public void addUser (String id);

    public List<Producto> getProductoByName(String name);
    public void addProductoToList (Producto producto);
    public void clear();

}
