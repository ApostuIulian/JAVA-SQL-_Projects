# Polynomial Calculator

1)Project Description

  This project implements a polynomial calculator with 6 mathematical operations:
-addition
-subtraction
-multiplication
-division
-derivative
-integration

  These operations can be selected by the user and applied on the desired polynomials
with the help of the dedicated graphical interface.

2)How to use

  Insert the desired polynomials in the fields, mentioning the coefficient and the exponent 
for every monomial, even for values like 1 and 0. Choose an operation and the result will be
shown in the result field (1.for the derivative and integration, the operation will
take the first polynomial from the first field | 2.if the result is 0, the result field will be empty).

# Queue Management

1)Project Description
  This project implements a real time queue management system based on the input given by the user. 
The main technique used is multi-threading, a queue representing a thread that will process clients.
  
2)How to use
  Insert the desired simulation time, number of queues, number of clients, arrival time interval and
the service time interval. After all the fields were filled, press the 'Start Simulation' button.
A new frame will pop up where you can visualize the evolution of all queues in real time and the clients
left to serve. At the end of the simulation (the simulation ends when the time is up or there are no more
clients to be served) the average waiting time, average service time and the peak hour will be displayed
in the bottom right corner.

# Orders Management

1)Project Description

  This project implements an order management system for processing clients orders for a warehouse with
the help of relational databases (MySQL). Each order placed creates a bill (an immutable class (record)) if there
are enough items in stock.

2)How to use
  
  First of all, choose the type of data you want to operate on by pressing one button: Clients, Products or Orders.
After you have made your choice, a new window will pop up where you can visualize the corresponding table data from
MySQL in JTables. The operations on clients and products are similar: you can add by filling the fields, edit data 
in the table (every column on a single row can be edited at once, the 'Apply Changes' button has to be pressed if you
want to edit another row) and delete by selecting the desired rows (multiple deletion allowed). These changes will take
place in the database. The JTable from the interface will be updated based on the changes that took place
in MySQL, so that if the changes could not be applied in MySQL, will not be applied in the JTable either.
  
# Study Platform
  
  Project Overview

  This is a complex project that implements a study platform both for students and teachers. Every student, teacher and
admin has an account. This was made possible by using MySQL. This project is based more on SQL rather than Java, all the
options being implemented using MySQL queries, procedures and triggers. Logging in can be done by filling the email and
password fields where the credentials will be verified (checking in MySQL if the user exists and if the password is correct).
The admin is the one that can add, edit and delete teachers and students and can search them by name. 
  Teachers can plan new activities like courses and exams that must only be set in the future (datetime format) and must not 
overlap other activities that they have planned. The teachers have access to a catalog where they can give grades to students 
for different activities, each activity having  a weight the teacher sets. They can view their list of activities that are 
planned for today (real time) and for other days as well. 
  Students can attend this activities being automatically distributed to different teachers, (teaching the same activity the 
student wants to attend) teachers with fewer students being prioritized (one teacher cannot have all the students and the other none), 
so that there are no activities that overlap. They can view their own grades for each activity already calculated by the weight set 
by the teachers and see their upcoming activities. Every subject has a study group for students so students are automatically added
to these groups when they choose what subjects they want to study. In these groups they can plan activities where a minimum number of 
students and a limit time can be set. If that threshold is not crossed before the time limit, the activity is canceled and the 
students that wanted to attend it will be announced via a message. Also, the study groups have chats where students can message 
each other (the conversation is being saved). Students have the option to add a teacher in a study group if they want to.
  Each person can see their own personal data.

