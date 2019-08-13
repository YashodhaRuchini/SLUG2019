package lk.uordcs.slug;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lk.uordcs.slug.R;

public class TabG1Fragment extends Fragment {
    private static final String TAG="TabG1fragment";

    CardView hundred;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tabg1_fragment,container,false);

        hundred=(CardView)view.findViewById(R.id.hundred);
        hundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().setContentView(R.layout.running_result_card);
            }
        });

        return view;

    }
}
