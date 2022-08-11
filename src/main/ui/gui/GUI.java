package ui.gui;

import model.Contact;
import model.EventLog;
import model.exception.LogException;
import ui.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Represents a GUI for an address book that allows for data persistence
//TODO remove code duplication, improve readability
public class GUI extends UI implements ActionListener {
    private JLabel addContactLabel;
    private JLabel addContactEmptyLabel;
    private JLabel fullNameLabel;
    private JLabel addressLabel;
    private JLabel phoneNumLabel;
    private JLabel emailLabel;
    private JLabel birthdayLabel;
    private JLabel dateAddedLabel;
    private JLabel locationMetLabel;
    private JLabel categoryLabel;
    private JTextField fullNameAddTextField;
    private JTextField addressAddTextField;
    private JTextField phoneNumAddTextField;
    private JTextField emailAddTextField;
    private JTextField birthdayAddTextField;
    private JTextField dateAddedAddTextField;
    private JTextField locationMetAddTextField;
    private JTextField categoryAddTextField;
    private JLabel addContactButtonLabel;
    private JButton addContactButton;

    private JLabel deleteContactLabel;
    private JLabel fullNameDeleteLabel;
    private JButton loadButton;
    private JButton saveButton;

    private JTextField fullNameDeleteTextField;

    private JPanel addContactPanel;
    private JPanel deleteContactLoadSavePanel;

    private JTextArea viewPanelTextArea;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JFrame addressBookWindow;

    // EFFECTS: constructs the window in which the address book is displayed
    public GUI() {
        makeLeftPanel();
        makeRightPanel();
        makeAddressBookWindow();
    }

    // MODIFIES: this
    // EFFECTS: makes the left panel for adding a new contact, deleting a contact, loading & saving address book
    private void makeLeftPanel() {
        makeAddContactPanel();
        makeDeleteContactLoadSavePanel();

        leftPanel = new JPanel(new GridLayout(2, 1));
        leftPanel.add(addContactPanel);
        leftPanel.add(deleteContactLoadSavePanel);
    }

    // MODIFIES: this
    // EFFECTS: makes panel for adding a new contact
    private void makeAddContactPanel() {
        makeAddContactComponents();
        addContactPanel = new JPanel(new GridLayout(10, 2));
        addAddContactPanelComponents();
    }

    // MODIFIES: this
    // EFFECTS: makes components to be added to addContactPanel
    private void makeAddContactComponents() {
        addContactLabel = new JLabel("ADD CONTACT");
        addContactEmptyLabel = new JLabel();
        fullNameLabel = new JLabel("Full name:");
        fullNameAddTextField = new JTextField();
        addressLabel = new JLabel("Address:");
        addressAddTextField = new JTextField();
        phoneNumLabel = new JLabel("Phone number:");
        phoneNumAddTextField = new JTextField();
        emailLabel = new JLabel("Email:");
        emailAddTextField = new JTextField();
        birthdayLabel = new JLabel("Birthday:");
        birthdayAddTextField = new JTextField();
        dateAddedLabel = new JLabel("Today's date:");
        dateAddedAddTextField = new JTextField();
        locationMetLabel = new JLabel("Location met:");
        locationMetAddTextField = new JTextField();
        categoryLabel = new JLabel("Category that is one of 'family', 'friend', 'work', or 'other':");
        categoryAddTextField = new JTextField();
        addContactButton = new JButton("Add Contact");
        addContactButton.addActionListener(this);
        addContactButtonLabel = new JLabel();
    }

    // MODIFIES: this
    // EFFECTS: adds components to addContactPanel
    private void addAddContactPanelComponents() {
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
    }

    // MODIFIES: this
    // EFFECTS: makes panel for deleting a contact, loading & saving address book
    private void makeDeleteContactLoadSavePanel() {
        deleteContactLabel = new JLabel("DELETE CONTACT");
        fullNameDeleteLabel = new JLabel("Delete the contact with the following full name: (press enter)");
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
        loadButton = new JButton("Load Address Book");
        saveButton = new JButton("Save Address Book");
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        deleteContactLoadSavePanel = new JPanel(new GridLayout(10, 2));
        addDeleteContactLoadSavePanelComponents();
    }

    // MODIFIES: this
    // EFFECTS: adds components for loading & saving address book to deleteContactLoadSavePanel
    private void addDeleteContactLoadSavePanelComponents() {
        deleteContactLoadSavePanel.add(deleteContactLabel);
        deleteContactLoadSavePanel.add(fullNameDeleteLabel);
        deleteContactLoadSavePanel.add(fullNameDeleteTextField);
        deleteContactLoadSavePanel.add(new JLabel());
        deleteContactLoadSavePanel.add(new JLabel());
        deleteContactLoadSavePanel.add(new JLabel());
        deleteContactLoadSavePanel.add(new JLabel());
        deleteContactLoadSavePanel.add(new JLabel());
        deleteContactLoadSavePanel.add(loadButton);
        deleteContactLoadSavePanel.add(saveButton);
    }

    // MODIFIES: this
    // EFFECTS: makes the right panel for viewing all contacts in contactList
    private void makeRightPanel() {
        viewPanelTextArea = new JTextArea();
        viewPanelTextArea.setEditable(false);
        viewPanelTextArea.setLineWrap(true);
        viewPanelTextArea.setSize(1200, 1500);
        viewPanelTextArea.setText("YOUR CONTACT LIST (ordered by category):");
        JScrollPane viewScrollPane = new JScrollPane();
        viewScrollPane.setViewportView(viewPanelTextArea);

        rightPanel = new JPanel(new GridLayout(1, 1));
        rightPanel.add(viewScrollPane);
    }

    // MODIFIES: this
    // EFFECTS: fills viewPanel with text representing what is currently in contactList
    private void updateViewPanel() {
        String viewPanelTextAreaText = "YOUR CONTACT LIST (ordered by category):" + "\n" + listOfContactsToString();
        viewPanelTextArea.setText(viewPanelTextAreaText);
    }

    // MODIFIES: this
    // EFFECTS: makes window within application is run
    private void makeAddressBookWindow() {
        addressBookWindow = new JFrame("Address Book");
        addressBookWindow.setLayout(new GridLayout(1, 2));
        addressBookWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addressBookWindow.setSize(2880, 1800);
        addressBookWindow.add(leftPanel);
        addressBookWindow.add(rightPanel);
        addressBookWindow.setVisible(true);
        addressBookWindow.addWindowListener(new WindowAdapter() {

            // MODIFIES: this
            // EFFECTS: prints all event logs to the console and exits the program
            @Override
            public void windowClosing(WindowEvent we) {
                UI ui = new UI();
                try {
                    ui.printLog(EventLog.getInstance());
                } catch (LogException e) {
                    System.out.println("LogException thrown.");
                }
                System.exit(0);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: if addContactButton pressed, adds contact to contactList from given JTextField values and updates
    //             viewPanel
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