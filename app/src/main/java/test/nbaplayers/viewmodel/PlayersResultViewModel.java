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
import test.nbaplayers.model.PlayersResult;

public class PlayersResultViewModel extends AndroidViewModel
{
   public MutableLiveData<PlayersResult> playersResultLiveData  = new MutableLiveData<>();
   public MutableLiveData<Boolean>       playersResultLoadError = new MutableLiveData<>();
   public MutableLiveData<Boolean>       loading                = new MutableLiveData<>();


   private final BallDontLieApiService ballDontLieApiService;
   private final CompositeDisposable   disposable;

   public PlayersResultViewModel(@NonNull Application application)
   {
      super(application);

      ballDontLieApiService = new BallDontLieApiService();

      disposable = new CompositeDisposable();
   }

   public void fetchFromRemote(int page, int perPage)
   {
      loading.setValue(true);
      disposable.add(ballDontLieApiService.getPlayersResult(page, perPage)
                                          .subscribeOn(Schedulers.newThread())
                                          .observeOn(AndroidSchedulers.mainThread())
                                          .subscribeWith(new DisposableSingleObserver<PlayersResult>()
                                           {
                                              @Override
                                              public void onSuccess(@NonNull PlayersResult playersResult)
                                              {
                                                 playersResultRetrieved(playersResult);
                                              }

                                              @Override
                                              public void onError(@NonNull Throwable e)
                                              {
                                                 playersResultLoadError.setValue(true);
                                                 loading.setValue(false);
                                                 e.printStackTrace();
                                              }
                                           }));
   }

   private void playersResultRetrieved(PlayersResult playersResult)
   {
      playersResultLiveData.setValue(playersResult);
      playersResultLoadError.setValue(false);
      loading.setValue(false);
   }
}
