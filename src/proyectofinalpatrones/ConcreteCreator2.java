package proyectofinalpatrones;
/**
 * Sobreescribe el método "factory method" para regresar una instancia de un ConcreteProduct2
 * Clase que pertenece a Factory Method
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
public class ConcreteCreator2 extends Creator
{ 
    public Product factoryMethod()
    {
        Product aConcreteProduct;
        //Regresa la instancia de ConcreteProduct2
        aConcreteProduct = new ConcreteProduct2();
        return aConcreteProduct;
    }//end factoryMethod

}//end class ConcreteCreator2