package test.nbaplayers.coordinator;

import android.view.View;

import test.nbaplayers.model.Player;
import test.nbaplayers.model.SeasonAverages;

public class PlayersFlowCoordinator
{
   private final Navigator navigator;

   public PlayersFlowCoordinator(Navigator navigator)
   {
      this.navigator = navigator;
   }

   public void start()
   {
      navigator.showPlayers();
   }

   public void onPlayerSelected(Player player)
   {
      navigator.showPlayer(player);
   }

   public void onDetailsClicked(SeasonAverages seasonAverages)
   {
      navigator.showDetails(seasonAverages);
   }

   public void onDataRetrievingError(String error)
   {
      navigator.showErrorDialog(error);
   }

   public void onDetailsCloseClicked()
   {
      navigator.closeDetails();
   }

}
