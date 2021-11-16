package corp.alv.challenges.general.arrays.easy;

import java.util.*;

/**
 *
 */
public class TournamentWinner {

    public static String solution(List<List<String>> competitions, List<Integer> results) {
        HashMap<String, Integer> points = new HashMap<>();
        String winner = "";

        //0 = away won
        //1 = home won
        for (int i = 0; i < competitions.size(); i++) {
            List<String> competitors = competitions.get(i);
            int result = results.get(i);

            String homeTeam = competitors.get(0);
            String awayTeam = competitors.get(1);

            String winningTeam = result == 1 ? homeTeam : awayTeam;

            points.put(winningTeam, points.getOrDefault(winningTeam, 0) + 3);

            if (points.get(winningTeam) > points.getOrDefault(winner, 0)) {
                winner = winningTeam;
            }
        }

        return winner;
    }

    public static String solution2(List<List<String>> competitions, List<Integer> results) {
        HashMap<String, Integer> points = new HashMap<>();
        String winner = "";

        //0 = away won
        //1 = home won
        for (int i = 0; i < competitions.size(); i++) {
            List<String> competitors = competitions.get(i);
            int result = results.get(i);

            String homeTeam = competitors.get(0);
            String awayTeam = competitors.get(1);
            String winningTeam = result == 1 ? homeTeam : awayTeam;

            points.put(winningTeam, points.getOrDefault(winningTeam, 0) + 3);

            if (points.get(winningTeam) > points.getOrDefault(winner, 0)) {
                winner = winningTeam;
            }
        }

        return winner;
    }
}
