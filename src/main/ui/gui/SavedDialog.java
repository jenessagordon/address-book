package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a dialog that says the address book has been saved
public class SavedDialog extends JDialog implements ActionListener {

    // EFFECTS: creates a dialog that tells the user their address book has been saved
    public SavedDialog(JFrame parent) {
        super(parent);

        JLabel gotItLabel = new JLabel("Your address book "
                + "was saved successfully.");
        JButton okButton = new JButton("OK");
        okButton.setSize(50, 50);
        okButton.addActionListener(this);

        this.setSize(300, 200);
        this.setLayout(new GridLayout(2, 1));
        this.add(gotItLabel);
        this.add(okButton);
        this.setModal(true);
        this.setVisible(true);
    }

    // EFFECTS: closes 'this'
    @Override
    public void actionPerformed(ActionEvent e) {
        SavedDialog.this.dispose();
    }
}
