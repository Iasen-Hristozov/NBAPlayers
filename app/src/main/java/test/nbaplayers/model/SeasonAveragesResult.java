package test.nbaplayers.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeasonAveragesResult
{
   @SerializedName("data")
   @Expose
   private List<SeasonAverages> data;

   public List<SeasonAverages> getData() {
      return data;
   }

   public void setData(List<SeasonAverages> data) {
      this.data = data;
   }
}
