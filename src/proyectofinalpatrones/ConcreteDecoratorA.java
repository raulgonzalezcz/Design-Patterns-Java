package proyectofinalpatrones;
/**
 * Clase que pertenece a Decorator
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
import javax.swing.*;
import java.awt.Color;

/*
 * Adiciona responsabilidades (atributo) a un Component
 */
public class ConcreteDecoratorA extends Decorator
{
    //atributo adicional (color adicional)
    public String addedState;
    //-----------------------

    public ConcreteDecoratorA(Component aComponent, String aColor)
    {
        super(aComponent);
        addedState = aColor;
    }//end ConcreteDecoratorA

    //Establecer el color especificado por el usuario al texto
    public void operation(JTextArea textArea)
    {
        component.operation(textArea);
        Color color = Color.decode(addedState);
        textArea.setForeground(color); 
    }//end operation


}//end ConcreteDecoratorA
