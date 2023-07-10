package test.nbaplayers;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class SingleLiveData<T> extends MutableLiveData<T>
{
   @Override
   public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer)
   {
      super.observe(owner, t -> {
         if (t != null) {
            observer.onChanged(t);
            postValue(null);
         }
      });
   }
}
