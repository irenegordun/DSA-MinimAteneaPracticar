package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.*;
import org.apache.log4j.Logger;

public class ProductManagerImpl implements ProductManager {


    //contenidors
    Queue<Pedido> cuaPedidosPendientes= new LinkedList<Pedido>();
    LinkedList<Producto> listaproductos = new LinkedList<>();
    LinkedList<User> listausuarios = new LinkedList<>();


    static final Logger logger = Logger.getLogger(ProductManagerImpl.class.getName());
    private static ProductManagerImpl manager;

    //Singleton
    public static ProductManagerImpl getInstance() {
        if (manager == null) {
            manager = new ProductManagerImpl();
        }
        return manager;
    }
    private ProductManagerImpl(){}


    @Override//lista productos precio ascendiente
    public List<Producto> listaPedidosPorPrecio() {
        LinkedList<Producto> listaProductosPrecio = new LinkedList<>();
        Collections.sort(listaProductosPrecio, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getPrecio() - o2.getPrecio();
            }
        });
        logger.info("Lista productos ordenada ascendientemente por precio");
        return listaProductosPrecio;
    }

    @Override//realizar pedidos
    public void realizarPedido(String idUser, Pedido pedido) {
        this.cuaPedidosPendientes.add(pedido);
        logger.info("Pedido realizado con exito");
    }

    @Override //servir pedido por orden de llegada
    public Pedido servirPedido() {
        Pedido pedido = this.cuaPedidosPendientes.poll();//agafem 1r de la cua (contrari:pop)
        String idUser =pedido.getIdUser();
        User user = null;
        for(User u:this.listausuarios){
            if(u.getIdUser().equals(idUser)){
                user = u;
            }
        }
        user.getListaPedidos().add(pedido);
        //quedaria augmentar num ventas per producte
        return pedido;
    }

    @Override //lista pedidos de usuario que han sido realizados
    public List<Pedido> listaPedidosUsuario(String userId) {
        User user = null;
        LinkedList<Pedido> llista = new LinkedList<>();
        for(User u:this.listausuarios){
            if(u.getIdUser().equals(userId)){
                user = u;
            }
        }
        return llista;
    }

    @Override //lista de productos descendientemente por numero de ventas
    public List<Producto> listaProductosDescendiente() {
        LinkedList<Producto> listaProductosNumVentas = new LinkedList<>();
        Collections.sort(listaProductosNumVentas, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getNumVentas() - o2.getNumVentas();
            }
        });
        logger.info("Lista productos ordenada ascendientemente por precio");
        return listaProductosNumVentas;
    }

    @Override
    public void addUser(String id) {
        User user = null;
        for(User u:this.listausuarios){
            if(u.getIdUser().equals(id)){
                user = u;
            }
        }
        this.listausuarios.add(user);
    }


    @Override
    public List<Producto> getProductoByName(String name) {
        return this.listaproductos;
    }

    @Override
    public void addProductoToList(Producto producto) {
        this.listaproductos.add(producto);
    }

    @Override
    public void clear() {
        this.listausuarios.clear();
        this.listaproductos.clear();
    }
}

