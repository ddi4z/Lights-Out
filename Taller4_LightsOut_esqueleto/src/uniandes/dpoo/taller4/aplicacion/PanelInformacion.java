package uniandes.dpoo.taller4.aplicacion;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel {
    public PanelInformacion(){
        GridLayout layout= new GridLayout(1, 4);
        layout.setHgap(10);
        layout.setVgap(10);
        setLayout(layout);
        add(CustomWidget.crearNuevoTexto("Jugadas:",Color.black));
        JTextField jugadasField = new JTextField();
        add(jugadasField);
        add(CustomWidget.crearNuevoTexto("Jugador:",Color.black));
        JTextField nombreField = new JTextField();
        add(nombreField);
    }
}