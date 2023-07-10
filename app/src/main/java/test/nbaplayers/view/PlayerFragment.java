package test.nbaplayers.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import test.nbaplayers.R;
import test.nbaplayers.databinding.FragmentPlayerBinding;
import test.nbaplayers.model.Player;
import test.nbaplayers.viewmodel.SeasonAveragesViewModel;

public class PlayerFragment extends Fragment
{
   private Player player;
   private FragmentPlayerBinding binding;
   private SeasonAveragesViewModel seasonAveragesViewModel;

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      ((AppCompatActivity)requireActivity()).getSupportActionBar()
                                            .setDisplayHomeAsUpEnabled(true);



      binding = FragmentPlayerBinding.inflate(inflater, container, false);

      seasonAveragesViewModel = new ViewModelProvider(this).get(SeasonAveragesViewModel.class);

      binding.detailsButton.setOnClickListener(v -> {
         seasonAveragesViewModel.fetchFromRemote(player.getId());
         observeViewModels();});

      return binding.getRoot();
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
   {
      super.onViewCreated(view, savedInstanceState);

      if(getArguments() == null)
         return;

      player = PlayerFragmentArgs.fromBundle(getArguments())
                                        .getPlayer();

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

   private void observeViewModels()
   {
      seasonAveragesViewModel.seasonAveragesLiveData.observe(getViewLifecycleOwner(), seasonAverages -> seasonAveragesViewModel.onDetailsClicked(getView(), seasonAverages));
      seasonAveragesViewModel.seasonAveragesLoadError.observe(getViewLifecycleOwner(), error ->
      {
         if(error)
            showErrorDialog();
      });
      seasonAveragesViewModel.loading.observe(getViewLifecycleOwner(), loading -> binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE));
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }

   private void showErrorDialog()
   {
      new AlertDialog.Builder(getContext())
            .setTitle(R.string.title_error)
            .setMessage(R.string.error_details)
            .setNegativeButton(android.R.string.ok, null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
   }
}