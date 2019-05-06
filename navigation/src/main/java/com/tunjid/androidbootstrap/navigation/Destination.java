package com.tunjid.androidbootstrap.navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;

@NavDestination.ClassType(Fragment.class)
public class Destination extends NavDestination {

   private Fragment route;

    public Destination(@NonNull Navigator<? extends Destination> fragmentNavigator) {
        super(fragmentNavigator);
    }

    boolean isEmpty() { return route == null; }

    public Fragment getRoute() { return route; }
}
