package test.nbaplayers.ui.players;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import test.nbaplayers.databinding.FragmentPlayersBinding;
import test.nbaplayers.model.Player;
import test.nbaplayers.viewmodel.PlayersViewModel;

public class PlayersFragment extends Fragment implements FragmentManager.OnBackStackChangedListener
{
   boolean isLoading = false;
   private FragmentPlayersBinding binding;

   private final static ArrayList<Player> players = new ArrayList<>();

   PlayersViewModel playersResultViewModel;

   private PlayersListAdapter playersListAdapter;

   private String searchText = "";


   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      // listen to backstack changes
      getActivity().getSupportFragmentManager().addOnBackStackChangedListener(this);
   }
   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      binding = FragmentPlayersBinding.inflate(inflater, container, false);
      View root = binding.getRoot();
      RecyclerView playersRecycleView = binding.playersRecycleView;

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
                                                  (player, view) -> Navigation.findNavController(view).navigate(PlayersFragmentDirections.actionPlayersToPlayer(player)));

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
                  loadMore();
               }
            }
         }
      });

      playersResultViewModel = new ViewModelProvider(this).get(PlayersViewModel.class);
      playersResultViewModel.fetchNextPlayers();
      playersResultViewModel.playersResultLiveData.observe(getViewLifecycleOwner(), playersResult -> {
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
      playersResultViewModel.fetchNextPlayers();
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }

   @Override
   public void onBackStackChanged()
   {
//      if(getActivity() != null) {
//         // enable Up button only if there are entries on the backstack
//         if(getActivity().getSupportFragmentManager().getBackStackEntryCount() < 1) {
//            ((MainActivity)getActivity()).hideUpButton();
//         }
//      }
   }
}