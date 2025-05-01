package Visual;

import Visual.Overrides.*;
import Logic.Class.Store;
import Main.App;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStorePanel extends JPanel {
    private AlphabeticTextField txtName;
    private AlphabeticTextField txtAddress;
    private NumericTextField txtPhone;
    private JButton btnSave;
    private JButton btnBack;
    private Screen parent;

    public CreateStorePanel(Screen parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Campo: Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtName = new AlphabeticTextField(20);
        add(txtName, gbc);

        // Campo: Address
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        txtAddress = new AlphabeticTextField(20);
        add(txtAddress, gbc);

        // Campo: Phone
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        txtPhone = new NumericTextField(20);
        add(txtPhone, gbc);

        // Botón "Save" (inicialmente invisible)
        btnSave = new JButton("Guardar");
        btnSave.setVisible(false);
        btnSave.addActionListener(e -> saveStore());

        // Botón "Back"
        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> parent.showMainCreate());

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.add(btnBack);
        buttonPanel.add(btnSave);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);

        // Listener para habilitar el botón Guardar
        DocumentListener docListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            private void checkFields() {
                btnSave.setVisible(!txtName.getText().isEmpty() &&
                        !txtAddress.getText().isEmpty() &&
                        !txtPhone.getText().isEmpty());
            }
        };

        txtName.getDocument().addDocumentListener(docListener);
        txtAddress.getDocument().addDocumentListener(docListener);
        txtPhone.getDocument().addDocumentListener(docListener);
    }

    private void saveStore() {
        App.store = new Store(
                txtName.getText(),
                txtAddress.getText(),
                txtPhone.getText());
        parent.showMainContent();
    }
}