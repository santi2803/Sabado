import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Polinomio_10_Abril {

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
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
    Polinomio objeto1, objeto2, objeto3;
    float co, x;
    int ex;

    public Lamina() {
        setLayout(new adminComponentes());
        objeto1 = new Polinomio();
        objeto2 = new Polinomio();
        objeto3 = new Polinomio();
        boton1 = new JButton("Ingresar polinomio uno");
        boton2 = new JButton("Mostrar Polinomio uno");
        boton3 = new JButton("Evaluar Polinomio uno");
        boton4 = new JButton("Ingresar polinomio dos");
        boton5 = new JButton("Mostrar polinomio dos");
        boton6 = new JButton("Evaluar polinomio dos");
        boton7 = new JButton("Sumar polinomios");
        boton8 = new JButton("Derivar polinomio");

        boton1.addActionListener(new GestionOpciones());
        boton2.addActionListener(new GestionOpciones());
        boton3.addActionListener(new GestionOpciones());
        boton4.addActionListener(new GestionOpciones());
        boton5.addActionListener(new GestionOpciones());
        boton6.addActionListener(new GestionOpciones());
        boton7.addActionListener(new GestionOpciones());
        boton8.addActionListener(new GestionOpciones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        add(boton7);
        add(boton8);
    }

    private class GestionOpciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton1) {
                co = Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
                ex = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
                if (objeto1.ingresarTermino(co, ex))
                    JOptionPane.showMessageDialog(null, "Polinomio uno:\n" + objeto1.mostrarPolinomio());
                else
                    JOptionPane.showMessageDialog(null, "El termino ya existe");
            } else if (e.getSource() == boton2) {
                JOptionPane.showMessageDialog(null, "Polinomio uno:\n" + objeto1.mostrarPolinomio());
            } else if (e.getSource() == boton3) {
                x = Float.parseFloat(JOptionPane.showInputDialog("Ingrese valor x"));
                JOptionPane.showMessageDialog(null, "Polinomio uno:\n" + objeto1.mostrarPolinomio()
                        + "\nEl valor del polinomio uno para " + x + " es: " + objeto1.evaluarPolinomio(x));
            } else if (e.getSource() == boton4) {
                co = Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
                ex = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
                if (objeto2.ingresarTermino(co, ex))
                    JOptionPane.showMessageDialog(null, "Polinomio dos:\n" + objeto2.mostrarPolinomio());
                else
                    JOptionPane.showMessageDialog(null, "El termino ya existe");
            } else if (e.getSource() == boton5) {
                JOptionPane.showMessageDialog(null, "Polinomio dos:\n" + objeto2.mostrarPolinomio());
            } else if (e.getSource() == boton6) {
                x = Float.parseFloat(JOptionPane.showInputDialog("Ingrese valor x"));
                JOptionPane.showMessageDialog(null, "Polinomio dos:\n" + objeto2.mostrarPolinomio()
                        + "\nEl valor del polinomio dosuno para " + x + " es: " + objeto2.evaluarPolinomio(x));
            } else if (e.getSource() == boton7) {
                objeto1.sumarPolinomios(objeto2, objeto3);
                JOptionPane.showMessageDialog(null,
                        "Polinomio uno:\n" + objeto1.mostrarPolinomio() + "\nPolinomio dos\n"
                                + objeto2.mostrarPolinomio() + "\nSuma polinomios\n" + objeto3.mostrarPolinomio());
            } else if (e.getSource() == boton8) {
                objeto1.derivadaPol(objeto1);
            }
        }

    }

}

class adminComponentes implements LayoutManager {
    int x, y = 30;

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
            c.setBounds(x - 300, y, 190, 25);
            x += 200;
            if (contador % 3 == 0) {
                x = d / 2;
                y += 50;
            }
        }

    }
}
