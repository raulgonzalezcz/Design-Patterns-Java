package proyectofinalpatrones;
/**
 * Clase que pertenece a Memento
 *
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 *
 */
public class Memento
{
    String state;
    //Constructor de la clase
    public Memento(String aState)
    {
        state = aState;
    }//end constructor


    public String getState()
    {
        return state;
    }//end getState


    public void setState(String aState)
    {
        state = aState;
    }//end setState

}//end class Memento
