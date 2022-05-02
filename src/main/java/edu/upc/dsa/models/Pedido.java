package edu.upc.dsa.models;

import java.util.*;

public class Pedido {
    //atributs
    private List<Producto> Listaproductos = new ArrayList<>();
    private User user;
    private String idPedido;
    private String idUser;
    private HashMap <Integer,String> listaProductos = null; //Pedido amb cantitat i producte

    //constructor
    public Pedido(){}

    public Pedido(User user, String idPedido) {
        this.user = user;
        this.idPedido = idPedido;
    }

    //getters i setters
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getIdPedido() {  return idPedido;   }

    public void setIdPedido(String idPedido) { this.idPedido = idPedido;}

    public String getIdUser() {  return idUser;   }

    public void setIdUser(String idUser) {  this.idUser = idUser;}

    public List<Producto> getListaproductos() {  return Listaproductos;}

    public void setListaproductos(List<Producto> listaproductos) {Listaproductos = listaproductos;}
}
