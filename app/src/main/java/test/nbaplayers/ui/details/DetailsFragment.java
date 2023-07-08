package test.nbaplayers.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import test.nbaplayers.databinding.FragmentDetailsBinding;
import test.nbaplayers.viewmodel.SeasonAveragesResultViewModel;
import test.nbaplayers.viewmodel.StatsResultViewModel;


public class DetailsFragment extends Fragment
{
   public final static String ARG_PLAYER_ID = "playerId";
   private int playerId;

   private FragmentDetailsBinding binding;

   StatsResultViewModel          statsResultViewModel;
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


      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.statsRecycleView.getContext(),
                                                                              layoutManager.getOrientation());
      binding.statsRecycleView.addItemDecoration(dividerItemDecoration);
      binding.statsRecycleView.setLayoutManager(layoutManager);

      if(playerId > 0)
      {
//         statsResultViewModel = new ViewModelProvider(this).get(StatsResultViewModel.class);
//         statsResultViewModel.fetchFromRemote(playerId);
//         statsResultViewModel.statsListLiveData.observe(getViewLifecycleOwner(), statsList -> {
////            statsList.get(0).getGame().
////            Map<YearMonth,Map<String,Long>> = statsList.stream().get
//
//            DetailsListAdapter adapter = new DetailsListAdapter(getActivity(), statsList);
//            binding.statsRecycleView.setAdapter(adapter);
//         });
//         statsResultViewModel.loading.observe(getViewLifecycleOwner(), loading -> binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE));

         seasonAveragesViewModel = new ViewModelProvider(this).get(SeasonAveragesResultViewModel.class);
         seasonAveragesViewModel.fetchFromRemote(250);
         seasonAveragesViewModel.seasonAveragesLiveData.observe(getViewLifecycleOwner(), seasonAverages -> {
//            statsList.get(0).getGame().
//            Map<YearMonth,Map<String,Long>> = statsList.stream().get
               int a = 1;
//            DetailsListAdapter adapter = new DetailsListAdapter(getActivity(), statsList);
//            binding.statsRecycleView.setAdapter(adapter);
         });
         seasonAveragesViewModel.loading.observe(getViewLifecycleOwner(), loading -> binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE));
      }

      return root;

   }
}