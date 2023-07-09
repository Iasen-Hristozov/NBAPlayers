package test.nbaplayers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeasonAverages
{
   @SerializedName("games_played")
   @Expose
   private Integer gamesPlayed;
   @SerializedName("player_id")
   @Expose
   private Integer playerId;
   @SerializedName("season")
   @Expose
   private Integer season;
   @SerializedName("pts")
   @Expose
   private Double pts;

   public Integer getGamesPlayed() {
      return gamesPlayed;
   }

   public Integer getPlayerId() {
      return playerId;
   }

   public Integer getSeason() {
      return season;
   }

   public Double getPts() {
      return pts;
   }
}
