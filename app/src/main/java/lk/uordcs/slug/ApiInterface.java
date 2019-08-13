package lk.uordcs.slug;

import java.util.List;

import lk.uordcs.slug.REST_Classes.BadmintonResults;
import lk.uordcs.slug.REST_Classes.BaseballResults;
import lk.uordcs.slug.REST_Classes.BasketballResults;
import lk.uordcs.slug.REST_Classes.CarromResults;
import lk.uordcs.slug.REST_Classes.ChessResults;
import lk.uordcs.slug.REST_Classes.CricketResults;
import lk.uordcs.slug.REST_Classes.ElleResults;
import lk.uordcs.slug.REST_Classes.FootballResults;
import lk.uordcs.slug.REST_Classes.HockeyResults;
import lk.uordcs.slug.REST_Classes.IndividualPoomsaeResults;
import lk.uordcs.slug.REST_Classes.JumpingResults;
import lk.uordcs.slug.REST_Classes.KataResults;
import lk.uordcs.slug.REST_Classes.KumiteResults;
import lk.uordcs.slug.REST_Classes.NetballResults;
import lk.uordcs.slug.REST_Classes.Notice_;
import lk.uordcs.slug.REST_Classes.RoadRace;
import lk.uordcs.slug.REST_Classes.RowingResults;
import lk.uordcs.slug.REST_Classes.RugbyFootballResults;
import lk.uordcs.slug.REST_Classes.RunningResults;
import lk.uordcs.slug.REST_Classes.SingleNotice;
import lk.uordcs.slug.REST_Classes.SparringResults;
import lk.uordcs.slug.REST_Classes.SwimmingIndividualResults;
import lk.uordcs.slug.REST_Classes.SwimmingTeamResults;
import lk.uordcs.slug.REST_Classes.TTennisResults;
import lk.uordcs.slug.REST_Classes.TeamPoomsaeResults;
import lk.uordcs.slug.REST_Classes.TennisResults;
import lk.uordcs.slug.REST_Classes.ThrowingResults;
import lk.uordcs.slug.REST_Classes.VolleyballResults;
import lk.uordcs.slug.REST_Classes.WeightLiftingResults;
import lk.uordcs.slug.REST_Classes.WrestlingResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {


    @GET("Notices")
    Call<List<Notice_>> getNotices();

    @GET("RoadRaceResult")
    Call<List<RoadRace>> getRoadRaceResults();

    @GET("Notice/{id}")
    Call<SingleNotice> getSingleNotice(@Query("NoticeID") String noticeID);

    @GET("BadmintonResults")
    Call<List<BadmintonResults>> getBadmintonResults();

    @GET("VolleyballResults")
    Call<List<VolleyballResults>> getVolleyballResults();

    @GET("NetballResults")
    Call<List<NetballResults>> getNetballResults();

    @GET("TTennisResults")
    Call<List<TTennisResults>> getTTennisResults();

    @GET("BaseballResults")
    Call<List<BaseballResults>> getBaseballResults();

    @GET("BasketballResults")
    Call<List<BasketballResults>> getBasketballResults();

    @GET("CricketResults")
    Call<List<CricketResults>> getCricketResults();

    @GET("FootballResults")
    Call<List<FootballResults>> getFootballResults();

    @GET("RugbyFootball")
    Call<List<RugbyFootballResults>> getRugbyFootballResults();

    @GET("Running")
    Call<List<RunningResults>> getRunningResults();

    @GET("HighJump")
    Call<List<JumpingResults>> getHighJumpResults();

    @GET("LongJump")
    Call<List<JumpingResults>> getLongJumpResults();

    @GET("TripleJump")
    Call<List<JumpingResults>> getTripleJumpResults();

    @GET("PoleVault")
    Call<List<JumpingResults>> getPoleVaultResults();

    @GET("JavelinThrow")
    Call<List<ThrowingResults>> getJavelinThrowResults();

    @GET("DiscusThrow")
    Call<List<ThrowingResults>> getDiscusThrowResults();

    @GET("ShotPut")
    Call<List<ThrowingResults>> getShotPutResults();

    @GET("carrom")
    Call<List<CarromResults>> getCaromResults();

    @GET("elle")
    Call<List<ElleResults>> getElleResults();

    @GET("hockey")
    Call<List<HockeyResults>> getHockeyResults();

    @GET("kata")
    Call<List<KataResults>> getKataResults();

    @GET("kumite")
    Call<List<KumiteResults>> getKumiteResults();

    @GET("rowing")
    Call<List<RowingResults>> getRowingResults();

    @GET("wrestling")
    Call<List<WrestlingResults>> getWrestlingResults();

    @GET("weightLifting")
    Call<List<WeightLiftingResults>> getWeightLiftingResults();

    @GET("tennisResults")
    Call<List<TennisResults>> getTennisResults();

    @GET("swimmingIndividual")
    Call<List<SwimmingIndividualResults>> getSwimmingIndividual();

    @GET("swimmingTeam")
    Call<List<SwimmingTeamResults>> getSwimmingTeam();

    @GET("hurdles")
    Call<List<RunningResults>> getHurdles();

    @GET("relay")
    Call<List<RunningResults>> getRelay();

    @GET("chess")
    Call<List<ChessResults>> getChessResults();

    @GET("sparring")
    Call<List<SparringResults>> getSparringResults();

    @GET("individualPoomsae")
    Call<List<IndividualPoomsaeResults>> getIndividualPoomsaeResults();

    @GET("teamPoomsae")
    Call<List<TeamPoomsaeResults>> getTeamPoomsaeResults();
}
