import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard {
    private List<Contestant> leaderboard;
    private int max;

    //Constructor function
    public Leaderboard(int m) {
        this.max = m;
        this.leaderboard = new ArrayList<>();
    }

    //adds contestant to leaderboard, but also sorts by passing into function compareTo and swapping elements
    public void addContestant(Contestant c) {

        leaderboard.add(c);

        //iterating through the leaderboard and comparing each element to passed in contestant, swapping if greater than
        for (int i = leaderboard.indexOf(c); i >= 0; i--) {
            if(c.compareTo(leaderboard.get(i)) > 0) {
                Collections.swap(leaderboard, i, leaderboard.indexOf(c));
            }
        }
        //if an element was pushed down, removing that element so the length of the array is correct
        if(leaderboard.size() > max) {
            leaderboard.remove(leaderboard.size() - 1);
        } 
    } 

    //making array list into contestant array
    public Contestant[] finalBoard() {
        return leaderboard.toArray(new Contestant[0]);
    }
}