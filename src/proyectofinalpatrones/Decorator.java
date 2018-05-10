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

/*
 * mantiene referencia a un objeto de tipo Component
 * y define que sus clases concretas implementen 
 * el metodo basico correspondiente
 * de acuerdo a la interface Componente
 */
public abstract class Decorator extends Component
{
    Component component;
    //-------------------

    public Decorator(Component aComponent)
    {
        component = aComponent;
    }//end constructor

    public void operation(JTextArea textArea)
    {
        component.operation(textArea);
    }//end operation

}//end class Decorator
