<h1>Text Encryption and Decryption</h1>

### __Project Description:__

The project is a program for encrypting and decrypting text using various methods such as character substitution and frequency analysis. 
It includes classes for text manipulation, encryption keys, and file paths.

### **Project Structure:**<br>
1. `Communication.java:` A class that facilitates interaction with the user by providing a menu and handling user input.
2. `Statistic.java:` A class for analysing text and collecting statistics to determine the state of the text
3. `FrequencyAnalyzer.java:` A class that provides methods for decrypting text based on frequency analysis of characters.
4. `Encrypt.java:` A class for encrypting text using an encryption key.
5. `Decrypt.java:` A class for decrypting text using a decryption key.
6. `BruteForce.java:` A class for decoding text without using a key. The class enumerates the keys and then does a check using statistical analysis whether the text is decrypted or not.
7. `DataPath.java:` A class that manages file paths and encryption/decryption keys.
8. `StaticSymbols.java:` A class containing static symbols and methods for working with them.
9. `IOData:` A class that is responsible for writing or reading data from a file


### **_Modes:_**
1. Encrypt - encrypts the text from the input file to the output file. 
2. Decrypt - decrypts the text from the input file to the output file. 
3. BruteForce - decrypts the text without using key.
4. Analyze - decrypts the text using statistics and analysis
5. Exit - finish the program


***More detailed documentation is written in each of the programme classes.*** 
