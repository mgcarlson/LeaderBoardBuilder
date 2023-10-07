import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class LeaderboardTest {
    public static void main(String[] args) {

        //having user input the size of the leaderboard
        int size;
        Scanner user = new Scanner(System.in);
        System.out.println("Enter leaderboard size:");
        size = user.nextInt();

        //closing scanner system to ensure no memory leak
        user.close();

        //declaring new leaderboard to fill
        Leaderboard b = new Leaderboard(size);

        //reading in the file, or throwing exception
        try(BufferedReader reader = new BufferedReader(new FileReader("names.txt"))) {
            String line;

            //reading in strings until file ends
            while ((line = reader.readLine()) != null) {

                //splitting the lines read by commas, in order to separate name from score
                String[] parts = line.split(",");

                //Making new contestant object and then adding it to our leaderboard
                Contestant c1 = new Contestant(parts[0], Integer.valueOf(parts[1]));
                b.addContestant(c1);
            }

        //catching exception if file cannot be read
        } catch (IOException e) {
            System.err.println("Could not read numbers.txt");
        }

        //printing board once it is converted into an array of Contestant
        Contestant[] printBoard = b.finalBoard();
        for (int i = 0; i < printBoard.length; i++) {
                System.out.println(printBoard[i].toString());
        }

    }
}
