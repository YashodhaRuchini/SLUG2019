package lk.uordcs.slug.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KataResults {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("MatchNo")
    @Expose
    private Integer matchNo;
    @SerializedName("Round")
    @Expose
    private String round;
    @SerializedName("Team_Individual")
    @Expose
    private String teamIndividual;
    @SerializedName("WeightCategory")
    @Expose
    private String weightCategory;
    @SerializedName("Uni")
    @Expose
    private String uni;
    @SerializedName("PlayerName")
    @Expose
    private String playerName;
    @SerializedName("Points")
    @Expose
    private String points;

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

    public String getTeamIndividual() {
        return teamIndividual;
    }

    public void setTeamIndividual(String teamIndividual) {
        this.teamIndividual = teamIndividual;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}