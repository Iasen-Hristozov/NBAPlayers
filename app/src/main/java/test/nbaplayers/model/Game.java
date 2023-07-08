package test.nbaplayers.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game implements Parcelable
{
   @SerializedName("id")
   @Expose
   private Integer id;
   @SerializedName("date")
   @Expose
   private String date;
   @SerializedName("home_team_id")
   @Expose
   private Integer homeTeamId;
   @SerializedName("home_team_score")
   @Expose
   private Integer homeTeamScore;
   @SerializedName("period")
   @Expose
   private Integer period;
   @SerializedName("postseason")
   @Expose
   private Boolean postseason;
   @SerializedName("season")
   @Expose
   private Integer season;
   @SerializedName("status")
   @Expose
   private String status;
   @SerializedName("time")
   @Expose
   private String time;
   @SerializedName("visitor_team_id")
   @Expose
   private Integer visitorTeamId;
   @SerializedName("visitor_team_score")
   @Expose
   private Integer visitorTeamScore;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public Integer getHomeTeamId() {
      return homeTeamId;
   }

   public void setHomeTeamId(Integer homeTeamId) {
      this.homeTeamId = homeTeamId;
   }

   public Integer getHomeTeamScore() {
      return homeTeamScore;
   }

   public void setHomeTeamScore(Integer homeTeamScore) {
      this.homeTeamScore = homeTeamScore;
   }

   public Integer getPeriod() {
      return period;
   }

   public void setPeriod(Integer period) {
      this.period = period;
   }

   public Boolean getPostseason() {
      return postseason;
   }

   public void setPostseason(Boolean postseason) {
      this.postseason = postseason;
   }

   public Integer getSeason() {
      return season;
   }

   public void setSeason(Integer season) {
      this.season = season;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public Integer getVisitorTeamId() {
      return visitorTeamId;
   }

   public void setVisitorTeamId(Integer visitorTeamId) {
      this.visitorTeamId = visitorTeamId;
   }

   public Integer getVisitorTeamScore() {
      return visitorTeamScore;
   }

   public void setVisitorTeamScore(Integer visitorTeamScore) {
      this.visitorTeamScore = visitorTeamScore;
   }


   @Override
   public int describeContents()
   {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel dest, int flags)
   {
      dest.writeValue(this.id);
      dest.writeString(this.date);
      dest.writeValue(this.homeTeamId);
      dest.writeValue(this.homeTeamScore);
      dest.writeValue(this.period);
      dest.writeValue(this.postseason);
      dest.writeValue(this.season);
      dest.writeString(this.status);
      dest.writeString(this.time);
      dest.writeValue(this.visitorTeamId);
      dest.writeValue(this.visitorTeamScore);
   }

   public void readFromParcel(Parcel source)
   {
      this.id = (Integer) source.readValue(Integer.class.getClassLoader());
      this.date = source.readString();
      this.homeTeamId = (Integer) source.readValue(Integer.class.getClassLoader());
      this.homeTeamScore = (Integer) source.readValue(Integer.class.getClassLoader());
      this.period = (Integer) source.readValue(Integer.class.getClassLoader());
      this.postseason = (Boolean) source.readValue(Boolean.class.getClassLoader());
      this.season = (Integer) source.readValue(Integer.class.getClassLoader());
      this.status = source.readString();
      this.time = source.readString();
      this.visitorTeamId = (Integer) source.readValue(Integer.class.getClassLoader());
      this.visitorTeamScore = (Integer) source.readValue(Integer.class.getClassLoader());
   }

   public Game()
   {
   }

   protected Game(Parcel in)
   {
      this.id = (Integer) in.readValue(Integer.class.getClassLoader());
      this.date = in.readString();
      this.homeTeamId = (Integer) in.readValue(Integer.class.getClassLoader());
      this.homeTeamScore = (Integer) in.readValue(Integer.class.getClassLoader());
      this.period = (Integer) in.readValue(Integer.class.getClassLoader());
      this.postseason = (Boolean) in.readValue(Boolean.class.getClassLoader());
      this.season = (Integer) in.readValue(Integer.class.getClassLoader());
      this.status = in.readString();
      this.time = in.readString();
      this.visitorTeamId = (Integer) in.readValue(Integer.class.getClassLoader());
      this.visitorTeamScore = (Integer) in.readValue(Integer.class.getClassLoader());
   }

   public static final Creator<Game> CREATOR = new Creator<Game>()
   {
      @Override
      public Game createFromParcel(Parcel source)
      {
         return new Game(source);
      }

      @Override
      public Game[] newArray(int size)
      {
         return new Game[size];
      }
   };
}
