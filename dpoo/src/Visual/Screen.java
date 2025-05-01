package Visual;

import javax.swing.*;

public class Screen extends JFrame {
    private JPanel contentPane;
    private MainContent mainContent;
    private MainCreate mainCreate;
    private CreateStorePanel createStorePanel;

    public Screen() {
        setTitle("Gestión de Tienda");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel(new java.awt.CardLayout());
        setContentPane(contentPane);

        // Inicializar paneles
        mainContent = new MainContent(this);
        mainCreate = new MainCreate(this);
        createStorePanel = new CreateStorePanel(this);

        // Registrar paneles
        contentPane.add(mainContent, "MainContent");
        contentPane.add(mainCreate, "MainCreate");
        contentPane.add(createStorePanel, "CreateStorePanel");

        showMainContent();
        setLocationRelativeTo(null);
    }

    public void showMainContent() {
        ((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "MainContent");
    }

    public void showMainCreate() {
        ((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "MainCreate");
        mainCreate.updateButtonVisibility();
    }

    public void showCreateStorePanel() {
        ((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "CreateStorePanel");
    }
}