# NetworkProgramming-ChatClient

## Description

This project is part of a simple network-based chat application (fork NetworkProgramming-ChatServer to run this application).

## Client Description

User is given an option to pick up the port number from 5000 to 65 535 which is then validated if it is not a String or invalid number. 
In order to establish a connection between the client and the server the port number must match with the port number which had been selected for the already running server (NetworkProgramming-ChatServer project). 
After the connection is established, the function startClient creates a new client. 
The communication between clients and server is passing through a Java object called a Socket. 
Each created socket contains two Streams, one which is reading data coming in and it is called *InputStream*. 
The second one, *OutputStream*, is sending data out of this socket.


## How to run
1.	Enter the *ChatClient* folder and navigate to the java file directory with following command:
```cd src/ie/gmit/dip```
2. Compile all files:
```javac Main.java ServerConnection.java```
3. Type *ls* command (Windows PowerShell or Git Bash) or *dir* command (Command Prompt) to ensure that you have all your compiled files ending with *.class*
4. Return to the *src* directory and execute the following command to run the server:
```java ie.gmit.dip.Main```
