package test.nbaplayers.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import test.nbaplayers.databinding.FragmentDetailsBinding;
import test.nbaplayers.viewmodel.SeasonAveragesResultViewModel;

public class DetailsFragment extends Fragment
{
   public final static String ARG_PLAYER_ID = "playerId";
   private int playerId;

   private FragmentDetailsBinding binding;

   SeasonAveragesResultViewModel seasonAveragesViewModel;

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
      {
         seasonAveragesViewModel = new ViewModelProvider(this).get(SeasonAveragesResultViewModel.class);
         seasonAveragesViewModel.fetchFromRemote(250);
         seasonAveragesViewModel.seasonAveragesLiveData.observe(getViewLifecycleOwner(), seasonAverages -> {
            if(seasonAverages.getSeason() != null)
               binding.seasonTextView.setText(String.valueOf(seasonAverages.getSeason()));
            if(seasonAverages.getGamesPlayed() != null)
               binding.gamesTextView.setText(String.valueOf(seasonAverages.getGamesPlayed()));
            if(seasonAverages.getPts() != null)
               binding.pointsTextView.setText(String.valueOf(seasonAverages.getPts()));
         });
         seasonAveragesViewModel.loading.observe(getViewLifecycleOwner(), loading -> binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE));
      }

      return root;

   }
}