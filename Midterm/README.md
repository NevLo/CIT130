Introduction
======
   For this midterm, you will be creating a fully functioning JAVA application 
   with the following specs: (each item is worth 15 points, for a total of 
   150 points for the midterm. Each item listed is graded independently from 
   the others, so if you are stuck on something move on to the next item.) 
   The midterm MUST be submitted on time. This module will lock at 8:20 PM 
   and no midterms will be accepted after that time.

Instructions
------
   1) Using NetBeans, create a new project called MidTerm, add the appropriate 
      packages for scanner and random, and create a scanner and random object 
      at the very beginning of your main method. Place a multi line comment at 
      the top of the source code with your name, date, and a description of 
      "Midterm CIT 130 FA2018".

   2) Add a text file called "numbers.txt" to the default location in the 
      NetBeans project so it can be read from the application. Add 10 numbers 
      of your choice between 1 and 1000 to the text file each on its own line. 

   3) Now prompt the user for their name and store that name in a variable in 
      the main method. Greet the user by name and display a menu asking them 
      to make a selection: 

         1 - Create nickname  
         2 - Test your IQ  
         3 - Display a table  
         4 - Read from a file  
         5 - Exit  

   4) In your main method setup a do-while. Decide how you will keep the do 
      while running. (hint: see #3 above...) In the do-while you should 
      display the menu, get the user's selection, and check the user's 
      selection using a switch statement. Each of the items below should be  
      done in a separate case of the switch statement. (Do not create your 
      own methods. We will study those next week.)

   5) When "1" is selected from the menu, display the current name. You will 
      create a nickname using a "$" for the first letter, get the first and 
      last letter of the user's original name for the second and third letter,
      and append a random 3 digit number to the end of it. Then append the 
      length of the original name at the end. (So "Fred" becomes "$Fd1114" for 
      example, 4 being the length of "Fred"). Display this new name to the user 
      and update the name variable with the new nickname. (You can use 3 single 
      digit numbers created randomly or 1 three digit number created randomly.
       Up to you.)

   6) When "2" is selected from the menu, get 2 random numbers between 0 and 49. 
      And ask the user what the sum of the 2 numbers is. If the user is correct 
      say "Great Job!", and then assign IQ the value of 100 plus the sum of the 2 
      numbers. If the user is incorrect, say "No, the answer was...", display the 
      answer, and assign IQ the value of 10 plus the sum of the 2 numbers. 
      Then display the IQ.

   Reminder: using the nextInt() method of the Scanner object will leave some 
   information that can lead to issues in an application combining nextInt() 
   with nextLine(). You need to clear the leftover info from nextInt() with a 
   blank nextLine() call after calling nextInt(). To avoid this you could use 
   Integer.parseInt() instead.

   7) When "3" is selected from the menu, prompt the user (using their name) for a
      letter, prompt the user for a number from 1 to 10, and make sure the number 
      is not less than 1 or greater than 10 IN ONE STATEMENT. If number is less 
      than 1 or greater than 10 then set it to 10. Use for loops to display an 
      "n x n" grid of the letter entered. So 'A' and '3' would look like this:

         A A A  
	 A A A  
	 A A A  

   8) When "4" is selected from the menu, open the numbers.txt file, read in the 
      values and display the sum to the user. (You can create a new Scanner 
      object or reinitialize the current scanner)

   9) When "5" is selected from the menu, display "Thanks for playing! Please 
      come back again!" Make sure the loop no longer executes and the program ends. 
      When the user enters any number other than 1 - 5, Display "Try again..." and 
      the loop should continue to execute.

   10) Place single line comments just above any variables you have created with a 
       short description of the variable. Zip up your entire project and upload the 
       zip file to this module.

   ---------------------------------------------------------------------------------

   How I will grade. I will use at least the following to make sure your program 
   functions properly:

      1 - "c" entered should display "$cc5651". "Brandy" entered should display 
          "$By1116".

      2 - I will test with correct and incorrect answers.

      3 - I will use -5, 5, and 15. 5 should be 5 x 5, and the others should be 
          10 x 10.

      4 - Should read from your file.

      6 - -1 Should display try again.

      5 - Should exit gracefully with goodbye message.

   The program should make it through all of the checks without needing to be 
   restarted.

