package test.nbaplayers.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import test.nbaplayers.NbaPlayersApplication;
import test.nbaplayers.R;
import test.nbaplayers.model.BallDontLieApiService;
import test.nbaplayers.model.SeasonAverages;
import test.nbaplayers.model.SeasonAveragesResult;

public class SeasonAveragesViewModel extends AndroidViewModel
{
   public MutableLiveData<SeasonAverages> seasonAveragesLiveData = new MutableLiveData<>();
   public MutableLiveData<SeasonAveragesResult> seasonAveragesResultLiveData = new MutableLiveData<>();
   public MutableLiveData<Boolean> seasonAveragesLoadError = new MutableLiveData<>();
   public MutableLiveData<Boolean> loading = new MutableLiveData<>();

   private final BallDontLieApiService ballDontLieApiService;
   private final CompositeDisposable disposable;

   public SeasonAveragesViewModel(@NonNull Application application)
   {
      super(application);

      ballDontLieApiService = new BallDontLieApiService();

      disposable = new CompositeDisposable();
   }

   public void fetch(int playerId)
   {
      loading.setValue(true);
      disposable.add(ballDontLieApiService.getSeasonAverages(playerId)
                                          .subscribeOn(Schedulers.newThread())
                                          .observeOn(AndroidSchedulers.mainThread())
                                          .subscribeWith(new DisposableSingleObserver<SeasonAveragesResult>()
                                          {
                                             @Override
                                             public void onSuccess(@NonNull SeasonAveragesResult seasonAverages)
                                             {
                                                seasonAveragesRetrieved(seasonAverages);
                                             }

                                             @Override
                                             public void onError(@NonNull Throwable e)
                                             {
                                                seasonAveragesLoadError.setValue(true);
                                                loading.setValue(false);
                                                e.printStackTrace();
                                             }
                                          }));
   }

   private void seasonAveragesRetrieved(SeasonAveragesResult seasonAveragesResult)
   {
      seasonAveragesResultLiveData.setValue(seasonAveragesResult);
      if(seasonAveragesResult.getData().size() > 0)
         seasonAveragesLiveData.setValue(seasonAveragesResult.getData()
                                                             .get(0));
      else
         seasonAveragesLiveData.setValue(new SeasonAverages());
      seasonAveragesLoadError.setValue(false);
      loading.setValue(false);
   }

   public void onDetailsClicked(SeasonAverages seasonAverages)
   {
      ((NbaPlayersApplication) getApplication()).getPlayersFlowCoordinator().onDetailsClicked(seasonAverages);
   }

   public void onSeasonAveragesError()
   {
      ((NbaPlayersApplication) getApplication()).getPlayersFlowCoordinator().onDataRetrievingError(getApplication().getString(R.string.error_details));
   }
}
