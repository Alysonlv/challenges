package corp.alv.challenges.general.queue.medium;

/*
649. Dota2 Senate
Solved
Medium
Topics
Companies
In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".



Example 1:

Input: senate = "RD"
Output: "Radiant"
Explanation:
The first senator comes from Radiant and he can just ban the next senator's right in round 1.
And the second senator can't exercise any rights anymore since his right has been banned.
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
Example 2:

Input: senate = "RDD"
Output: "Dire"
Explanation:
The first senator comes from Radiant and he can just ban the next senator's right in round 1.
And the second senator can't exercise any rights anymore since his right has been banned.
And the third senator comes from Dire and he can ban the first senator's right in round 1.
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.


Constraints:

n == senate.length
1 <= n <= 104
senate[i] is either 'R' or 'D'.
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        if (senate.length() == 2) {
            if (senate.charAt(0) == 'R') {
                return "Radiant";
            } else {
                return "Dire";
            }
        }
        int banR = 0;
        int banD = 0;
        char B = 'B';

        char[] votes = senate.toCharArray();

        boolean hasNextRound = true;
        int index = 0;
        int totalVotes = votes.length;
        while (totalVotes > 1) {
            if (index == votes.length) {
                index = 0;
            }
//DDRRR
            char v = votes[index++];
            if (v == 'R') {
                if (banR > 0) {
                    votes[index - 1] = B;
                    banR--;
                    totalVotes--;
                } else {
                    banD++;
                }
            } else if (v == 'D') {
                if (banD > 0) {
                    votes[index - 1] = B;
                    banD--;
                    totalVotes--;
                } else {
                    banR++;
                }
            }
        }
        return banR > banD ? "Radiant" : "Dire";
    }

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];


        for (int i = 0; i < prices.length - 1; i++) {
            int min = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    min = prices[j];
                    break;
                }
            }

            if (min <= prices[i]) {
                result[i] = prices[i] - min;
            } else {
                result[i] = result[i];
            }
        }

        result[prices.length - 1] = prices[prices.length - 1];

        return result;
    }

    public static void main(String[] args) {
        Dota2Senate d = new Dota2Senate();
//        System.out.println(d.predictPartyVictory("RD"));

        System.out.println(d.finalPrices(new int[]{8, 4, 6, 2, 3}));
    }
}
