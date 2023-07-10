package test.nbaplayers.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import test.nbaplayers.R;
import test.nbaplayers.model.SeasonAverages;

public class ErrorDialogFragment extends DialogFragment
{
   @NonNull
   @Override
   public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
      super.onCreateDialog(savedInstanceState);

      String error = getArguments() != null ? ErrorDialogFragmentArgs.fromBundle(getArguments()).getError() : getString(R.string.title_error);

      return new AlertDialog.Builder(requireContext())
            .setTitle(R.string.title_error)
            .setMessage(error)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton(getString(android.R.string.ok), (dialog, which) -> {} )
            .create();
   }
}
