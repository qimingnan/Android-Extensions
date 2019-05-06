package com.tunjid.androidbootstrap.navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;

import com.tunjid.androidbootstrap.core.components.FragmentStateManager;
import com.tunjid.androidbootstrap.functions.BiFunction;
import com.tunjid.androidbootstrap.functions.Function;

public class FragmentStateNavigator extends Navigator<Destination> {

    private FragmentStateManager stateManager;
    private Function<Fragment, String> fragmentTagFunction;
    private BiFunction<Fragment, Fragment, FragmentTransaction> transactionBiFunction;

    @NonNull
    @Override
    public Destination createDestination() {
        return null;
    }

    @Nullable
    @Override
    public NavDestination navigate(@NonNull Destination destination,
                                   @Nullable Bundle args,
                                   @Nullable NavOptions navOptions,
                                   @Nullable Extras navigatorExtras) {
//        if (mFragmentManager.isStateSaved()) {
//            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already"
//                    + " saved its state");
//            return null;
//        }


        Fragment currentFragment = stateManager.getCurrentFragment();
        Fragment destinationRoute = destination.getRoute();
        destinationRoute.setArguments(args);

        FragmentTransaction transaction = transactionBiFunction.apply(currentFragment, destinationRoute);
        transaction.setPrimaryNavigationFragment(destinationRoute);

        return stateManager.showFragment(transaction, destinationRoute, fragmentTagFunction.apply(destinationRoute))
                ? destination : null;
    }

    @Override
    public boolean popBackStack() {
        return false;
    }

    @Nullable
    @Override
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        stateManager.onSaveInstanceState(bundle);

        return bundle;
    }

    @Override
    public void onRestoreState(@NonNull Bundle savedState) {
        stateManager.onRestoreInstanceState(savedState);
    }
}
