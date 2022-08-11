# Address Book

This address book application is for users who wish to manage their contacts. 
It is unique from ordinary address books because it lets the user organize 
their contacts according to the relationship they have with each contact 
(i.e. whether the contact is a friend, family member, professional contact, 
or other.) The other, less original features that the user has access to are:
1. The ability to add one or multiple new contact(s) to the address book. Attributes for each 
contact that can be included are:
    - First name 
    - Last name 
    - Address 
    - Phone number 
    - Email
    - Birthday 
    - Date the contact is added 
    - Where the user met them

2. The ability to delete a contact from the address book
3. The ability to view a list of all the user's contacts

This project is of interest to me because I wish to explore how information can be organized in a program, how users 
can access and make changes to the information they have stored in a program, and how information can best be 
represented graphically. I anticipate that I will be able to learn the most about each of these concepts by choosing a 
project idea that is simple and easily modifiable. I have this expectation because choosing a simple project will 
enable me to focus more on the programming concepts that I am learning and less on the details of the various features I 
want to implement.

# User Stories
- As a user, I want to be able to add one or more new contact(s) to my address book.
- As a user, I want to be able to delete a contact from my address book.
- As a user, I want to be able to view a list of all of my contacts.
- As a user, I want to be able to separate my contacts into friends, family, work contacts, and other contacts.
- As a user, I want to be able to save my entire address book to a file.
- As a user, I want to be able to load my address book from the file and resume exactly where I left off at 
some earlier time.

# Instructions for Grader

- You can generate the first required event by:
  - adding the desired information to the text fields labelled "Full name:", "Address:", "Phone number:", "Email:", 
  "Birthday:", "Today's date:", "Location met:", and "Category that is one of 'family', 'friend', 'work', or 'other':", 
  then
  - clicking the button labelled "Add Contact". If enough contacts are added, a scroll bar will appear so that you can 
  still view all the contacts you've added.
- You can generate the second required event by:
  - entering the exact full name of the contact you wish to remove into the text field labelled "Delete the contact 
  with the following full name: (press enter)", then
  - pressing the Enter key on the keyboard.
- You can locate my visual component by clicking the button labelled "Save Address Book". A dialog will open which 
displays my visual component. You can close this dialog by clicking the button labelled "OK".
- You can save the state of my application by clicking the button labelled "Save Address Book".
- You can reload the state of my application by:
  - running the application from the GUI class, then
  - clicking the button labelled "Load Address Book". Note that in order to notice this button's behaviour, the loaded 
  address book needs to be different from the address book already displayed in the view scroll pane on the right side of 
  the window.

# Phase 4: Task 2
- Performing the set of actions: open application > click "Add Contact" button > click "Add Contact" button > 
focus on delete contact text field > type desired contact name > press Enter > click "Add Contact" button > 
type desired contact name > press Enter > close application
results in the following information being printed to the console

Thu Aug 11 15:48:45 PDT 2022
Contact added.

Thu Aug 11 15:48:46 PDT 2022
Contact added.

Thu Aug 11 15:48:51 PDT 2022
Name of desired contact to be deleted submitted.

Thu Aug 11 15:48:52 PDT 2022
Contact added.

Thu Aug 11 15:48:56 PDT 2022
Name of desired contact to be deleted submitted.

# Phase 4: Task 3