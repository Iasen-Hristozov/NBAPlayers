package test.nbaplayers.model;

import java.util.List;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BallDontLieApiService
{
   private static final String BASE_URL = "https://balldontlie.io";

   private final BallDontLieApi api;

   public BallDontLieApiService()
   {
      OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
               Request originalRequest = chain.request();
               Request.Builder builder = originalRequest.newBuilder();

//               Request.Builder builder = originalRequest.newBuilder().header("Authorization",
//                                                                             "token " + token);

               Request newRequest = builder.build();
               return chain.proceed(newRequest);
            }).build();

      api = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
                        .create(BallDontLieApi.class);
   }

   public Single<PlayersResult> getPlayersResult(int page, int perPage)
   {
      return api.getPlayers(page, perPage);
   }

//   public Single<List<Player>> getPlayers(int page, int perPage)
//   {
//      return api.getPlayers(page, perPage);
//   }


   public Single<StatsResult> getStatsResult(int playerId)
   {
      return api.getStats(playerId);
   }

   public Single<SeasonAveragesResult> getSeasonAveragesResult(int playerId)
   {
      return api.getSeasonAverages(playerId);
   }

   public Single<SeasonAveragesResult> getSeasonAverages(int playerId)
   {
      return api.getSeasonAverages(playerId);
   }
}
