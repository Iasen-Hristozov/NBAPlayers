package test.nbaplayers.ui.players;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import test.nbaplayers.R;
import test.nbaplayers.model.Player;

public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.RepositoryViewHolder>
{
   private final List<Player>           playerList;
//   private final PlayersResultViewModel playersResultViewModel;

//   public PlayersListAdapter(List<Player> repositoriesList, PlayersResultViewModel repositoryViewModel)
   public PlayersListAdapter(List<Player> repositoriesList)
   {
      this.playerList = repositoriesList;
//      this.playersResultViewModel = repositoryViewModel;
   }

   @NonNull
   @Override
   public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
   {
      View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_player, parent, false);

      return new RepositoryViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position)
   {
      holder.getPlayerTextView().setText(String.format("%s %s",
                                                       playerList.get(position)
                                                                 .getFirstName(),
                                                       playerList.get(position)
                                                                 .getLastName()));
      holder.itemView.setOnClickListener(v -> {
               Player player = playerList.get(position);
//               playersResultViewModel.fetchContributorsFromRemote(player.getOwner().getLogin(), player.getName());
//               playersResultViewModel.setRepositoryLiveData(player);
//               Navigation.findNavController(v).navigate(R.id.action_user_to_repository);
      });
   }

   @Override
   public int getItemCount()
   {
      return playerList.size();
   }


   static class RepositoryViewHolder extends RecyclerView.ViewHolder
   {
      private final TextView playerTextView;

      public RepositoryViewHolder(@NonNull View itemView)
      {
         super(itemView);
         playerTextView = itemView.findViewById(R.id.playerTextView);
      }

      public TextView getPlayerTextView()
      {
         return playerTextView;
      }
   }
}
