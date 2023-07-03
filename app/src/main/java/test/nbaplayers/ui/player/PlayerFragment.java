package test.nbaplayers.ui.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import test.nbaplayers.databinding.FragmentPlayerBinding;
import test.nbaplayers.viewmodel.PlayerViewModel;

public class PlayerFragment extends Fragment
{

   private FragmentPlayerBinding binding;

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      PlayerViewModel notificationsViewModel =
            new ViewModelProvider(this).get(PlayerViewModel.class);

      binding = FragmentPlayerBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

      final TextView textView = binding.textNotifications;
      notificationsViewModel.getText()
                            .observe(getViewLifecycleOwner(), textView::setText);
      return root;
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}