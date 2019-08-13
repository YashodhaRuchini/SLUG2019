package lk.uordcs.slug.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoadRace {

    @SerializedName("Uni")
    @Expose
    private String uni;
    @SerializedName("PlayerName")
    @Expose
    private String playerName;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("Rank")
    @Expose
    private Integer rank;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}