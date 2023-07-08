package test.nbaplayers.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable
{
   @SerializedName("id")
   @Expose
   private Integer id;
   @SerializedName("abbreviation")
   @Expose
   private String abbreviation;
   @SerializedName("city")
   @Expose
   private String city;
   @SerializedName("conference")
   @Expose
   private String conference;
   @SerializedName("division")
   @Expose
   private String division;
   @SerializedName("full_name")
   @Expose
   private String fullName;
   @SerializedName("name")
   @Expose
   private String name;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getAbbreviation() {
      return abbreviation;
   }

   public void setAbbreviation(String abbreviation) {
      this.abbreviation = abbreviation;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getConference() {
      return conference;
   }

   public void setConference(String conference) {
      this.conference = conference;
   }

   public String getDivision() {
      return division;
   }

   public void setDivision(String division) {
      this.division = division;
   }

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
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
      dest.writeString(this.abbreviation);
      dest.writeString(this.city);
      dest.writeString(this.conference);
      dest.writeString(this.division);
      dest.writeString(this.fullName);
      dest.writeString(this.name);
   }

   public void readFromParcel(Parcel source)
   {
      this.id = (Integer) source.readValue(Integer.class.getClassLoader());
      this.abbreviation = source.readString();
      this.city = source.readString();
      this.conference = source.readString();
      this.division = source.readString();
      this.fullName = source.readString();
      this.name = source.readString();
   }

   public Team()
   {
   }

   protected Team(Parcel in)
   {
      this.id = (Integer) in.readValue(Integer.class.getClassLoader());
      this.abbreviation = in.readString();
      this.city = in.readString();
      this.conference = in.readString();
      this.division = in.readString();
      this.fullName = in.readString();
      this.name = in.readString();
   }

   public static final Creator<Team> CREATOR = new Creator<Team>()
   {
      @Override
      public Team createFromParcel(Parcel source)
      {
         return new Team(source);
      }

      @Override
      public Team[] newArray(int size)
      {
         return new Team[size];
      }
   };
}
