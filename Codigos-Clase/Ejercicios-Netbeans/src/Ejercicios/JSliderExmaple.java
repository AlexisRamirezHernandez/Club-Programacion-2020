/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 * Un componente que permite al usuario seleccionar gráficamente un valor
 * deslizando una perilla dentro de un intervalo acotado. La perilla siempre se
 * coloca en los puntos que coinciden con los valores enteros dentro del
 * intervalo especificado. El control deslizante puede mostrar las marcas
 * principales y las marcas menores entre las principales. El número de valores
 * entre las marcas de verificación se controla con setMajorTickSpacingy
 * setMinorTickSpacing. La pintura de las marcas está controlada por
 * setPaintTicks.
 *
 * Los controles deslizantes también pueden imprimir etiquetas de texto a
 * intervalos regulares (o en ubicaciones arbitrarias) a lo largo de la pista
 * del control deslizante. La pintura de etiquetas está controlada por
 * setLabelTabley setPaintLabels
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderExmaple extends JFrame {

    private JLabel eR, eG, eB, titulo, valorR, valorG, valorB;
    private JPanel panel_colores, panel_norte, panel_oeste, panel_sur;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    private JSlider Red, Green, Blue;

    public JSliderExmaple() {
        setSize(800, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        panel_norte = new JPanel();
        panel_norte.setSize(700, 20);
        titulo = new JLabel("Paleta de Colores");

        panel_norte.add(titulo);

        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        panel_oeste = new JPanel();
        panel_oeste.setLayout(gbl);

        valorR = new JLabel();
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel_oeste.add(valorR, gbc);

        valorG = new JLabel();
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel_oeste.add(valorG, gbc);

        valorB = new JLabel();
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel_oeste.add(valorB, gbc);

        eR = new JLabel("Rojo");

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel_oeste.add(eR, gbc);

        eG = new JLabel("Verde");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel_oeste.add(eG, gbc);
        eB = new JLabel("Azul");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel_oeste.add(eB, gbc);

        Green = new JSlider(0, 255, 1);
        gbc.gridx = 1;
        gbc.gridy = 2;
        Green.setPaintLabels(true);
        panel_oeste.add(Green, gbc);

        Red = new JSlider(0, 255, 1);
        gbc.gridx = 1;
        gbc.gridy = 1;
        Red.setMinorTickSpacing(2);
        Red.setMajorTickSpacing(255);
        Red.setPaintLabels(true);
        panel_oeste.add(Red, gbc);

        Blue = new JSlider(0, 255, 1);
        gbc.gridx = 1;
        gbc.gridy = 3;
        Blue.setPaintLabels(true);

        panel_oeste.add(Blue, gbc);

        panel_colores = new JPanel();
        panel_colores.setSize(150, 100);
        panel_colores.setBackground(Color.WHITE);

        panel_sur = new JPanel();
        panel_sur.setSize(700, 300);
        JPanel panel_este = new JPanel();

        add(panel_norte, BorderLayout.NORTH);
        add(panel_oeste, BorderLayout.WEST);
        add(panel_sur, BorderLayout.SOUTH);
        add(panel_colores, BorderLayout.CENTER);
        add(panel_este, BorderLayout.EAST);

        Red.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cambiarColor();
                valorR.setText(Red.getValue() + "");
            }
        });
        Blue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cambiarColor();
                valorB.setText(Blue.getValue() + "");
            }
        });
        Green.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cambiarColor();
                valorG.setText(Green.getValue() + "");
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void cambiarColor() {
        int r, g, b;
        r = Red.getValue();
        g = Green.getValue();
        b = Blue.getValue();
        panel_colores.setBackground(new Color(r, g, b));
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        new JSliderExmaple();

    }
}
