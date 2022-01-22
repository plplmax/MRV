package com.github.plplmax.mrv.di;

import android.content.Context;

import com.github.plplmax.mrv.domain.interactors.FetchCharactersWithLimitInteractor;
import com.github.plplmax.mrv.domain.interactors.FetchCharactersWithOffsetInteractor;
import com.github.plplmax.mrv.ui.MainViewModelFactory;
import com.github.plplmax.mrv.ui.core.ResourceProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    public Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    MainViewModelFactory provideMainViewModelFactory(
            FetchCharactersWithOffsetInteractor fetchCharactersWithOffset,
            FetchCharactersWithLimitInteractor fetchCharactersWithLimit) {
        return new MainViewModelFactory(fetchCharactersWithOffset, fetchCharactersWithLimit);
    }

    @Provides
    @Singleton
    ResourceProvider provideResourceProvider(Context context) {
        return new ResourceProvider.Base(context);
    }
}
