package proyectofinalpatrones;
/**
 * Clase que pertenece a Decorator
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
import javax.swing.JTextArea;

public class ConcreteComponent extends Component
{
    public void operation(JTextArea textArea)
    {
        System.out.println("Ejecutando operación sobre el área de texto");
    }//end operation

}//end class ConcreteComponent
