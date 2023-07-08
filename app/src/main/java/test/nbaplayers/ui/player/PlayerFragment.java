package test.nbaplayers.ui.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import test.nbaplayers.MainActivity;
import test.nbaplayers.R;
import test.nbaplayers.databinding.FragmentPlayerBinding;
import test.nbaplayers.model.Player;
import test.nbaplayers.model.Stats;
import test.nbaplayers.ui.player.PlayerFragmentDirections;
import test.nbaplayers.ui.players.PlayersFragmentDirections;
import test.nbaplayers.viewmodel.PlayerViewModel;
import test.nbaplayers.viewmodel.PlayersResultViewModel;
import test.nbaplayers.viewmodel.StatsResultViewModel;

public class PlayerFragment extends Fragment
{

   private FragmentPlayerBinding binding;

   StatsResultViewModel statsResultViewModel;

   Player player;

//   @Override
//   public void onCreate(Bundle savedInstanceState)
//   {
//      super.onCreate(savedInstanceState);
//      NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//
//      AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//            .build();
//      NavigationUI.setupWithNavController(binding.myToolbar, navController, appBarConfiguration);
//   }

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      PlayerViewModel notificationsViewModel =
            new ViewModelProvider(this).get(PlayerViewModel.class);

//      statsResultViewModel = new ViewModelProvider(this).get(StatsResultViewModel.class);
//      statsResultViewModel.statsResultLiveData.observe(getViewLifecycleOwner(), statsResult -> {
//
//         Stats stats[] = statsResult.getData().toArray(new Stats[0]);
//         PlayerFragmentDirections.ActionPlayerToDetails action = PlayerFragmentDirections.actionPlayerToDetails(stats);
//         Navigation.findNavController(binding.detailsButton).navigate(action);
//                                                       });

      binding = FragmentPlayerBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

//      binding.detailsButton.setOnClickListener(v -> statsResultViewModel.fetchFromRemote(player.getId()));

      binding.detailsButton.setOnClickListener(v -> {
         Navigation.findNavController(v).navigate(PlayerFragmentDirections.actionPlayerToDetails(player.getId()));
      });
//      ((MainActivity)getActivity()).showUpButton();
//      final TextView textView = binding.textNotifications;
//      notificationsViewModel.getText()
//                            .observe(getViewLifecycleOwner(), textView::setText);



      ((AppCompatActivity)requireActivity()).getSupportActionBar()
                                            .setDisplayHomeAsUpEnabled(true);
      return root;
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
   {
      super.onViewCreated(view, savedInstanceState);

      player = PlayerFragmentArgs.fromBundle(getArguments()).getPlayer();

      binding.nameTextView.setText(String.format("%s %s", player.getFirstName(), player.getLastName()));
      binding.teamTextView.setText(String.join(", ", player.getTeam().getFullName(), player.getTeam().getCity(), player.getTeam().getConference(),player.getTeam().getDivision()));
      binding.heightTextView.setText(player.getHeightFeet() != null ? player.getHeightFeet().toString() : "");
      binding.weightTextView.setText(player.getWeightPounds()!= null ? player.getWeightPounds().toString() : "");
      binding.positionTextView.setText(player.getPosition());
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }


}