package edu.upc.dsa;

import org.apache.log4j.Logger;

import edu.upc.dsa.models.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductManagerTest {
    private static Logger logger = Logger.getLogger(ProductManagerTest.class);
    ProductManager manager = ProductManagerImpl.getInstance();

    @Before
    public void SetUp(){
        //creeem productes
        Producto p1 = new Producto("Platano", "1", 2);
        Producto p2 = new Producto("Fresa", "2", 5);

        //inicialitzem clients
        User us1 = new User ("Irene",1);
        User us2 = new User ("Luis", 2);

        manager.addUser("1");
        manager.addUser("2");
    }

    @After
    public void tearDown () { manager.clear();}

    public void servirPrductTest() { //sercir productos por orden de llegada
        manager.servirPedido();
        logger.info("Lista usuario después de servir: " + manager.listaPedidosUsuario("1").toString());
    }



}

