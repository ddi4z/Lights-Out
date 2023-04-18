package uniandes.dpoo.taller4.aplicacion;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
public class CustomWidget {
    private static Font fuentePrincipal = new Font("Arial", Font.PLAIN , 14);
    private static Font fuentePrincipalNegrilla = new Font("Arial", Font.BOLD , 14);


    public static JLabel crearNuevoTexto(String texto, Color color){
        JLabel nuevoTexto = new JLabel(texto);
        nuevoTexto.setForeground(color);
        nuevoTexto.setFont(fuentePrincipalNegrilla);
        return nuevoTexto;
    }

    public static JRadioButton nuevoBotonRadio(String texto, Color background, Color colorTexto){
        JRadioButton nuevoBotonRadio = new JRadioButton(texto);
        nuevoBotonRadio.setForeground(colorTexto);
        nuevoBotonRadio.setBackground(background);
        nuevoBotonRadio.setFont(fuentePrincipal);
        return nuevoBotonRadio;
    }
}
