package proyectofinalpatrones;
/**
 * @author Raúl González <raul.gonzalezcz@udlap.mx> ID: 151211
 * @version 1.0
 * @since 22/04/17
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Para el desarrollo de esta aplicación, decidí emplear los siguientes patrones:
 * 1. Factory Method. Con este patrón es posible tener una fábrica (elemento único de creacion de objetos diversos) que permite al usuario dibujar 5 números naturales (1,2,3,4,5)
 * 2. Decorator. Una vez que hemos dibujado un número, podemos decorarlo agregando un atributo (color especificado en hexadecimal) o comportamiento (desplazamiento del número a la izquierda)
 * 3. Memento. Cada vez que hagamos algún cambio, guardamos el estado interno del objeto para que el usuario pueda regresar a dicho estado posteriormente.
 */

public class MainPatrones extends JFrame implements ActionListener{
    //Elementos para Factory Method
    Product miProducto;
    //Elementos para Decorator
    Component component;
    //Elementos para Memento
    Originator object;
    Caretaker caretakerObject;
    //Elementos de la interfaz
    int FRAME_WIDTH;
    int FRAME_HEIGHT;
    int FRAME_X_ORIGIN;
    int FRAME_Y_ORIGIN;
    JMenu dibujarNumero, decorar;
    JMenuItem deshacer;
    JTextArea textArea;
    String space;
    MainPatrones view;
    String texto;
    String colorState;
    Font font;
    int size;
    String estilo;
        
    public static void main(String[] args) {
        MainPatrones frame = new MainPatrones();
        frame.setVisible(true);
    }
    
    //Constructor
    public MainPatrones(){
        this.FRAME_Y_ORIGIN = 250;
        this.FRAME_X_ORIGIN = 150;
        this.FRAME_HEIGHT = 400;
        this.FRAME_WIDTH = 600;
        this.space = "       ";
        Container contentPane;
        JMenuItem item;
        //Establecemos las propiedades de la interfaz
        setTitle     ("Fábrica de números");
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        contentPane = getContentPane( );
        contentPane.setLayout(null);
        contentPane.setBackground( Color.white );
        //Menú para Factory Method
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        dibujarNumero = new JMenu("Dibujar un número");	
	item = new JMenuItem("1");
	item.addActionListener( this );
        dibujarNumero.add(item);
        item = new JMenuItem("2");
	item.addActionListener( this );
        dibujarNumero.add(item);
        item = new JMenuItem("3");
	item.addActionListener( this );
        dibujarNumero.add(item);
        item = new JMenuItem("4");
	item.addActionListener( this );
        dibujarNumero.add(item);
        item = new JMenuItem("5");
	item.addActionListener( this );
        dibujarNumero.add(item);		
	menuBar.add(dibujarNumero);
        //Menú para Decorator
        decorar = new JMenu("Agregar características");
	item = new JMenuItem("Agregar color");
	item.addActionListener( this );
        decorar.add(item);
        item = new JMenuItem("Desplazar a la izquierda");
	item.addActionListener( this );
        decorar.add(item);
        decorar.setVisible(false);
        menuBar.add(decorar);
        //Item para Memento        
        deshacer = new JMenuItem("Deshacer");
	deshacer.addActionListener( this );
        deshacer.setVisible(false);
        menuBar.add(deshacer);
        //Item para Información acerca del autor
        item = new JMenuItem("Información del autor");
	item.addActionListener( this );
        menuBar.add(item);        
        //Personalizamos nuestra interfaz
        textArea = new JTextArea();
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setBounds(0, 0, FRAME_WIDTH-5, FRAME_HEIGHT-51);
        contentPane.add(scrollText);
        textArea.setEditable(false);
        font = textArea.getFont();
        size = font.getSize() + 80;    //Agrandamos el tamaño del texto dentro de la ventana
        estilo = font.getFontName();    //Estilo del texto dentro de la ventana
        textArea.setFont(new Font(estilo, Font.PLAIN, size));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Al inicio establecemos el componente para Memento:
        object = new Originator();
        caretakerObject = new Caretaker();
        texto = space + "Dibuja\n"+space+"un\n"+space+ "número";
        textArea.setText(texto);  //Texto
        colorState = convertColorToHexadecimal(textArea.getForeground());   //Color
        object.state= texto+","+colorState;
    }
    
    //Este método permite actualizar las opciones que debe presentar la interfaz, así como limpiarla
    public void actualizarView(){
        //El menú de Memento se actualiza con base en la cantidad de estados guardados en el stack
        if(caretakerObject.getElements() >0){
            deshacer.setVisible(true);
        }else{
            deshacer.setVisible(false);
        }
        //El menú para Decorator se actualiza con base en el texto que contiene miProducto
        if(miProducto.getData().equals("1") || miProducto.getData().equals("2") || miProducto.getData().equals("3") || miProducto.getData().equals("4") || miProducto.getData().equals("5")){
            decorar.setVisible(true);
        }else{
            decorar.setVisible(false);
        }
        //Limpiamos el área del texto
        textArea.setText("");
    }
    
