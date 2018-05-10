package proyectofinalpatrones;
/**
 * Clase abstracta que pertenece a Decorator
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
import javax.swing.JTextArea;

public abstract class Component
{

    String id;
    //--------------

    public abstract void operation(JTextArea textArea);

    public void add()
    {
        //a definir en las clases concretas
    }//end add

    public void remove(Component unComponente)
    {
        //a definir en las clases concretas
    }//end remove


    public Component getChild(int posicion)
    {
        return null;
    }//end getChild

}//end Component

