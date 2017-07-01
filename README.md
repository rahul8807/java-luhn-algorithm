LUHN ALGORITHM

Credit card numbers can be validated with a process called the Luhn algorithm. Simply stated, the Luhn algorithm works like this:
1.      Starting with the next to last digit and continuing with every other digit going back to the beginning of the card, double the digit.  
2.      Sum all doubled and untouched digits in the number.  
3.      If that total is a multiple of 10, the number is valid. 
For example, given the card number 4408 0412 3456 7893:
Orig  :  4 4 0 8 0 4 1 2 3 4   5 6   7 8   9 3
Step 1:  8 4 0 8 0 4 2 2 6 4  10 6  14 8  18 3
Step 2:  8+4+0+8+0+4+2+2+6+4+1+0+6+1+4+8+1+8+3 = 70
Step 3:  70 % 10 == 0