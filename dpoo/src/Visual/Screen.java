package Visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    private JButton btnCreateStore;

    public Screen() {
        // Configuración básica de la ventana
        setTitle("Mi Aplicación");
        System.out.println("2222222222222222222");
        setSize(400, 300); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usamos Absolute Layout (null)

        // Crear botón "Create Store"
        btnCreateStore = new JButton("Create Store");
        btnCreateStore.setBounds(150, 100, 120, 30); // (x, y, width, height)

        // Acción del botón
        btnCreateStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botón presionado: Crear tienda");
            }
        });


        // Añadir botón a la ventana
        add(btnCreateStore);

        // Centrar ventana en la pantalla
        setLocationRelativeTo(null);
    }
}