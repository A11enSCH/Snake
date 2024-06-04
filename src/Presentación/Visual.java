package Presentación;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visual extends JFrame {
    private JPanel pElementos;
    private JPanel pFondo;
    private PCuadricula pCuadricula;
    private JButton bNuevoJuego;
    private JLabel lMejor_puntaje;
    private JLabel lPuntos;
    private PCuadricula2 pCuadricula2;

    public Visual() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setTitle("Snake");
        this.setLayout(new BorderLayout());

        // Panel de elementos
        this.bNuevoJuego = new JButton("Nuevo Juego");
        this.lMejor_puntaje = new JLabel("Mejor puntaje: 0");
        this.lPuntos = new JLabel("Puntos: 0");
        this.pElementos = new JPanel();
        this.pElementos.setLayout(new GridLayout(1, 3, 10, 10));
        this.pElementos.add(this.bNuevoJuego);
        this.pElementos.add(this.lMejor_puntaje);
        this.pElementos.add(this.lPuntos);
        this.bNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoJuego();
            }
        });

        this.add(this.pElementos, BorderLayout.NORTH);

        // Panel de la cuadricula del juego
        this.pCuadricula2 = new PCuadricula2(550, 16);
        this.pCuadricula = new PCuadricula(550, 16);

        // Panel de fondo
        this.pFondo = new JPanel(null);
        this.pFondo.add(this.pCuadricula2);
        this.pFondo.add(this.pCuadricula);

        this.pCuadricula2.setBounds(10, 10, 600, 600);
        this.pCuadricula2.setOpaque(false);
        this.pCuadricula.setBounds(10, 10, 600, 600);

        this.add(pFondo, BorderLayout.CENTER);

        this.setVisible(true);

        // Actualizacion
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    pCuadricula2.actualizar();
                    lPuntos.setText("Puntos: " + pCuadricula2.getPuntos());
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void nuevoJuego() {
        this.pCuadricula2 = new PCuadricula2(550, 16);
        this.pFondo.removeAll();
        this.pFondo.add(this.pCuadricula2);
        this.pFondo.add(this.pCuadricula);

        this.pCuadricula2.setBounds(10, 10, 600, 600);
        this.pCuadricula2.setOpaque(false);
        this.pCuadricula.setBounds(10, 10, 600, 600);
        
        lMejor_puntaje.setText("Mejor puntaje: " + pCuadricula2.getBpuntos());

        this.pFondo.revalidate();
        this.pFondo.repaint();
        
        this.pCuadricula2.requestFocusInWindow(); // Asegurarse de que el nuevo juego tenga el foco del teclado
    }

    public static void main(String[] args) {
        new Visual();
    }
}
