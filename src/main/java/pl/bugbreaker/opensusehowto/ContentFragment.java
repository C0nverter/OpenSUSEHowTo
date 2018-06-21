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
    View v;
    RecyclerView recyclerView;
    Utils u = new Utils();
    RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());

    public ContentFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.content_fragment,container,false);
        adapter = new ContentAdapter(getContext(), u.getItemLoaded());
        recyclerView = v.findViewById(R.id.content_rv);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        return v;
    }
}
