package Visual;

import Main.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainContent extends JPanel {
    private JButton btnManual;
    private JButton btnAutomatico;
    private Screen parent;

    public MainContent(Screen parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Botón Manual
        btnManual = new JButton("Manual");
        btnManual.setPreferredSize(new Dimension(150, 40));
        btnManual.addActionListener(e -> parent.showMainCreate());

        // Botón Automático
        btnAutomatico = new JButton("Automático");
        btnAutomatico.setPreferredSize(new Dimension(150, 40));
        btnAutomatico.addActionListener(e -> {
            // Lógica para modo automático (pendiente)
            JOptionPane.showMessageDialog(this, "Modo automático en desarrollo");
        });

        // Posicionamiento
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnManual, gbc);

        gbc.gridy = 1;
        add(btnAutomatico, gbc);
    }
}