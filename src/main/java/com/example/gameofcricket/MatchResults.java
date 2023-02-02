package com.example.gameofcricket;

public class MatchResults
{
    public static void getMatchResults(Team team1Obj, Team team2Obj, Team wonToss, String chooseBatOrBall,int overs) {
        if (wonToss == team1Obj)
        {
            if (chooseBatOrBall == "Bat")
            {


                if (team1Obj.getScore() < team2Obj.getScore())
                {
                    int wonByWickets = 10 - team2Obj.getWickets();
                    System.out.println("Team2  Won by  " + wonByWickets + " wickets.");
                    System.out.println("Team1 score = " + team1Obj.getScore() + "/" + team1Obj.getWickets());
                    System.out.println("Overs = " + team1Obj.getOvers() + "/"+overs);
                    System.out.println("Team2 score = " + team2Obj.getScore() + "/" + team2Obj.getWickets());
                    System.out.println("Overs = " + team2Obj.getOvers() + "/"+overs);


                }
                else
                {
                    System.out.println("Team1 Won by " + (team1Obj.getScore() - team2Obj.getScore()) + " runs.");
                    System.out.println("Team1 score = " + team1Obj.getScore() + "/" + team1Obj.getWickets());
                    System.out.println("Overs = " + team1Obj.getOvers() + "/"+overs);
                    System.out.println("Team2 score = " + team2Obj.getScore() + "/" + team2Obj.getWickets());
                    System.out.println("Overs = " + team2Obj.getOvers() + "/"+overs);

                }
            }
            else
            {


                if(team1Obj.getScore()>team2Obj.getScore())
                {
                    int wonByWickets=10- team1Obj.getWickets();
                    System.out.println("Team1  Won by  "+wonByWickets+" wickets.");
                    System.out.println("Team2 score = "+team2Obj.getScore()+"/"+team2Obj.getWickets());
                    System.out.println("Overs = "+team2Obj.getOvers()+"/"+overs);
                    System.out.println("Team2 score = "+team1Obj.getScore()+"/"+team1Obj.getWickets());
                    System.out.println("Overs = "+team1Obj.getOvers()+"/"+overs);


                }
                else
                {
                    System.out.println("Team2 Won by "+(team2Obj.getScore()- team1Obj.getScore()-1)+" runs.");
                    System.out.println("Team2 score = "+team2Obj.getScore()+"/"+team2Obj.getWickets());
                    System.out.println("Overs = "+team2Obj.getOvers()+"/"+overs);
                    System.out.println("Team2 score = "+team1Obj.getScore()+"/"+team1Obj.getWickets());
                    System.out.println("Overs = "+team1Obj.getOvers()+"/"+overs);


                }
            }
        }
        else
        {
            if (chooseBatOrBall == "Bat")
            {
                if(team1Obj.getScore()>team2Obj.getScore())
                {
                    int wonByWickets=10- team1Obj.getWickets();
                    System.out.println("Team1  Won by  "+wonByWickets+" wickets.");
                    System.out.println("Team2 score = "+team2Obj.getScore()+"/"+team2Obj.getWickets());
                    System.out.println("Overs = "+team2Obj.getOvers()+"/"+overs);
                    System.out.println("Team2 score = "+team1Obj.getScore()+"/"+team1Obj.getWickets());
                    System.out.println("Overs = "+team1Obj.getOvers()+"/"+overs);

                }
                else
                {
                    System.out.println("Team2 Won by "+(team2Obj.getScore()- team1Obj.getScore()-1)+" runs.");
                    System.out.println("Team2 score = "+team2Obj.getScore()+"/"+team2Obj.getWickets());
                    System.out.println("Overs = "+team2Obj.getOvers()+"/"+overs);
                    System.out.println("Team2 score = "+team1Obj.getScore()+"/"+team1Obj.getWickets());
                    System.out.println("Overs = "+team1Obj.getOvers()+"/"+overs);


                }
            }
            else
            {


                if(team1Obj.getScore()<team2Obj.getScore())
                {
                    int wonByWickets=10- team2Obj.getWickets();
                    System.out.println("Team2  Won by  "+wonByWickets+" wickets.");

                    System.out.println("Team1 score = "+team1Obj.getScore()+"/"+team1Obj.getWickets());
                    System.out.println("Overs = "+team1Obj.getOvers()+"/"+overs);
                    System.out.println("Team2 score = "+team2Obj.getScore()+"/"+team2Obj.getWickets());
                    System.out.println("Overs = "+team2Obj.getOvers()+"/"+overs);


                }
                else
                {
                    System.out.println("Team1 Won by "+(team1Obj.getScore()- team2Obj.getScore())+" runs.");
                    System.out.println("All Out");
                    System.out.println("Team1 score = "+team1Obj.getScore()+"/"+team1Obj.getWickets());
                    System.out.println("Overs = "+team1Obj.getOvers()+"/"+overs);
                    System.out.println("Team2 score = "+team2Obj.getScore()+"/"+team2Obj.getWickets());
                    System.out.println("Overs = "+team2Obj.getOvers()+"/"+overs);

                }
            }
        }
    }
}
