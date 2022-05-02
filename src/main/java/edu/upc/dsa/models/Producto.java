package edu.upc.dsa.models;

public class Producto {
    //atributs
    private String nombre;
    private String idProducto;
    private int precio;
    private int numVentas; //numero de ventas

    //constructor

    public Producto(String nombre, String idProducto, int precio) {
        this.nombre = nombre;
        this.idProducto = idProducto;
        this.precio = precio;
    }
    //getters i setters
    public String getNombre() {return nombre;   }

    public void setNombre(String nombre){this.nombre = nombre;}

    public String getIdProducto() {return idProducto;}

    public void setIdProducto(String idProducto) {this.idProducto = idProducto;}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public int getNumVentas() {return numVentas;}

    public void setNumVentas(int numVentas) {this.numVentas = numVentas;}
}
