package pl.bugbreaker.opensusehowto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ArticleFragment extends Fragment {

    ArticleAdapter adapter;
    Utils u = Utils.getInstance();
    private static final String TAG = "ArticleFragment";
    protected ArrayList<Article> articleSet;
    protected RecyclerView.LayoutManager lm;
    protected RecyclerView recyclerView;

    public ArticleFragment() {
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
        View v = inflater.inflate(R.layout.article_fragment,container,false);
        v.setTag(TAG);
        recyclerView = v.findViewById(R.id.article_rv);
        lm = new LinearLayoutManager(getActivity());
        adapter = new ArticleAdapter(articleSet);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public void initData() {
        articleSet = u.getArticleSet();
    }
}
