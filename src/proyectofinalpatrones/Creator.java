package proyectofinalpatrones;
/**
 * Belongs to Factory Method.
 * Declares the factoryMethod, 
 * which returns an object of type Product.
 * Creator may also define a default implementation 
 * of the factory method 
 * that returns a default ConcreteProduct object. 
 * It may call the factory method to create a Product object.
 *
 * Creator relies on its subclasses to define the factory method 
 * so that it returns an instance 
 * of the appropriate ConcreteProduct.
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
public abstract class Creator
{
    public abstract Product factoryMethod();
    // anOperation refers to creating a product
    // A class wants its subclasses to specify the objects it creates.
    public static Product anOperation(String productType)
    {
        Product aProduct;
        Creator concreteCreator;
        //We create the product based on...
        if (productType.equals("1"))
        {
            concreteCreator = new ConcreteCreator1();
            aProduct = concreteCreator.factoryMethod();
            return aProduct;
        }//end if
        else
            if (productType.equals("2"))
            {
                concreteCreator = new ConcreteCreator2();
                aProduct = concreteCreator.factoryMethod();
                return aProduct;
            }//end if
        else
            if (productType.equals("3"))
            {
                concreteCreator = new ConcreteCreator3();
                aProduct = concreteCreator.factoryMethod();
                return aProduct;
            }//end if
        else
            if (productType.equals("4"))
            {
                concreteCreator = new ConcreteCreator4();
                aProduct = concreteCreator.factoryMethod();
                return aProduct;
            }//end if
        else
            if (productType.equals("5"))
            {
                concreteCreator = new ConcreteCreator5();
                aProduct = concreteCreator.factoryMethod();
                return aProduct;
            }//end if
            else
                return null;
            //end else
        //end else
    }//end anOperation
}//end class Creator
