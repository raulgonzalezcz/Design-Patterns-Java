package proyectofinalpatrones;
import java.util.Stack;
/**
 * Clase que pertenece a Memento
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
public class Caretaker
{
    Stack<Memento> stack = new Stack<Memento>();
    //--------------

    public void keep(Originator anOriginator)
    {
        Memento aMemento;
        //
        aMemento = anOriginator.createMemento();
        stack.push(aMemento);
    }//end start

    public void undo(Originator anOriginator)
    {
        Memento aMemento;
        //
        aMemento = stack.pop();
        anOriginator.setMemento(aMemento);
    }//end undo
    
    //Añado método para saber la cantidad de elementos en el stack...
    public int getElements(){
        return stack.size();
    }

}//end class Caretaker