package com.srx.musicplayer.MusicList;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srx.musicplayer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class musicListPageFragment extends Fragment {


    public musicListPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list_page, container, false);
    }

}
