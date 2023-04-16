
package uniandes.dpoo.taller4.aplicacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;


import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class PanelConfiguracion extends JPanel {

    public PanelConfiguracion(Color color){
        setLayout(new FlowLayout());
        setBackground(color);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(CustomWidget.crearNuevoTexto("Tamaño:",Color.white));



        JComboBox<String> opcionesTamaño = new JComboBox<String>();
        opcionesTamaño.addItem("3x3");
        opcionesTamaño.addItem("5x5");
        opcionesTamaño.addItem("7x7");
        opcionesTamaño.setSelectedItem("5x5");
    
        add(opcionesTamaño);
    
        add(CustomWidget.crearNuevoTexto("Dificultad:",Color.white));
        ButtonGroup group = new ButtonGroup();
        JRadioButton radioButton1 = CustomWidget.nuevoBotonRadio("Fácil",color,Color.white);
        JRadioButton radioButton2 = CustomWidget.nuevoBotonRadio("Medio",color,Color.white);
        JRadioButton radioButton3 = CustomWidget.nuevoBotonRadio("Difícil",color,Color.white);
    
        radioButton1.setSelected(true);
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        add(radioButton1);
        add(radioButton2);
        add(radioButton3);

    }


}




