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

3. The ability to delete a contact from the address book
4. The ability to view a list of all the user's contacts
5. The ability to save a contact list by pressing "Save Address Book" and 
   retrieve it by pressing "Load Address Book". (The "Load Address Book" 
   button loads whatever contact list was most recently saved to the program.)

This application also supports event logging to the console. For example, 
performing the set of actions: open application > click "Add Contact" button > 
click "Add Contact" button > focus on delete contact text field > type desired 
contact name > press Enter > click "Add Contact" button > type desired 
contact name > press Enter > close application
results in the following information being printed to the console:

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

# User Stories
- As a user, I want to be able to add one or more new contact(s) to my address book.
- As a user, I want to be able to delete a contact from my address book.
- As a user, I want to be able to view a list of all of my contacts.
- As a user, I want to be able to separate my contacts into friends, family, work contacts, and other contacts.
- As a user, I want to be able to save my entire address book to a file.
- As a user, I want to be able to load my address book from the file and resume exactly where I left off at
  some earlier time.

# Refactoring Possibilities

- I could find a way to connect SavedDialog and GUI because SavedDialog is used exclusively in GUI. I made a
  package model.gui for this purpose, but the connection between the two cannot easily be seen from the UML class diagram.
  GUI cannot extend any other classes and SavedDialog cannot be turned into an interface because it has a non-abstract
  method, so this challenge might be overcome by defining the SavedDialog class inside of GUI. Nesting like this also
  improves abstraction and makes my code more readable.

- EventLog and the class and interface that are connected with it have no connection with LogPrinter in the diagram,
  despite the fact that EventLog and LogPrinter are conceptually related. If EventLog were more connected with LogPrinter,
  it would also be more clear that ContactList uses methods from EventLog/Event. I could perhaps connect the two by
  making an interface that they could both implement. You could argue, however, that because some details from EventLog
  are, by their static nature, meant to be accessible globally, it does not make sense to restrict EventLog to being
  connected with certain classes/interfaces. While that is true, there are many methods in other classes
  that are public (and thus accessible globally), that one still tries to group with other
  classes/abstract classes/interfaces.

- JsonReader, and JsonWriter are not directly connected with each other, despite the fact that they both involve
  data persistence and are "inverses" of one another. I could create a superclass that JsonReader and JsonWriter would
  extend which would contain the JSON_STORE, jsonWriter, and jsonReader fields contained in UI. This would make more
  conceptual sense and would ensure that more data persistence-related behaviour is separated from UI, increasing the
  degree to which UI satisfies the SRP. Furthermore, it would ensure that all of these fields are in the same place,
  making it less likely that someone would accidentally use a different path for the source and destination (even though
  I want the source and destination to be the same).

- In GUI.java, some code duplication could be removed and the readability 
  could be improved.