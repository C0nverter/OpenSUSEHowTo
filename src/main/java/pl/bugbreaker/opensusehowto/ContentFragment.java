package pl.bugbreaker.opensusehowto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ContentFragment extends Fragment {

    ContentAdapter adapter;
    Utils u = new Utils();
    LinearLayoutManager lm = new LinearLayoutManager(getContext());

    public ContentFragment() {
        //empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        adapter = new ContentAdapter(getActivity(), u.getDataSet());
        RecyclerView recyclerView = v.findViewById(R.id.content_rv);
        Log.d("Fragment","RecyclerView added");
        recyclerView.setLayoutManager(lm);
        Log.d("Fragment","LayoutManager is set");
        recyclerView.setAdapter(adapter);
        Log.d("Fragment","Adapter is set");
        return v;
    }
}
