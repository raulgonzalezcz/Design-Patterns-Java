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

/*
 * Adiciona responsabilidades (metodo) a un Component
 */
public class ConcreteDecoratorB extends Decorator
{
    public ConcreteDecoratorB(Component aComponent)
    {
        super(aComponent);
    }//end ConcreteDecoratorB


    public void operation(JTextArea textArea)
    {
        component.operation(textArea);
        String textoAntiguo = textArea.getText();
        String textoDesplazado =textoAntiguo.substring(1) +textoAntiguo.substring(0, 1);
        textArea.setText( textoDesplazado );
        addedBehavior(textArea.getText());
    }//end operation


    public void addedBehavior(String cadena)
    {
        System.out.println("Se da desplazado el texto a " + cadena);
    }//end addedBehavior

}//end ConcreteDecoratorB
