package test.nbaplayers.ui.details;

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
import androidx.recyclerview.widget.RecyclerView;
import test.nbaplayers.R;
import test.nbaplayers.databinding.ItemStatsBinding;
import test.nbaplayers.model.Player;
import test.nbaplayers.model.Stats;

public class DetailsListAdapter extends RecyclerView.Adapter<DetailsListAdapter.StatsViewHolder>
{
   private final Context     context;
   private final List<Stats> statsList;
   private String filterString = "";

   ItemStatsBinding binding;

   public DetailsListAdapter(Context context, List<Stats> statsList)
   {
      this.context = context;
      this.statsList = statsList;
   }



   @NonNull
   @Override
   public StatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
   {
//      View view = LayoutInflater.from(parent.getContext())
//                                .inflate(R.layout.item_stats, parent, false);

      binding = ItemStatsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

      View view = binding.getRoot();

      return new StatsViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull StatsViewHolder holder, int position)
   {
      holder.bind(position);
   }

   @Override
   public int getItemCount()
   {
      return statsList.size();
   }


   class StatsViewHolder extends RecyclerView.ViewHolder
   {
      private final TextView seasonTextView;

      public StatsViewHolder(@NonNull View itemView)
      {
         super(itemView);
         seasonTextView = itemView.findViewById(R.id.seasonTextView);
      }

      void bind(int position)
      {
         binding.seasonTextView.setText(statsList.get(position).getPts() != null ? statsList.get(position).getPts().toString() : "0");
         binding.gamesTextView.setText(statsList.get(position).getPts() != null ? statsList.get(position).getPts().toString() : "0");
         binding.pointsTextView.setText(statsList.get(position).getPts() != null ? statsList.get(position).getPts().toString() : "0");
      }
   }

}
