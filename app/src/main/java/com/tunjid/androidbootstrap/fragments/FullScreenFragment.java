package com.tunjid.androidbootstrap.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tunjid.androidbootstrap.R;
import com.tunjid.androidbootstrap.adapters.EditAdapter;
import com.tunjid.androidbootstrap.baseclasses.AppBaseFragment;
import com.tunjid.androidbootstrap.core.components.KeyboardUtils;

import java.util.Arrays;

/**
 * Fragment showing a static list of images
 * <p>
 * Created by tj.dahunsi on 5/6/17.
 */

public class FullScreenFragment extends AppBaseFragment {

    private final KeyboardUtils keyboardUtils = new KeyboardUtils(this);

    public static FullScreenFragment newInstance() {
        FullScreenFragment fragment = new FullScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fullscreen, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);

        recyclerView.setAdapter(new EditAdapter(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        keyboardUtils.initialize();
        toogleToolbar(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        keyboardUtils.stop();
        toogleToolbar(true);
    }
}
