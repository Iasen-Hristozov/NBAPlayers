package test.nbaplayers.ui.players;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import test.nbaplayers.R;
import test.nbaplayers.model.Player;

public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.PlayerViewHolder>
{
   private final Context      context;
   private final List<Player> playersList;
   private final PlayersListAdapterListener listener;

   List<Player> visiblePlayersList = new ArrayList<>();
   private String filterString = "";
//   private final PlayersResultViewModel playersResultViewModel;

//   public PlayersListAdapter(List<Player> repositoriesList, PlayersResultViewModel repositoryViewModel)
   public PlayersListAdapter(Context context, List<Player> playersList, PlayersListAdapterListener listener)
   {
      this.context = context;
      this.playersList = playersList;
      this.visiblePlayersList.addAll(playersList);
      this.listener = listener;
//      this.playersResultViewModel = repositoryViewModel;
   }

   public interface PlayersListAdapterListener
   {
      void onPlayerSelected(Player player, View view);
   }


   @NonNull
   @Override
   public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
   {
      View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_player, parent, false);

      return new PlayerViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position)
   {
      holder.bind(position);

//      holder.getPlayerTextView().setText(String.format("%s %s",
//                                                       playersList.get(position)
//                                                                 .getFirstName(),
//                                                       playersList.get(position)
//                                                                 .getLastName()));


//      holder.itemView.setOnClickListener(v -> {
//               Player player = visiblePlayersList.get(position);
////               playersResultViewModel.fetchContributorsFromRemote(player.getOwner().getLogin(), player.getName());
////               playersResultViewModel.setRepositoryLiveData(player);
//         PlayersFragmentDirections.ActionPlayersToPlayer action  = PlayersFragmentDirections.actionPlayersToPlayer(player);
////               Navigation.findNavController(v).navigate(R.id.action_players_to_player);
//         Navigation.findNavController(v).navigate(action);
//      });

      holder.itemView.setOnClickListener(v -> {
         listener.onPlayerSelected(visiblePlayersList.get(position), v);
      });
   }

   @Override
   public int getItemCount()
   {
//      return playersList.size();
      return visiblePlayersList.size();
   }


   class PlayerViewHolder extends RecyclerView.ViewHolder
   {
      private final TextView playerTextView;

      public PlayerViewHolder(@NonNull View itemView)
      {
         super(itemView);
         playerTextView = itemView.findViewById(R.id.playerTextView);
      }

      public TextView getPlayerTextView()
      {
         return playerTextView;
      }

      void bind(int position)
      {
         String text = visiblePlayersList.get(position).getFirstName() + " " + visiblePlayersList.get(position).getLastName();
         Spannable contentSpannable = new SpannableString(text);
         int filteredStart = text.toLowerCase(Locale.getDefault()).indexOf(filterString.toLowerCase(Locale.getDefault()));
         int filterEnd;
         if(filteredStart < 0)
         {
            filteredStart = 0;
            filterEnd = 0;
         }
         else
            filterEnd = filteredStart + filterString.length();
         contentSpannable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.purple_200)),
                                  filteredStart,
                                  filterEnd,
                                  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
         playerTextView.setText(contentSpannable);
      }
   }



   public void filter(String charText)
   {
      charText = charText.toLowerCase(Locale.getDefault());
      filterString = charText;

      ArrayList<Player> playersListTmp = new ArrayList<>();
      visiblePlayersList.clear();
      if(charText.length() == 0)
      {
         visiblePlayersList.addAll(playersList);
      }
      else
      {
         String name;
         for(Player player : playersList)
         {
            if(player.getFirstName().toLowerCase(Locale.getDefault()).contains(charText)
              || player.getLastName().toLowerCase(Locale.getDefault()).contains(charText))
            {
               playersListTmp.add(player);
            }
         }
         visiblePlayersList.addAll(playersListTmp);
      }
      notifyDataSetChanged();
   }
}
