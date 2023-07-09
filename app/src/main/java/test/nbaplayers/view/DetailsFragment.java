package test.nbaplayers.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import test.nbaplayers.R;
import test.nbaplayers.databinding.FragmentDetailsBinding;
import test.nbaplayers.viewmodel.SeasonAveragesViewModel;

public class DetailsFragment extends Fragment
{
   public final static String ARG_PLAYER_ID = "playerId";
   private int playerId;

   private FragmentDetailsBinding binding;

   SeasonAveragesViewModel seasonAveragesViewModel;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      if(getArguments() != null)
      {
         playerId = getArguments().getInt(ARG_PLAYER_ID, -1);
      }
   }

   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState)
   {
      binding = FragmentDetailsBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

      if(playerId > 0)
         observeViewModels();

      return root;
   }

   private void observeViewModels()
   {
      seasonAveragesViewModel = new ViewModelProvider(this).get(SeasonAveragesViewModel.class);
      seasonAveragesViewModel.fetchFromRemote(250);
      seasonAveragesViewModel.seasonAveragesLiveData.observe(getViewLifecycleOwner(), seasonAverages -> {
         if(seasonAverages.getSeason() != null)
            binding.seasonTextView.setText(String.valueOf(seasonAverages.getSeason()));
         if(seasonAverages.getGamesPlayed() != null)
            binding.gamesTextView.setText(String.valueOf(seasonAverages.getGamesPlayed()));
         if(seasonAverages.getPts() != null)
            binding.pointsTextView.setText(String.valueOf(seasonAverages.getPts()));
      });
      seasonAveragesViewModel.seasonAveragesLoadError.observe(getViewLifecycleOwner(), error ->
      {
         if(error)
            new AlertDialog.Builder(getContext())
                  .setTitle(R.string.title_error)
                  .setMessage(R.string.error_details)
                  .setNegativeButton(android.R.string.ok, ((dialogInterface, i) -> {
                     Navigation.findNavController(getView()).navigateUp();
                  }))
                  .setIcon(android.R.drawable.ic_dialog_alert)
                  .show();
      });

      seasonAveragesViewModel.loading.observe(getViewLifecycleOwner(), loading -> binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE));
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}