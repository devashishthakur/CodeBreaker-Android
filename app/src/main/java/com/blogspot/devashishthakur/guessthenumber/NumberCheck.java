package com.blogspot.devashishthakur.guessthenumber;

import java.util.Random;

public class NumberCheck {

    Random rn = new Random(); // Declaring Random
    //GENERATING FOUR RANDOM NUMBERS
    int num1 = rn.nextInt(9) + 1 ;
    int num2 = rn.nextInt(9) + 1 ;
    int num3 = rn.nextInt(9) + 1 ;
    int num4 = rn.nextInt(9) + 1 ;
    //Four flags each for checking if random numbers generated is equal to entered number
    int flag1,flag2,flag3,flag4;

    // Defining four check methods each for
    int check1(int n)
    {
        while(num1 == num2 || num1 == num3 || num1 == num4) // Generate Random Numtill till It is not Unique
        {
            num1 = rn.nextInt(9) + 1 ;
        }

        if (n==num1)
        {
            flag1 = 1;       // If number is at its correct position return 1
        }
        else if ( n == num2 || n == num3 || n == num4)
        {
            flag1 = 2;      // If number is at wrong position return 2
        }
        else
            flag1 = 0;      // If number is not present

        return flag1;   // Return either 1 , 2 or 0 depending upon above check
    }
    //SAME HAPPENS AGAIN FOR EACH OTHER NUMBER
    int check2(int n)
    {
        while(num2 == num1 || num2 == num3 || num2 == num4)

        {
            num2 = rn.nextInt(9) + 1 ;
        }

        if (n==num2)
        {
            flag2 = 1;
        }
        else if ( n == num1 || n == num3 || n == num4)
        {
            flag2 = 2;
        }
        else
            flag2 = 0;

        return flag2;
    }
    int check3(int n)
    {
        while(num3 == num1 || num3 == num2 || num3 == num4)
        {
            num3 = rn.nextInt(9) + 1 ;
        }

        if (n==num3)
        {
            flag3 = 1;
        }
        else if ( n == num2 || n == num1 || n == num4)
        {
            flag3 = 2;
        }
        else
            flag3 = 0;

        return flag3;
    }
    int check4(int n)
    {
        while(num4 == num1 || num4 == num3 || num4 == num2)
        {
            num4 = rn.nextInt(9) + 1 ;
        }

        if (n==num4)
        {
            flag4 = 1;
        }
        else if ( n == num2 || n == num3 || n == num1)
        {
            flag4 = 2;
        }
        else
            flag4 = 0;

        return flag4;
    }

}
