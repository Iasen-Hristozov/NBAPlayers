package test.nbaplayers.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import test.nbaplayers.databinding.FragmentDetailsBinding;
import test.nbaplayers.model.SeasonAverages;

public class DetailsFragment extends Fragment
{
   public final static String ARG_PLAYER_DETAILS = "SeasonAverages";
   private SeasonAverages seasonAverages;

   private FragmentDetailsBinding binding;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      if(getArguments() != null)
      {
         seasonAverages = getArguments().getParcelable(ARG_PLAYER_DETAILS);
      }
   }

   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState)
   {
      binding = FragmentDetailsBinding.inflate(inflater, container, false);
      return binding.getRoot();
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
   {
      super.onViewCreated(view, savedInstanceState);

      if(getArguments() == null)
         return;

      seasonAverages = DetailsFragmentArgs.fromBundle(getArguments()).getPlayerDetails();
      if(seasonAverages.getSeason() != null)
         binding.seasonTextView.setText(String.valueOf(seasonAverages.getSeason()));
      if(seasonAverages.getGamesPlayed() != null)
         binding.gamesTextView.setText(String.valueOf(seasonAverages.getGamesPlayed()));
      if(seasonAverages.getPts() != null)
         binding.pointsTextView.setText(String.valueOf(seasonAverages.getPts()));
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}