package test.nbaplayers.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BallDontLieApi
{
   @GET("api/v1/players")
   Single<PlayersResult> getPlayers(@Query("page") int page, @Query("per_page") int perPage );

   @GET("api/v1/stats")
   Single<StatsResult> getStats(@Query("player_ids[]") int playerId);
}
