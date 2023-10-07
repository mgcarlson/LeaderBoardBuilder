class Contestant implements Comparable<Contestant> {
    private String name;
    private int score;

    //Constructor function
    public Contestant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    //function comparing both score and name values, and returning integers to use in add function
    @Override
    public int compareTo(Contestant other) {
        if (this.score == other.score) {
            if (this.name.compareTo(other.name) == 0){
                return 0;
            }
            else if (this.name.compareTo(other.name) > 0) {
                return -1;
            }
            else {
                return 1;
            }
        }
        
        else if (this.score > other.score) {
            return 1;
        }
        else {
            return -1;
        }
    } 

    //putting elements in Contestant into correct format for printing
    @Override
    public String toString() {
        return name + ": " + score;
    }

}