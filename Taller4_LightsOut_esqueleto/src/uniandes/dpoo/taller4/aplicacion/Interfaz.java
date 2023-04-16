package uniandes.dpoo.taller4.aplicacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Interfaz extends JFrame implements ActionListener {

    private Container container;
    private JLabel nombreLabel = this.crearLabel("");
    private JLabel edadLabel = this.crearLabel("");
    private JLabel emailLabel = this.crearLabel("");
    private int dificultad = 3;
    private int cantidad_celdas = 5;
    private Tablero2D tableroDelJuego=new Tablero2D(cantidad_celdas,dificultad);

    private Color azulPrincipal = new Color(43, 136, 224);


    public Interfaz() {
        setTitle("LightsOut");
        setSize(710, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel botonesOpciones= new PanelOpciones(azulPrincipal, Color.WHITE,this);
        JPanel botonesConfiguracion=  new PanelConfiguracion(azulPrincipal, this);
        JPanel PanelInformacion = new PanelInformacion();
        crearNuevoTablero();
        container.add(botonesOpciones,BorderLayout.EAST);
        container.add(botonesConfiguracion,BorderLayout.NORTH);
        container.add(PanelInformacion,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
    }

    public void setDificultad(int dificultad){
        this.dificultad=dificultad;
    }

    public void setTamaño(int tamaño){
        this.cantidad_celdas=tamaño;
    }


    public void crearNuevoTablero(){
        container.remove(tableroDelJuego);
        tableroDelJuego=new Tablero2D(cantidad_celdas,dificultad);
        container.add(tableroDelJuego,BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
        

    }

    public void reiniciarTablero(){
        
        tableroDelJuego.getTablero().reiniciar();
        container.revalidate();
        container.repaint();
    }













    public JLabel crearLabel(String texto){
        JLabel label = new JLabel(texto);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Llenar")) {
            JTextField nombre = new JTextField();
            JTextField edad = new JTextField();
            JTextField email = new JTextField();

            final JComponent[] formulario = new JComponent[] {
                new JLabel("Nombre"),
                nombre,
                new JLabel("Edad"),
                edad,
                new JLabel("Email"),
                email
            };
            int resultado = JOptionPane.showConfirmDialog(this, formulario, "Llenar formulario", JOptionPane.OK_CANCEL_OPTION);
            if (resultado == JOptionPane.OK_OPTION && (nombre.getText().equals("") || edad.getText().equals("") || email.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, new JLabel("Tienes que completar todos tus datos."), "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (resultado == JOptionPane.CANCEL_OPTION){}
            else {
                this.nombreLabel.setText(nombre.getText());
                this.edadLabel.setText(edad.getText());
                this.emailLabel.setText(email.getText());
            }
        } else if (comando.equals("Guardar")) {
            if (nombreLabel.getText().equals("") || edadLabel.getText().equals("") || emailLabel.getText().equals("")) {
                JOptionPane.showMessageDialog(this, new JLabel("Tienes que llenar el formulario."), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                guardarDatosEnDisco(nombreLabel.getText(), edadLabel.getText(), emailLabel.getText());
                JOptionPane.showMessageDialog(this, new JLabel("Datos guardados correctamente."), "Guardar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, new JLabel("Error al guardar los datos."), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (comando.equals("Cargar")) {
            try {
                cargarDatosDeDisco();
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, new JLabel("Error al cargar los datos."), "Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, new JLabel("Datos cargados correctamente."), "Cargar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void guardarDatosEnDisco(String nombre, String edad, String email) throws IOException {
        FileWriter fw = new FileWriter("formulario.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(nombre + "," + edad + "," + email);
        bw.close();
    }

    public void cargarDatosDeDisco() throws IOException {
        File file = new File("formulario.csv");
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");

        while (sc.hasNext()) {
            this.nombreLabel.setText(sc.next());
            this.edadLabel.setText(sc.next());
            this.emailLabel.setText(sc.next());
        }

        sc.close();
    }
}