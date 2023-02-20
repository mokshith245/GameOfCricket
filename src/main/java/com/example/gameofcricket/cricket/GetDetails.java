package com.example.gameofcricket.cricket;

import java.util.Scanner;

public class GetDetails
{

    Scanner sc= new Scanner(System.in);

    public  void getDetails()
    {

        int valid;
        System.out.println("Enter 1 to get score of individual Player and give the player name : ");
        System.out.println("Enter 2 to get scorecard at particular point of over and give the over number : ");
        System.out.println("Enter 3 to get g");
        System.out.println("Enter 4 to get");
        valid=sc.nextInt();

        switch (valid)
        {
            case 1:
                retrieveData();
                break;
            case  2:

                break;
            case 4:
                break;
            case 0:
                break;



        }

    }
    public void retrieveData()
    {

    }


}
