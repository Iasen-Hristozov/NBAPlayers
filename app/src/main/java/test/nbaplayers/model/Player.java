package test.nbaplayers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Player implements Serializable
{
   @SerializedName("id")
   @Expose
   private Integer id;
   @SerializedName("first_name")
   @Expose
   private String firstName;
   @SerializedName("height_feet")
   @Expose
   private Object heightFeet;
   @SerializedName("height_inches")
   @Expose
   private Object heightInches;
   @SerializedName("last_name")
   @Expose
   private String lastName;
   @SerializedName("position")
   @Expose
   private String position;
   @SerializedName("team")
   @Expose
   private Team team;
   @SerializedName("weight_pounds")
   @Expose
   private Object weightPounds;

   public Integer getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public Object getHeightFeet() {
      return heightFeet;
   }

   public Object getHeightInches() {
      return heightInches;
   }

   public String getLastName() {
      return lastName;
   }


   public String getPosition() {
      return position;
   }

   public Team getTeam() {
      return team;
   }

   public Object getWeightPounds() {
      return weightPounds;
   }
}
