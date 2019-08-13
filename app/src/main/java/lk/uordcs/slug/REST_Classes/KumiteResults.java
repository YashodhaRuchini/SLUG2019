package lk.uordcs.slug.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KumiteResults {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("WeightCategory")
    @Expose
    private String weightCategory;
    @SerializedName("MatchNo")
    @Expose
    private Integer matchNo;
    @SerializedName("Round")
    @Expose
    private String round;
    @SerializedName("Uni1")
    @Expose
    private String uni1;
    @SerializedName("Uni1_Player")
    @Expose
    private String uni1Player;
    @SerializedName("Uni1_Score")
    @Expose
    private Integer uni1Score;
    @SerializedName("Uni2")
    @Expose
    private String uni2;
    @SerializedName("Uni2_Player")
    @Expose
    private String uni2Player;
    @SerializedName("Uni2_Score")
    @Expose
    private Integer uni2Score;
    @SerializedName("Winner")
    @Expose
    private String winner;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public Integer getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(Integer matchNo) {
        this.matchNo = matchNo;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getUni1() {
        return uni1;
    }

    public void setUni1(String uni1) {
        this.uni1 = uni1;
    }

    public String getUni1Player() {
        return uni1Player;
    }

    public void setUni1Player(String uni1Player) {
        this.uni1Player = uni1Player;
    }

    public Integer getUni1Score() {
        return uni1Score;
    }

    public void setUni1Score(Integer uni1Score) {
        this.uni1Score = uni1Score;
    }

    public String getUni2() {
        return uni2;
    }

    public void setUni2(String uni2) {
        this.uni2 = uni2;
    }

    public String getUni2Player() {
        return uni2Player;
    }

    public void setUni2Player(String uni2Player) {
        this.uni2Player = uni2Player;
    }

    public Integer getUni2Score() {
        return uni2Score;
    }

    public void setUni2Score(Integer uni2Score) {
        this.uni2Score = uni2Score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}