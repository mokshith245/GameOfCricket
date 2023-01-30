package com.example.gameofcricket;

public class Runs
{
    String striker;
    int first=0;
    int second=0;

    String player1;
    String player2;
        public void Single()
        {
            first++;
            if(striker==player1)
            {
                striker=player2;

            }
            else
            {
                striker =player1;
            }
        }
        public void doubles()
        {
            first+=2;
            if(striker==player1)
            {
                striker=player1;
            }
            else
            {
                striker=player2;
            }
        }
        public void triple()
        {
            first+=3;
            if(striker==player1)
            {
                striker=player2;
            }
            else
            {
                striker=player1;
            }
        }
        public void four()
        {
            first+=4;
            if(striker==player1)
                striker=player1;
            else
            {
                striker=player2;
            }
        }
        public void six()
        {
            if(striker==player1)
            {
                striker=player1;
            }
            else
            {
                striker=player2;
            }
        }
        public void wicket()
        {

        }
{

}
}
