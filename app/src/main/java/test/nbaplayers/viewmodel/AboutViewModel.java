package test.nbaplayers.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import test.nbaplayers.BuildConfig;

public class AboutViewModel extends ViewModel
{
   private final MutableLiveData<String> text;

   public AboutViewModel()
   {
      text = new MutableLiveData<>();
      String version = BuildConfig.VERSION_NAME + "." +BuildConfig.BUILD_TIME;
      text.setValue(version);
   }

   public LiveData<String> getText()
   {
      return text;
   }
}