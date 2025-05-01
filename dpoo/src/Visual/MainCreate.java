package Visual;

import Main.App;

import javax.swing.*;
import java.awt.*;

public class MainCreate extends JPanel {
    private JButton btnCreateStore;
    private JButton btnPrintStore;
    private Screen parent;

    public MainCreate(Screen parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Botón Create Store
        btnCreateStore = new JButton("Create Store");
        btnCreateStore.setPreferredSize(new Dimension(150, 40));
        btnCreateStore.addActionListener(e -> parent.showCreateStorePanel());

        // Botón Print Store (inicialmente invisible)
        btnPrintStore = new JButton("Print Store");
        btnPrintStore.setPreferredSize(new Dimension(150, 40));
        btnPrintStore.setVisible(false);
        btnPrintStore.addActionListener(e -> showStoreInfo());

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnCreateStore, gbc);

        gbc.gridy = 1;
        add(btnPrintStore, gbc);
    }

    public void updateButtonVisibility() {
        btnPrintStore.setVisible(App.store != null);
    }

    private void showStoreInfo() {
        if (App.store != null) {
            String message = "Información de la Tienda:\n\n" +
                    "Nombre: " + App.store.getName() + "\n" +
                    "Dirección: " + App.store.getAddress() + "\n" +
                    "Teléfono: " + App.store.getPhone();
            JOptionPane.showMessageDialog(this, message, "Datos de la Tienda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}