package test.nbaplayers.ui.players;

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
import test.nbaplayers.databinding.LoadingViewBinding;
import test.nbaplayers.model.Player;
import test.nbaplayers.viewmodel.PlayersResultViewModel;
import test.nbaplayers.viewmodel.StatsResultViewModel;

public class PlayersFragment extends Fragment
{
   private final static int PLAYERS_NUMBER = 25;

   boolean isLoading = false;
   private FragmentPlayersBinding binding;
   private LoadingViewBinding loadingViewBinding;

   private RecyclerView playersRecycleView;

   private final static ArrayList<Player> players = new ArrayList<>();

   PlayersResultViewModel playersResultViewModel;

   private PlayersListAdapter playersListAdapter;

   private String searchText = "";

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      PlayersViewModel playersViewModel = new ViewModelProvider(this).get(PlayersViewModel.class);

      binding = FragmentPlayersBinding.inflate(inflater, container, false);
      View root = binding.getRoot();
      playersRecycleView = binding.playersRecycleView;

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

      playersListAdapter = new PlayersListAdapter(getActivity(), players);

      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(playersRecycleView.getContext(),
                                                                              layoutManager.getOrientation());
      playersRecycleView.addItemDecoration(dividerItemDecoration);
      playersRecycleView.setLayoutManager(layoutManager);
//      playersRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
      playersRecycleView.setAdapter(playersListAdapter);

      playersRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener()
      {
         @Override
         public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState)
         {
            super.onScrollStateChanged(recyclerView, newState);
            if (!recyclerView.canScrollVertically(-11) && newState==RecyclerView.SCROLL_STATE_IDLE)
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
                  loadMore();
               }
            }
         }
      });


//      final TextView textView = binding.textHome;
//      playersViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

      playersResultViewModel = new ViewModelProvider(this).get(PlayersResultViewModel.class);
      playersResultViewModel.fetchFromRemote(0, PLAYERS_NUMBER);


      StatsResultViewModel statsResultViewModel = new ViewModelProvider(this).get(StatsResultViewModel.class);
      statsResultViewModel.fetchFromRemote(237);

      playersResultViewModel.playersResultLiveData.observe(getViewLifecycleOwner(), playersResult -> {
//         PlayersResultViewModel repositoryViewModel = new ViewModelProvider(requireActivity()).get(PlayersResultViewModel.class);
//         PlayersListAdapter repositoriesListAdapter = new PlayersListAdapter(playersResult.getPlayers());
//
//         LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//         DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(playersRecycleView.getContext(),
//                                                                                 layoutManager.getOrientation());
//         playersRecycleView.addItemDecoration(dividerItemDecoration);
//         playersRecycleView.setLayoutManager(layoutManager);
//         playersRecycleView.setAdapter(repositoriesListAdapter);

         int currentCount = players.size();
         players.addAll(playersResult.getPlayers());
         playersListAdapter.notifyItemRangeInserted(currentCount, playersResult.getPlayers().size());
         playersListAdapter.filter(searchText);
//         playersListAdapter.notifyDataSetChanged();
      });

      playersResultViewModel.loading.observe(getViewLifecycleOwner(), loading -> {
         isLoading = loading;

         binding.progressView.progressView.setVisibility(loading ? View.VISIBLE : View.GONE);
      });

      return root;
   }
   private void loadMore()
   {
//      notificationList.add(null);

//      playersListAdapter.notifyItemInserted(players.size() - 1);

//      getNotificationsViewModel.fetchGetNotifications(login.getTokenEnc(),
//                                                      btEnuLanguage,
//                                                      login.getFiscalCode(),
//                                                      notificationList.size() - 1,
//                                                      PLAYERS_NUMBER);
      playersResultViewModel.fetchFromRemote(players.size(), PLAYERS_NUMBER);
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}