import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Prog_17_Abril {

    public static void main(String[] args) {
        Marco mimarco = new Marco();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco extends JFrame {
    public Marco() {
        setBounds(300, 400, 700, 400);
        Lamina miLamina = new Lamina();
        add(miLamina);
        setVisible(true);
    }
}

class Lamina extends JPanel {
    JButton boton1, boton2, boton3, boton4, boton5, boton6;
    ListaDobleEnlace objeto;
    int x;

    public Lamina() {
        setLayout(new adminComponentes());
        objeto = new ListaDobleEnlace();
        boton1 = new JButton("Ingresar datos");
        boton2 = new JButton("Suma datos");
        boton3 = new JButton("Retirar dato");
        boton4 = new JButton("Buscar Elemento");
        boton5 = new JButton("Eliminar Elemento");
        boton6 = new JButton("Contar Nodos");

        boton1.addActionListener(new GestionOpciones());
        boton2.addActionListener(new GestionOpciones());
        boton3.addActionListener(new GestionOpciones());
        boton4.addActionListener(new GestionOpciones());
        boton5.addActionListener(new GestionOpciones());
        boton6.addActionListener(new GestionOpciones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton6);
        /*
         * add(boton4); add(boton5);
         */ }

    private class GestionOpciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton1) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor entero"));
                objeto.ingresarDatos(x);
                JOptionPane.showMessageDialog(null, "Lista:\n" + objeto.mostrarDatos());
            } else if (e.getSource() == boton2) {
                JOptionPane.showMessageDialog(null,
                        "Lista:\n" + objeto.mostrarDatos() + "\nLa suma de los datos es: " + objeto.sumarDatos());
            } else if (e.getSource() == boton3) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor a retirar"));
                if (objeto.retirarDato(x))
                    JOptionPane.showMessageDialog(null,
                            "Lista:\n" + objeto.mostrarDatos() + "\nEl dato " + x + " se retiro de la lista");
                else
                    JOptionPane.showMessageDialog(null,
                            "Lista:\n" + objeto.mostrarDatos() + "\nEl dato " + x + " no existe en la lista");
            } else if (e.getSource() == boton6) {
                JOptionPane.showMessageDialog(null,
                            "Nodos totales:\n" + objeto.contarDatos());
            }

        }

    }
}

class adminComponentes implements LayoutManager {
    int x, y = 20;

    @Override
    public void addLayoutComponent(String string, Component cmpnt) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void removeLayoutComponent(Component cmpnt) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Dimension preferredLayoutSize(Container cntnr) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Dimension minimumLayoutSize(Container cntnr) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void layoutContainer(Container miContenedor) {
        int d = miContenedor.getWidth();
        x = d / 2;
        int contador = 0;
        int n = miContenedor.getComponentCount();
        for (int i = 0; i < n; i++) {
            contador++;
            Component c = miContenedor.getComponent(i);
            c.setBounds(x - 200, y, 160, 25);
            x += 200;
            if (contador % 2 == 0) {
                x = d / 2;
                y += 40;
            }
        }

    }
}
