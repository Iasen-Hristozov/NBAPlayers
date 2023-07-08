package test.nbaplayers.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable
{
   @SerializedName("id")
   @Expose
   private Integer id;
   @SerializedName("ast")
   @Expose
   private Integer ast;
   @SerializedName("blk")
   @Expose
   private Integer blk;
   @SerializedName("dreb")
   @Expose
   private Integer dreb;
   @SerializedName("fg3_pct")
   @Expose
   private Double fg3Pct;
   @SerializedName("fg3a")
   @Expose
   private Integer fg3a;
   @SerializedName("fg3m")
   @Expose
   private Integer fg3m;
   @SerializedName("fg_pct")
   @Expose
   private Double fgPct;
   @SerializedName("fga")
   @Expose
   private Integer fga;
   @SerializedName("fgm")
   @Expose
   private Integer fgm;
   @SerializedName("ft_pct")
   @Expose
   private Double ftPct;
   @SerializedName("fta")
   @Expose
   private Integer fta;
   @SerializedName("ftm")
   @Expose
   private Integer ftm;
   @SerializedName("game")
   @Expose
   private Game game;
   @SerializedName("min")
   @Expose
   private String min;
   @SerializedName("oreb")
   @Expose
   private Integer oreb;
   @SerializedName("pf")
   @Expose
   private Integer pf;
   @SerializedName("player")
   @Expose
   private Player player;
   @SerializedName("pts")
   @Expose
   private Integer pts;
   @SerializedName("reb")
   @Expose
   private Integer reb;
   @SerializedName("stl")
   @Expose
   private Integer stl;
   @SerializedName("team")
   @Expose
   private Team team;
   @SerializedName("turnover")
   @Expose
   private Integer turnover;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getAst() {
      return ast;
   }

   public void setAst(Integer ast) {
      this.ast = ast;
   }

   public Integer getBlk() {
      return blk;
   }

   public void setBlk(Integer blk) {
      this.blk = blk;
   }

   public Integer getDreb() {
      return dreb;
   }

   public void setDreb(Integer dreb) {
      this.dreb = dreb;
   }

   public Double getFg3Pct() {
      return fg3Pct;
   }

   public void setFg3Pct(Double fg3Pct) {
      this.fg3Pct = fg3Pct;
   }

   public Integer getFg3a() {
      return fg3a;
   }

   public void setFg3a(Integer fg3a) {
      this.fg3a = fg3a;
   }

   public Integer getFg3m() {
      return fg3m;
   }

   public void setFg3m(Integer fg3m) {
      this.fg3m = fg3m;
   }

   public Double getFgPct() {
      return fgPct;
   }

   public void setFgPct(Double fgPct) {
      this.fgPct = fgPct;
   }

   public Integer getFga() {
      return fga;
   }

   public void setFga(Integer fga) {
      this.fga = fga;
   }

   public Integer getFgm() {
      return fgm;
   }

   public void setFgm(Integer fgm) {
      this.fgm = fgm;
   }

   public Double getFtPct() {
      return ftPct;
   }

   public void setFtPct(Double ftPct) {
      this.ftPct = ftPct;
   }

   public Integer getFta() {
      return fta;
   }

   public void setFta(Integer fta) {
      this.fta = fta;
   }

   public Integer getFtm() {
      return ftm;
   }

   public void setFtm(Integer ftm) {
      this.ftm = ftm;
   }

   public Game getGame() {
      return game;
   }

   public void setGame(Game game) {
      this.game = game;
   }

   public String getMin() {
      return min;
   }

   public void setMin(String min) {
      this.min = min;
   }

   public Integer getOreb() {
      return oreb;
   }

   public void setOreb(Integer oreb) {
      this.oreb = oreb;
   }

   public Integer getPf() {
      return pf;
   }

   public void setPf(Integer pf) {
      this.pf = pf;
   }

   public Player getPlayer() {
      return player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public Integer getPts() {
      return pts;
   }

   public void setPts(Integer pts) {
      this.pts = pts;
   }

   public Integer getReb() {
      return reb;
   }

   public void setReb(Integer reb) {
      this.reb = reb;
   }

   public Integer getStl() {
      return stl;
   }

   public void setStl(Integer stl) {
      this.stl = stl;
   }

   public Team getTeam() {
      return team;
   }

   public void setTeam(Team team) {
      this.team = team;
   }

   public Integer getTurnover() {
      return turnover;
   }

   public void setTurnover(Integer turnover) {
      this.turnover = turnover;
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
      dest.writeValue(this.ast);
      dest.writeValue(this.blk);
      dest.writeValue(this.dreb);
      dest.writeValue(this.fg3Pct);
      dest.writeValue(this.fg3a);
      dest.writeValue(this.fg3m);
      dest.writeValue(this.fgPct);
      dest.writeValue(this.fga);
      dest.writeValue(this.fgm);
      dest.writeValue(this.ftPct);
      dest.writeValue(this.fta);
      dest.writeValue(this.ftm);
      dest.writeParcelable(this.game, flags);
      dest.writeString(this.min);
      dest.writeValue(this.oreb);
      dest.writeValue(this.pf);
      dest.writeSerializable(this.player);
      dest.writeValue(this.pts);
      dest.writeValue(this.reb);
      dest.writeValue(this.stl);
      dest.writeParcelable(this.team, flags);
      dest.writeValue(this.turnover);
   }

   public void readFromParcel(Parcel source)
   {
      this.id = (Integer) source.readValue(Integer.class.getClassLoader());
      this.ast = (Integer) source.readValue(Integer.class.getClassLoader());
      this.blk = (Integer) source.readValue(Integer.class.getClassLoader());
      this.dreb = (Integer) source.readValue(Integer.class.getClassLoader());
      this.fg3Pct = (Double) source.readValue(Double.class.getClassLoader());
      this.fg3a = (Integer) source.readValue(Integer.class.getClassLoader());
      this.fg3m = (Integer) source.readValue(Integer.class.getClassLoader());
      this.fgPct = (Double) source.readValue(Double.class.getClassLoader());
      this.fga = (Integer) source.readValue(Integer.class.getClassLoader());
      this.fgm = (Integer) source.readValue(Integer.class.getClassLoader());
      this.ftPct = (Double) source.readValue(Double.class.getClassLoader());
      this.fta = (Integer) source.readValue(Integer.class.getClassLoader());
      this.ftm = (Integer) source.readValue(Integer.class.getClassLoader());
      this.game = source.readParcelable(Game.class.getClassLoader());
      this.min = source.readString();
      this.oreb = (Integer) source.readValue(Integer.class.getClassLoader());
      this.pf = (Integer) source.readValue(Integer.class.getClassLoader());
      this.player = (Player) source.readSerializable();
      this.pts = (Integer) source.readValue(Integer.class.getClassLoader());
      this.reb = (Integer) source.readValue(Integer.class.getClassLoader());
      this.stl = (Integer) source.readValue(Integer.class.getClassLoader());
      this.team = source.readParcelable(Team.class.getClassLoader());
      this.turnover = (Integer) source.readValue(Integer.class.getClassLoader());
   }

   public Stats()
   {
   }

   protected Stats(Parcel in)
   {
      this.id = (Integer) in.readValue(Integer.class.getClassLoader());
      this.ast = (Integer) in.readValue(Integer.class.getClassLoader());
      this.blk = (Integer) in.readValue(Integer.class.getClassLoader());
      this.dreb = (Integer) in.readValue(Integer.class.getClassLoader());
      this.fg3Pct = (Double) in.readValue(Double.class.getClassLoader());
      this.fg3a = (Integer) in.readValue(Integer.class.getClassLoader());
      this.fg3m = (Integer) in.readValue(Integer.class.getClassLoader());
      this.fgPct = (Double) in.readValue(Double.class.getClassLoader());
      this.fga = (Integer) in.readValue(Integer.class.getClassLoader());
      this.fgm = (Integer) in.readValue(Integer.class.getClassLoader());
      this.ftPct = (Double) in.readValue(Double.class.getClassLoader());
      this.fta = (Integer) in.readValue(Integer.class.getClassLoader());
      this.ftm = (Integer) in.readValue(Integer.class.getClassLoader());
      this.game = in.readParcelable(Game.class.getClassLoader());
      this.min = in.readString();
      this.oreb = (Integer) in.readValue(Integer.class.getClassLoader());
      this.pf = (Integer) in.readValue(Integer.class.getClassLoader());
      this.player = (Player) in.readSerializable();
      this.pts = (Integer) in.readValue(Integer.class.getClassLoader());
      this.reb = (Integer) in.readValue(Integer.class.getClassLoader());
      this.stl = (Integer) in.readValue(Integer.class.getClassLoader());
      this.team = in.readParcelable(Team.class.getClassLoader());
      this.turnover = (Integer) in.readValue(Integer.class.getClassLoader());
   }

   public static final Creator<Stats> CREATOR = new Creator<Stats>()
   {
      @Override
      public Stats createFromParcel(Parcel source)
      {
         return new Stats(source);
      }

      @Override
      public Stats[] newArray(int size)
      {
         return new Stats[size];
      }
   };
}
