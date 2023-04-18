package uniandes.dpoo.taller4.aplicacion;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.Collection;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class InterfazTop extends JDialog {
    public InterfazTop(Collection<RegistroTop10> registros){
        String[] elementos = new String[registros.size()];
        int i=0;
        for (RegistroTop10 registro : registros){
            elementos[i] = registro.toString();
            i++;
        }
        JList<String> lista = new JList<String>(elementos);
        JScrollPane scrollPane = new JScrollPane(lista);
        add(scrollPane);
        setSize(400, 650);
        setVisible(true);
    }

}