    //Método que lleva a cabo una acción al hacer clic sobre una de las opciones de la interfaz
    public void actionPerformed(ActionEvent event){
    	String  menuName, inputColor, nombreDelProducto;
        menuName = event.getActionCommand();
        //Mostramos la información del autor cuando se selecciona la opción "Información"
        if(menuName.equals("Información del autor")){
            JFrame frame = new JFrame("Frame para mostrar datos personales");
        	JOptionPane.showMessageDialog(frame,
                "Raúl González Cruz \nID: 151211 \nIngeniería en Sistemas Computacionales \nUniversidad de las Américas Puebla",
                "Acerca del autor",
                JOptionPane.INFORMATION_MESSAGE);
        }
        //Se dibuja el número seleccionado...
        else if (menuName.equals("1")){
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            // se decide que producto se requiere...
            nombreDelProducto = menuName;
            // se obtiene el producto
            miProducto = Creator.anOperation(nombreDelProducto);
            // se usa el producto
            actualizarView();
            texto = space+miProducto.getData();
            textArea.append(texto);
            object.state= texto+","+colorState;
        }
        else if (menuName.equals("2")){
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            // se decide que producto se requiere...
            nombreDelProducto = menuName;
            // se obtiene el producto
            miProducto = Creator.anOperation(nombreDelProducto);
            // se usa el producto
            actualizarView();
            texto = space+miProducto.getData();
            textArea.append(texto);
            object.state= texto+","+colorState;
        }
        else if (menuName.equals("3")){
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            // se decide que producto se requiere...
            nombreDelProducto = menuName;
            // se obtiene el producto
            miProducto = Creator.anOperation(nombreDelProducto);
            // se usa el producto
            actualizarView();
            texto = space+miProducto.getData();
            textArea.append(texto);
            object.state= texto+","+colorState;
        }
        else if (menuName.equals("4")){
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            // se decide que producto se requiere...
            nombreDelProducto = menuName;
            // se obtiene el producto
            miProducto = Creator.anOperation(nombreDelProducto);
            // se usa el producto
            actualizarView();
            texto = space+miProducto.getData();
            textArea.append(texto);
            object.state= texto+","+colorState;
        }
        else if (menuName.equals("5")){
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            // se decide que producto se requiere...
            nombreDelProducto = menuName;
            // se obtiene el producto
            miProducto = Creator.anOperation(nombreDelProducto);
            // se usa el producto
            actualizarView();
            texto = space+miProducto.getData();
            textArea.append(texto);
            object.state= texto+","+colorState;
        }
        //Con base en la opción seleccionada de Decorator...
        else if (menuName.equals("Agregar color")){
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            //Mostramos mensaje para agregar color...
            inputColor = JOptionPane.showInputDialog(null,"Ingresa el color en hexadecimal:");
            component = new ConcreteComponent();
            // adicionamos el atributo
            component = new ConcreteDecoratorA(component, inputColor);
            component.operation(textArea);
            //Se ha modificado el estado interno del objeto..
            colorState = convertColorToHexadecimal(textArea.getForeground());
            object.state= texto+","+colorState;
        }
        else if (menuName.equals("Desplazar a la izquierda")) {
            //Guardamos el estado actual...
            caretakerObject.keep(object);
            component = new ConcreteComponent();
            //adicionamos el método
            component = new ConcreteDecoratorB(component);
            component.operation(textArea);
            //Se ha modificado el estado interno del objeto..
            texto = textArea.getText();
            object.state= texto+","+colorState;
            
        }
        else if (menuName.equals("Deshacer")){
            if(caretakerObject.getElements()>0){
                caretakerObject.undo(object);
                actualizarView();
                //Obtenemos el estado interno obtenido de un Memento
                String[] partes = object.state.split(",");
                texto = partes[0];  //Texto
                colorState = partes[1]; //Color
                textArea.append(texto);
                textArea.setForeground(Color.decode(colorState));
            }
            else actualizarView();
        }
    }
    
    /* Función que nos permite transformar un color en formato hexadecimal. El parámetro que recibe es un objeto Color
    y devuelve una cadena de caracteres del valor hexadecimal del objeto recibido*/
    public static String convertColorToHexadecimal(Color color){
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        if(hex.length() < 6) 
        {
            if(hex.length()==5)
                hex = "0" + hex;
            if(hex.length()==4)
                hex = "00" + hex;
            if(hex.length()==3)
                hex = "000" + hex;
        }
        hex = "#" + hex;
        return hex;
    }
}
