package test.nbaplayers.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeasonAverages implements Parcelable
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

   @Override
   public int describeContents()
   {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel dest, int flags)
   {
      dest.writeValue(this.gamesPlayed);
      dest.writeValue(this.playerId);
      dest.writeValue(this.season);
      dest.writeValue(this.pts);
   }

   public void readFromParcel(Parcel source)
   {
      this.gamesPlayed = (Integer) source.readValue(Integer.class.getClassLoader());
      this.playerId = (Integer) source.readValue(Integer.class.getClassLoader());
      this.season = (Integer) source.readValue(Integer.class.getClassLoader());
      this.pts = (Double) source.readValue(Double.class.getClassLoader());
   }

   public SeasonAverages()
   {
   }

   protected SeasonAverages(Parcel in)
   {
      this.gamesPlayed = (Integer) in.readValue(Integer.class.getClassLoader());
      this.playerId = (Integer) in.readValue(Integer.class.getClassLoader());
      this.season = (Integer) in.readValue(Integer.class.getClassLoader());
      this.pts = (Double) in.readValue(Double.class.getClassLoader());
   }

   public static final Parcelable.Creator<SeasonAverages> CREATOR = new Parcelable.Creator<SeasonAverages>()
   {
      @Override
      public SeasonAverages createFromParcel(Parcel source)
      {
         return new SeasonAverages(source);
      }

      @Override
      public SeasonAverages[] newArray(int size)
      {
         return new SeasonAverages[size];
      }
   };
}
