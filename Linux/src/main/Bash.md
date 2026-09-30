# Bash:-
- Bash stands for Bourne Again SHell.
- Bash is one type of Shell.
- Bash is a shell commonly used on Linux.

# Bash Script:-
- Bash scriot is a text file containing a sequence of shell commands which can be executed together
- Bash script always uses .sh extension.
- for example:
```
  command 1
  command 2
  command 3
  ```
## Why DevOps engineer need this?
Because it act as a universal connective tissue of modern atomation.
 ```
 </Bash> //command
hello.sh
 ```
**Source code**:
```
#!/bin/bash
echo "Hello, Linux!"
```
**first line of the output is called as **Shebang**

### echo:-
- echo is the command used to show output in the terminal
```
<Bash>
echo Hello
```
output:
```
Hello
```

# Flow of a Bash Script:

```text
  Create Script
        |
        v
  write commands
        |
        v
  save in .sh file
        |
        v
  Give permissions
        |
        v
  execute scripts
        |
        v
  Linux performs commands
  
```
# Variables:
- variables used to store the values.
- ```text
     name="xyz"

- after the "=" there should not be space between the value and the variable.
 ## To access the value we can use
```text
        echo $name
```
The ```$``` means Give me the value stored in this  

Output: 
```
     Ashika
```
#Enviroinment Values:
```text
    HOME
    USER
    PATH
    PWD
    
```
- These can be acesed using ```$```

# User Input :
- Bash can ask user for the input
 ### Command:
```text
read
```
for ex:
```text
        echo "Enter your name:"
        read name
        
        echo "Hello $name"
```
# IF conditions:
- Bash can make decision using if conditions.
- ```text
        if
           condition
       then
           command
       else
           command
       fi


# Loops:
- A loop repeats commands.

For example:
```text
             Start
               │
               ▼
            Condition
               │
        ┌──────┴──────┐
        ▼             ▼
      TRUE          FALSE
        │             │
        ▼             ▼
    Run command      Stop
        │
        └──────► Condition
```
- Bash commonly uses  
          - for  
          - while
          - until
# Functions

- A function is a reusable group of commands.
``` 
             Function
                 │
       ┌─────────┼─────────┐
       ▼         ▼         ▼
   Command 1  Command 2  Command 3
                 │
                 ▼
             Call function 
```
- Instead of writing the same commands repeatedly, you can put them inside a function and call it whenever needed.



