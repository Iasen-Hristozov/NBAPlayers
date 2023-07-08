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
   @SerializedName("min")
   @Expose
   private String min;
   @SerializedName("fgm")
   @Expose
   private Double fgm;
   @SerializedName("fga")
   @Expose
   private Double fga;
   @SerializedName("fg3m")
   @Expose
   private Double fg3m;
   @SerializedName("fg3a")
   @Expose
   private Double fg3a;
   @SerializedName("ftm")
   @Expose
   private Double ftm;
   @SerializedName("fta")
   @Expose
   private Double fta;
   @SerializedName("oreb")
   @Expose
   private Double oreb;
   @SerializedName("dreb")
   @Expose
   private Double dreb;
   @SerializedName("reb")
   @Expose
   private Double reb;
   @SerializedName("ast")
   @Expose
   private Double ast;
   @SerializedName("stl")
   @Expose
   private Double stl;
   @SerializedName("blk")
   @Expose
   private Double blk;
   @SerializedName("turnover")
   @Expose
   private Double turnover;
   @SerializedName("pf")
   @Expose
   private Double pf;
   @SerializedName("pts")
   @Expose
   private Double pts;
   @SerializedName("fg_pct")
   @Expose
   private Double fgPct;
   @SerializedName("fg3_pct")
   @Expose
   private Double fg3Pct;
   @SerializedName("ft_pct")
   @Expose
   private Double ftPct;

   public Integer getGamesPlayed() {
      return gamesPlayed;
   }

   public void setGamesPlayed(Integer gamesPlayed) {
      this.gamesPlayed = gamesPlayed;
   }

   public Integer getPlayerId() {
      return playerId;
   }

   public void setPlayerId(Integer playerId) {
      this.playerId = playerId;
   }

   public Integer getSeason() {
      return season;
   }

   public void setSeason(Integer season) {
      this.season = season;
   }

   public String getMin() {
      return min;
   }

   public void setMin(String min) {
      this.min = min;
   }

   public Double getFgm() {
      return fgm;
   }

   public void setFgm(Double fgm) {
      this.fgm = fgm;
   }

   public Double getFga() {
      return fga;
   }

   public void setFga(Double fga) {
      this.fga = fga;
   }

   public Double getFg3m() {
      return fg3m;
   }

   public void setFg3m(Double fg3m) {
      this.fg3m = fg3m;
   }

   public Double getFg3a() {
      return fg3a;
   }

   public void setFg3a(Double fg3a) {
      this.fg3a = fg3a;
   }

   public Double getFtm() {
      return ftm;
   }

   public void setFtm(Double ftm) {
      this.ftm = ftm;
   }

   public Double getFta() {
      return fta;
   }

   public void setFta(Double fta) {
      this.fta = fta;
   }

   public Double getOreb() {
      return oreb;
   }

   public void setOreb(Double oreb) {
      this.oreb = oreb;
   }

   public Double getDreb() {
      return dreb;
   }

   public void setDreb(Double dreb) {
      this.dreb = dreb;
   }

   public Double getReb() {
      return reb;
   }

   public void setReb(Double reb) {
      this.reb = reb;
   }

   public Double getAst() {
      return ast;
   }

   public void setAst(Double ast) {
      this.ast = ast;
   }

   public Double getStl() {
      return stl;
   }

   public void setStl(Double stl) {
      this.stl = stl;
   }

   public Double getBlk() {
      return blk;
   }

   public void setBlk(Double blk) {
      this.blk = blk;
   }

   public Double getTurnover() {
      return turnover;
   }

   public void setTurnover(Double turnover) {
      this.turnover = turnover;
   }

   public Double getPf() {
      return pf;
   }

   public void setPf(Double pf) {
      this.pf = pf;
   }

   public Double getPts() {
      return pts;
   }

   public void setPts(Double pts) {
      this.pts = pts;
   }

   public Double getFgPct() {
      return fgPct;
   }

   public void setFgPct(Double fgPct) {
      this.fgPct = fgPct;
   }

   public Double getFg3Pct() {
      return fg3Pct;
   }

   public void setFg3Pct(Double fg3Pct) {
      this.fg3Pct = fg3Pct;
   }

   public Double getFtPct() {
      return ftPct;
   }

   public void setFtPct(Double ftPct) {
      this.ftPct = ftPct;
   }
}
