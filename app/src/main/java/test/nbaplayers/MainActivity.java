package test.nbaplayers;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import test.nbaplayers.coordinator.Navigator;
import test.nbaplayers.coordinator.PlayersFlowCoordinator;
import test.nbaplayers.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);

      ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());

      // Passing each menu ID as a set of Ids because each
      // menu should be considered as top level destinations.
      AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_players,
                                                                                R.id.navigation_about).build();
      NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
      NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
      NavigationUI.setupWithNavController(binding.navView, navController);

      ((NbaPlayersApplication) getApplication()).setPlayersFlowCoordinator(new PlayersFlowCoordinator(new Navigator(this)));
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if(item.getItemId() == android.R.id.home)
      {
         ((NbaPlayersApplication) getApplication()).getPlayersFlowCoordinator().onBackPressed();
         return true;
      }
      return super.onOptionsItemSelected(item);
   }
}