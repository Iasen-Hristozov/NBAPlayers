package test.nbaplayers.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import test.nbaplayers.model.BallDontLieApiService;
import test.nbaplayers.model.StatsResult;

public class StatsResultViewModel extends AndroidViewModel
{
   public MutableLiveData<StatsResult> statsResultLiveData  = new MutableLiveData<>();
   public MutableLiveData<Boolean>     statsResultLoadError = new MutableLiveData<>();
   public MutableLiveData<Boolean>     loading              = new MutableLiveData<>();


   private final BallDontLieApiService ballDontLieApiService;
   private final CompositeDisposable   disposable;

   public StatsResultViewModel(@NonNull Application application)
   {
      super(application);

      ballDontLieApiService = new BallDontLieApiService();

      disposable = new CompositeDisposable();
   }

   public void fetchFromRemote(int playerId)
   {
      loading.setValue(true);
      disposable.add(ballDontLieApiService.getStatsResult(playerId)
                                          .subscribeOn(Schedulers.newThread())
                                          .observeOn(AndroidSchedulers.mainThread())
                                          .subscribeWith(new DisposableSingleObserver<StatsResult>()
                                           {
                                              @Override
                                              public void onSuccess(@NonNull StatsResult statsResult)
                                              {
                                                 statsResultRetrieved(statsResult);
                                              }

                                              @Override
                                              public void onError(@NonNull Throwable e)
                                              {
                                                 statsResultLoadError.setValue(true);
                                                 loading.setValue(false);
                                                 e.printStackTrace();
                                              }
                                           }));
   }

   private void statsResultRetrieved(StatsResult statsResult)
   {
      statsResultLiveData.setValue(statsResult);
      statsResultLoadError.setValue(false);
      loading.setValue(false);
   }
}
