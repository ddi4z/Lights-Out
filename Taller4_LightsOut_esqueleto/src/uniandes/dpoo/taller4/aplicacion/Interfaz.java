package uniandes.dpoo.taller4.aplicacion;
import javax.swing.*;
import uniandes.dpoo.taller4.modelo.Top10;
import java.awt.*;
import java.io.File;
class Interfaz extends JFrame {

    private Container container;
    private int dificultad = 3;
    private int cantidad_celdas = 5;
    private Tablero2D tableroDelJuego=new Tablero2D(cantidad_celdas,dificultad,this);
    private PanelInformacion PanelInformacion = new PanelInformacion();
    private Color azulPrincipal = new Color(43, 136, 224);
    private String nombre = "UNK";
    private Top10 top10= new Top10();


    public Interfaz() {
        setTitle("LightsOut");
        setSize(710, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(new BorderLayout());
        PanelOpciones botonesOpciones= new PanelOpciones(azulPrincipal, Color.WHITE,this);
        PanelConfiguracion botonesConfiguracion=  new PanelConfiguracion(azulPrincipal, this);
        crearNuevoTablero();
        container.add(botonesOpciones,BorderLayout.EAST);
        container.add(botonesConfiguracion,BorderLayout.NORTH);
        container.add(PanelInformacion,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        top10.cargarRecords(new File("Taller4_LightsOut_esqueleto/data/top10.csv"));
    }

    public void setDificultad(int dificultad){
        this.dificultad=dificultad;
    }

    public void setTamaño(int tamaño){
        this.cantidad_celdas=tamaño;
    }


    public void crearNuevoTablero(){
        container.remove(tableroDelJuego);
        tableroDelJuego=new Tablero2D(cantidad_celdas,dificultad,this);
        container.add(tableroDelJuego,BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public PanelInformacion getInfo(){
        return this.PanelInformacion;
    }


    public void reiniciarTablero(){
        tableroDelJuego.getTablero().reiniciar();
        container.revalidate();
        container.repaint();
    }

    public void setNombre(){
        this.nombre = PanelInformacion.getNombreField();
    }

    public String getNombre(){
        return this.nombre;
    }


    public Top10 getTop(){
        return this.top10;
    }

}