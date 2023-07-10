package test.nbaplayers;

import android.app.Application;

import test.nbaplayers.coordinator.Navigator;
import test.nbaplayers.coordinator.PlayersFlowCoordinator;

public class NbaPlayersApplication extends Application
{
   private PlayersFlowCoordinator playersFlowCoordinator;

   @Override
   public void onCreate()
   {
      super.onCreate();

   }

   public void setPlayersFlowCoordinator(PlayersFlowCoordinator playersFlowCoordinator)
   {
      this.playersFlowCoordinator = playersFlowCoordinator;
   }

   public PlayersFlowCoordinator getPlayersFlowCoordinator()
   {
      return playersFlowCoordinator;
   }
}
