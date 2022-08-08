package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavedDialog extends JDialog implements ActionListener {

    public SavedDialog(JFrame parent) {
        super(parent);

        JLabel gotItLabel = new JLabel("Got it!");
        ImageIcon smiley = new ImageIcon("smiley.png");
        JLabel smileyLabel = new JLabel();
        smileyLabel.setIcon(smiley);
        JButton okButton = new JButton("OK");
        okButton.setSize(50, 50);
        okButton.addActionListener(this);

        this.setSize(500, 500);
        this.setLayout(new GridLayout(3, 1)); //TODO improve layout
        this.add(gotItLabel);
        this.add(smileyLabel);
        this.add(okButton);
        this.setModal(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SavedDialog.this.dispose();
    }
}
