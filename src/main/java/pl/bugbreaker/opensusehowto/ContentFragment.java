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

import java.util.ArrayList;

public class ContentFragment extends Fragment {

    ContentAdapter adapter;
    Utils u = Utils.getInstance();
    private static final String TAG = "ContentFragment";
    protected ArrayList<DataItem> dataSet;
    protected RecyclerView.LayoutManager lm;
    protected RecyclerView recyclerView;

    public ContentFragment() {
        //empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        v.setTag(TAG);
        recyclerView = v.findViewById(R.id.content_rv);
        Log.d("Fragment","RecyclerView added");
        lm = new LinearLayoutManager(getActivity());
        adapter = new ContentAdapter(dataSet);
        recyclerView.setLayoutManager(lm);
        Log.d("Fragment","LayoutManager is set");
        recyclerView.setAdapter(adapter);
        Log.d("Fragment","Adapter is set");
        return v;
    }

    public void initData() {
        dataSet = u.getDataSet();
    }
}
