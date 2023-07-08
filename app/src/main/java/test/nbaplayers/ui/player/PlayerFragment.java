package test.nbaplayers.ui.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import test.nbaplayers.databinding.FragmentPlayerBinding;
import test.nbaplayers.model.Player;

public class PlayerFragment extends Fragment
{

   private FragmentPlayerBinding binding;

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
      binding = FragmentPlayerBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

      binding.detailsButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(PlayerFragmentDirections.actionPlayerToDetails(player.getId())));
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

      binding.nameTextView.setText(String.join(" ", player.getFirstName(), player.getLastName()));
//      String team = String.join(", ", player.getTeam().getFullName(), player.getTeam().getCity(), player.getTeam().getConference(), player.getTeam().getDivision());
      String team = String.format(("%s (%s)\n%s - %s"), player.getTeam().getFullName(), player.getTeam().getCity(), player.getTeam().getConference(), player.getTeam().getDivision());
      binding.teamTextView.setText(team);
      if(player.getHeightFeet() != null)
         binding.heightTextView.setText(String.valueOf(player.getHeightFeet()));
      if(player.getWeightPounds() != null)
         binding.weightTextView.setText(String.valueOf(player.getWeightPounds()));
      if(player.getPosition() != null && !player.getPosition().isEmpty())
         binding.positionTextView.setText(player.getPosition());
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}