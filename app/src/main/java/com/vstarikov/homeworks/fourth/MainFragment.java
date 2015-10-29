package com.vstarikov.homeworks.fourth;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vstarikov.homeworks.R;

/**
 * Created by vladstarikov on 29.10.15.
 */
public class MainFragment extends Fragment {

    SelectorInterface selectorInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        selectorInterface = (SelectorInterface) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectorInterface.next();
            }
        });

        view.findViewById(R.id.buttonPrevious).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectorInterface.previous();
            }
        });
    }
}
