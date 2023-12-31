package test.nbaplayers.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BallDontLieApi
{
   @GET("api/v1/players")
   Single<PlayersResult> getPlayers(@Query("per_page") int perPage, @Query("page") int page );

   @GET("api/v1/season_averages")
   Single<SeasonAveragesResult> getSeasonAverages(@Query("player_ids[]") int playerId);
}
