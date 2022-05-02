package edu.upc.dsa.models;

import java.util.List;

public class User {
    //atributs
    private String nombre;
    private String idUser;
    private List<Pedido> listaPedidos = null;

    //constructor

    public User(String nombre, Integer id) {
        this.nombre = nombre;
        this.idUser = idUser;
    }

    //getters i setters

    public String getNombre() {return nombre;    }

    public void setNombre(String nombre) {this.nombre = nombre;    }

    public String getIdUser() {return idUser;    }

    public void setIdUser(String idUser) {this.idUser = idUser;    }

    public List<Pedido> getListaPedidos() {return listaPedidos;    }

    public void setListaPedidos(List<Pedido> listaPedidos) {this.listaPedidos = listaPedidos; }
}
