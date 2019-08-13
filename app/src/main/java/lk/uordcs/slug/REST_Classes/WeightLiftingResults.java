package lk.uordcs.slug.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeightLiftingResults {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("MatchNo")
    @Expose
    private Integer matchNo;
    @SerializedName("WeightCategory")
    @Expose
    private String weightCategory;
    @SerializedName("Uni")
    @Expose
    private String uni;
    @SerializedName("PlayerName")
    @Expose
    private String playerName;
    @SerializedName("Snatch")
    @Expose
    private String snatch;
    @SerializedName("Clean_and_Jerk")
    @Expose
    private String cleanAndJerk;
    @SerializedName("Total")
    @Expose
    private String total;
    @SerializedName("Rank")
    @Expose
    private String rank;
    @SerializedName("Gender")
    @Expose
    private String gender;

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

    public Integer getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(Integer matchNo) {
        this.matchNo = matchNo;
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

    public String getSnatch() {
        return snatch;
    }

    public void setSnatch(String snatch) {
        this.snatch = snatch;
    }

    public String getCleanAndJerk() {
        return cleanAndJerk;
    }

    public void setCleanAndJerk(String cleanAndJerk) {
        this.cleanAndJerk = cleanAndJerk;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}