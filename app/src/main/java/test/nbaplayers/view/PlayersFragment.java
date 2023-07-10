package test.nbaplayers.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import test.nbaplayers.databinding.FragmentPlayersBinding;
import test.nbaplayers.model.Player;
import test.nbaplayers.viewmodel.PlayersViewModel;

public class PlayersFragment extends Fragment
{
   boolean isLoading = false;
   private FragmentPlayersBinding binding;

   private final static ArrayList<Player> players = new ArrayList<>();

   private PlayersViewModel playersViewModel;

   private PlayersListAdapter playersListAdapter;

   private String searchText = "";

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      binding = FragmentPlayersBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

      binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
      {
         @Override
         public boolean onQueryTextSubmit(String query)
         {
            return false;
         }

         @Override
         public boolean onQueryTextChange(String newText)
         {
            playersListAdapter.filter(newText);
            searchText = newText;
            return true;
         }
      });

      playersListAdapter = new PlayersListAdapter(getActivity(),
                                                  players,
                                                  (player, view) -> playersViewModel.playerClicked(player));

      RecyclerView playersRecycleView = binding.playersRecycleView;
      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(playersRecycleView.getContext(),
                                                                              layoutManager.getOrientation());
      playersRecycleView.addItemDecoration(dividerItemDecoration);
      playersRecycleView.setLayoutManager(layoutManager);
      playersRecycleView.setAdapter(playersListAdapter);

      playersRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener()
      {
         @Override
         public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState)
         {
            super.onScrollStateChanged(recyclerView, newState);
            if (!recyclerView.canScrollVertically(-1) && newState==RecyclerView.SCROLL_STATE_IDLE)
               binding.searchView.setVisibility(View.VISIBLE);
         }

         @Override
         public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
         {
            super.onScrolled(recyclerView, dx, dy);

            if (dy > 0) {
               binding.searchView.setVisibility(View.GONE);
            }

            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if(!isLoading)
            {
               if(linearLayoutManager != null
                     && linearLayoutManager.findLastCompletelyVisibleItemPosition() == players.size() - 1)
               {
                  loadPlayers();
               }
            }
         }
      });

      playersViewModel = new ViewModelProvider(this).get(PlayersViewModel.class);

      observeViewModels();

      if(players.size() == 0)
         loadPlayers();

      return root;
   }

   private void observeViewModels()
   {
      playersViewModel.playersResultLiveData.observe(getViewLifecycleOwner(), playersResult -> {
         int currentCount = players.size();
         players.addAll(playersResult.getPlayers());
         playersListAdapter.notifyItemRangeInserted(currentCount, playersResult.getPlayers().size());
         playersListAdapter.filter(searchText);
      });

      playersViewModel.playersResultLoadError.observe(getViewLifecycleOwner(), error ->
      {
         if(error)
            playersViewModel.onPlayersError();
      });

      playersViewModel.loading.observe(getViewLifecycleOwner(), loading -> {
         isLoading = loading;

         binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE);
      });
   }

   private void loadPlayers()
   {
      playersViewModel.fetchNextPlayers();
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}