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
import test.nbaplayers.model.Meta;
import test.nbaplayers.model.PlayersResult;

public class PlayersViewModel extends AndroidViewModel
{
   private final static int PLAYERS_NUMBER = 25;
   private int page;
   private Meta meta = null;
   public MutableLiveData<PlayersResult> playersResultLiveData = new MutableLiveData<>();
   public MutableLiveData<Boolean> playersResultLoadError = new MutableLiveData<>();
   public MutableLiveData<Boolean> loading = new MutableLiveData<>();


   private final BallDontLieApiService ballDontLieApiService;
   private final CompositeDisposable disposable;

   public PlayersViewModel(@NonNull Application application)
   {
      super(application);

      page = 1;

      ballDontLieApiService = new BallDontLieApiService();

      disposable = new CompositeDisposable();
   }

   public void fetchNextPlayers()
   {
      if(meta != null && page > meta.getTotalPages())
         return;
      loading.setValue(true);
      disposable.add(ballDontLieApiService.getPlayersResult(PLAYERS_NUMBER, page)
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
      if(meta == null)
         meta = playersResult.getMeta();
      page++;
      playersResultLiveData.setValue(playersResult);
      playersResultLoadError.setValue(false);
      loading.setValue(false);
   }
}
