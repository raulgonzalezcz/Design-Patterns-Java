package proyectofinalpatrones;
/**
 * Clase que pertenece a Memento
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
public class Originator
{
    String state;
    //-----------

    public void setMemento(Memento m)
    {
        state = m.getState();
    }//end setMemento

    public Memento createMemento()
    {
        Memento unMemento;
        //----------------

        unMemento = new Memento(state);
        return unMemento;
    }//end createMemento

}//end class Originator
