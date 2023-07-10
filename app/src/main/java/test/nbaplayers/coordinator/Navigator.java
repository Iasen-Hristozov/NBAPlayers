package test.nbaplayers.coordinator;

import android.app.Activity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import test.nbaplayers.R;
import test.nbaplayers.model.Player;
import test.nbaplayers.model.SeasonAverages;
import test.nbaplayers.view.PlayerFragmentDirections;
import test.nbaplayers.view.PlayersFragmentDirections;

public class Navigator
{
   private final NavController navController;
   public Navigator(AppCompatActivity activity)
   {
      navController = Navigation.findNavController(activity, R.id.nav_host_fragment_activity_main);
//      navController.navigateUp();
//      navController.navigate(R.id.FragmentYouWantShown);
   }

   public void showPlayers()
   {
      navController.navigate(R.id.navigation_players);
   }

   public void showPlayer(Player player)
   {
      navController.navigate(PlayersFragmentDirections.actionPlayersToPlayer(player));
   }

   public void showDetails(SeasonAverages seasonAverages)
   {
      navController.navigate(PlayerFragmentDirections.actionPlayerToDetails(seasonAverages));
   }

   public void closeDetails()
   {
      navController.navigateUp();
   }
}
