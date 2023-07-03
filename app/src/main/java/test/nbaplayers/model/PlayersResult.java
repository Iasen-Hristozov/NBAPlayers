package test.nbaplayers.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayersResult
{
   @SerializedName("data")
   @Expose
   private List<Player> players;
   @SerializedName("meta")
   @Expose
   private Meta         meta;

   public List<Player> getPlayers() {
      return players;
   }

   public void setPlayers(List<Player> players) {
      this.players = players;
   }

   public Meta getMeta() {
      return meta;
   }

   public void setMeta(Meta meta) {
      this.meta = meta;
   }
}
