package ui.gui;

import model.Contact;
import ui.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// Represents a GUI for an address book that allows for data persistence
public class GUI extends UI implements ActionListener {
    private JTextArea viewPanelTextArea;
    private JFrame addressBookWindow;
    private JTextField fullNameAddTextField;
    private JTextField addressAddTextField;
    private JTextField phoneNumAddTextField;
    private JTextField emailAddTextField;
    private JTextField birthdayAddTextField;
    private JTextField dateAddedAddTextField;
    private JTextField locationMetAddTextField;
    private JTextField categoryAddTextField;
    private JTextField fullNameDeleteTextField;
    JPanel leftPanel;
    JPanel rightPanel;

    // EFFECTS: constructs the window in which the address book is displayed
    public GUI() {
        makeLeftPanel();
        makeRightPanel();
        makeAddressBookWindow();
    }

    private void makeLeftPanel() {
        // components related to leftPanel
        // addContactPanel
        JLabel addContactLabel = new JLabel("ADD CONTACT");
        JLabel addContactEmptyLabel = new JLabel();
        JLabel fullNameLabel = new JLabel("Full name:");
        fullNameAddTextField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        addressAddTextField = new JTextField();
        JLabel phoneNumLabel = new JLabel("Phone number:");
        phoneNumAddTextField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailAddTextField = new JTextField();
        JLabel birthdayLabel = new JLabel("Birthday:");
        birthdayAddTextField = new JTextField();
        JLabel dateAddedLabel = new JLabel("Today's date:");
        dateAddedAddTextField = new JTextField();
        JLabel locationMetLabel = new JLabel("Location met:");
        locationMetAddTextField = new JTextField();
        JLabel categoryLabel = new JLabel("Category that is one of 'family', 'friend', 'work', or 'other':");
        categoryAddTextField = new JTextField();
        JButton addContactButton = new JButton("Add Contact");
        addContactButton.addActionListener(this);
        JLabel addContactButtonLabel = new JLabel();
        JPanel addContactPanel = new JPanel(new GridLayout(10, 2));
        addContactPanel.add(addContactLabel);
        addContactPanel.add(addContactEmptyLabel);
        addContactPanel.add(fullNameLabel);
        addContactPanel.add(fullNameAddTextField);
        addContactPanel.add(addressLabel);
        addContactPanel.add(addressAddTextField);
        addContactPanel.add(phoneNumLabel);
        addContactPanel.add(phoneNumAddTextField);
        addContactPanel.add(emailLabel);
        addContactPanel.add(emailAddTextField);
        addContactPanel.add(birthdayLabel);
        addContactPanel.add(birthdayAddTextField);
        addContactPanel.add(dateAddedLabel);
        addContactPanel.add(dateAddedAddTextField);
        addContactPanel.add(locationMetLabel);
        addContactPanel.add(locationMetAddTextField);
        addContactPanel.add(categoryLabel);
        addContactPanel.add(categoryAddTextField);
        addContactPanel.add(addContactButtonLabel);
        addContactPanel.add(addContactButton);
        //TODO remove addContactFieldsPanel code duplication

        // deleteContactPanel
        JLabel deleteContactLabel = new JLabel("DELETE CONTACT");
        JLabel fullNameDeleteLabel = new JLabel("Delete the contact with the following full name: (press enter)");
        fullNameDeleteTextField = new JTextField();
        fullNameDeleteTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    contactList.removeContact(fullNameDeleteTextField.getText());
                    updateViewPanel();
                }
            }
        });
        JButton loadButton = new JButton("Load Address Book");
        JButton saveButton = new JButton("Save Address Book");
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        JPanel deleteContactPanel = new JPanel(new GridLayout(10, 2));
        deleteContactPanel.add(deleteContactLabel);
        deleteContactPanel.add(fullNameDeleteLabel);
        deleteContactPanel.add(fullNameDeleteTextField);
        deleteContactPanel.add(new JLabel());
        deleteContactPanel.add(new JLabel());
        deleteContactPanel.add(new JLabel());
        deleteContactPanel.add(new JLabel());
        deleteContactPanel.add(new JLabel());
        deleteContactPanel.add(loadButton);
        deleteContactPanel.add(saveButton);

        leftPanel = new JPanel(new GridLayout(2, 1));
        leftPanel.setBackground(Color.red);
        //TODO ^ remove after implementation complete
        leftPanel.add(addContactPanel);
        leftPanel.add(deleteContactPanel);
    }

    private void makeRightPanel() {
        // viewPanel
        viewPanelTextArea = new JTextArea();
        viewPanelTextArea.setEditable(false);
        viewPanelTextArea.setLineWrap(true);
        viewPanelTextArea.setSize(1200, 1500);
        viewPanelTextArea.setText("YOUR CONTACT LIST:");
        JScrollPane viewPanel = new JScrollPane();
        viewPanel.setViewportView(viewPanelTextArea);

        // rightPanel
        rightPanel = new JPanel(new GridLayout(1, 1));
        rightPanel.setBackground(Color.blue);
        //TODO ^ remove after implementation complete
        rightPanel.add(viewPanel);
    }

    private void makeAddressBookWindow() {
        addressBookWindow = new JFrame("Address Book");
        addressBookWindow.setLayout(new GridLayout(1, 2));
        addressBookWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addressBookWindow.setSize(2880, 1800);
        addressBookWindow.setVisible(true);
        addressBookWindow.add(leftPanel);
        addressBookWindow.add(rightPanel);
    }

    // EFFECTS: fills viewPanel with text representing what is currently in contactList
    private void updateViewPanel() {
        String viewPanelTextAreaText = "YOUR CONTACT LIST:" + "\n" + listOfContactsToString();
        viewPanelTextArea.setText(viewPanelTextAreaText);
    }

    // MODIFIES: this
    // EFFECTS: if addContactButton pressed, adds contact to contactList from given JTextField values and updates
    //          viewPanel
    //          if loadButton pressed, displays data from JSON_STORE on viewPanel
    //          if saveButton pressed, writes data from contactList to JSON_STORE and displays new SavedDialog
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Add Contact")) {
            String fullNameTextFieldValue = fullNameAddTextField.getText();
            String addressTextFieldValue = addressAddTextField.getText();
            String phoneNumTextFieldValue = phoneNumAddTextField.getText();
            String emailTextFieldValue = emailAddTextField.getText();
            String birthdayTextFieldValue = birthdayAddTextField.getText();
            String dateAddedTextFieldValue = dateAddedAddTextField.getText();
            String locationMetTextFieldValue = locationMetAddTextField.getText();
            Contact.Category categoryTextFieldValue = stringToCategory(categoryAddTextField.getText());
            contactList.addContact(fullNameTextFieldValue, addressTextFieldValue, phoneNumTextFieldValue,
                    emailTextFieldValue, birthdayTextFieldValue, dateAddedTextFieldValue,
                    locationMetTextFieldValue, categoryTextFieldValue);
            updateViewPanel();
        }
        if (actionCommand.equals("Load Address Book")) {
            loadContactList();
            updateViewPanel();
        }
        if (actionCommand.equals("Save Address Book")) {
            saveContactList();
            new SavedDialog(addressBookWindow);
        }
    }

    // starts the application
    public static void main(String[] args) {
        new GUI();
    }
}