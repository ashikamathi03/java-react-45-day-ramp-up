#Day 04 Notes:
   ### 1.How recursion works:The "stack of plates" analogy
 Think of method calls like stacking clean plates on top of each other
1. Every time a method call itself,you place a **new plate(Stack frame)** on top
2. you cannot tpouch a plate until the plates on the plates are removed.
3. The **Base case** is he signal to stop adding plates and start taking them off one by one.
---
###2. Step-by-Step Visualization:`factorial(5)`

Here is exactly what happen in memory when `factorial(5)` runs
```text
===================================================================================================
                            CALL STACK TRACE:factorial(5)
====================================================================================================
Step 1: Going up(solving & unwinding Memory):
----------------------------------------------------------------------------------------------------
factorial(5)-->pauses! waits for factorial(4)
factorial(4)-->pauses! waits for factorial(3)
factorial(3)-->pauses! waits for factorial(2)
factorial(2)-->pauses! waits for factorial(1)
factorial(1)-->Base Case Reached! Returns 1 immediately

Step 2: Going down(solving & unwinding Memory):
-----------------------------------------------------------------------------------------------------
factorial(1) returns 1
|
+-->factorial(2) wakes up:Calculates 2*1=2(returns 2)
    |
    +-->factorial(3) wakes up:Calculates 3*2=6(returns 6)
           |
           +-->factorial(4) wakes up:Calculates 4*6=24(returns 24)
                |
                +-->factorial(5) wakes up:Calculates 24*5=2(returns 120)
=======================================================================================================
Final Result Returned to main:120
=======================================================================================================