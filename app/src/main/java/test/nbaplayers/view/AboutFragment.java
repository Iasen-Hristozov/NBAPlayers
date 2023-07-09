package test.nbaplayers.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import test.nbaplayers.databinding.FragmentAboutBinding;
import test.nbaplayers.viewmodel.AboutViewModel;

public class AboutFragment extends Fragment
{
   private FragmentAboutBinding binding;

   public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState)
   {
      binding = FragmentAboutBinding.inflate(inflater, container, false);
      View root = binding.getRoot();

      AboutViewModel aboutViewModel = new ViewModelProvider(this).get(AboutViewModel.class);
      aboutViewModel.getText().observe(getViewLifecycleOwner(), binding.aboutTextView::setText);

      return root;
   }

   @Override
   public void onDestroyView()
   {
      super.onDestroyView();
      binding = null;
   }
}