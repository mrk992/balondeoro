package club.chiringo.quiz.balon.oro.balon.oro.model;

public enum AwardType {
    fiveStars(5), threeStars(3), oneStars(1);
    private int value;
    AwardType(int i) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
