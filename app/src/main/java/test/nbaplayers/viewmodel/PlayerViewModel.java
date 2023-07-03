package test.nbaplayers.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlayerViewModel extends ViewModel
{

   private final MutableLiveData<String> mText;

   public PlayerViewModel()
   {
      mText = new MutableLiveData<>();
      mText.setValue("This is notifications fragment");
   }

   public LiveData<String> getText()
   {
      return mText;
   }
}