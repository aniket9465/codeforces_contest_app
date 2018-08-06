package com.example.aniket.codeforces;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.StrictMath.abs;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contestlist;
    private Radapter ra;
    ArrayList<Pair<String,String>> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contestlist=(RecyclerView)findViewById(R.id.list);
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://codeforces.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
        api_interface apiservice=retrofit.create(api_interface.class);
        Call<Contests> call = apiservice.get_contests();
        ra=new Radapter(list);
        contestlist.setAdapter(ra);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contestlist.setLayoutManager(layoutManager);
        call.enqueue(new Callback<Contests>() {
            @Override
            public void onResponse(Call<Contests> call, Response<Contests> response) {
                result[] res=response.body().getResult();
                for(int i=0;i<Array.getLength(res);i++)
                {
                    if(res[i].getPhase().equals("BEFORE"))
                    {
                       list.add(new Pair<>((res[i].getName()),(abs((Long.parseLong(res[i].getRelativeTimeSeconds())/(3600*24)))+" days "+abs((Long.parseLong(res[i].getRelativeTimeSeconds())%(3600*24))/3600)+" hours "+abs((Long.parseLong(res[i].getRelativeTimeSeconds())%(3600))/60)+" minutes\n")));
                    }

                }
                Collections.reverse(list);
                ra.notifyData(list);

            }

            @Override
            public void onFailure(Call<Contests> call, Throwable t) {
                Log.d("TAG","failed");
            }
        });
       // contests.setText(contest_list);
    }
    public class Radapter extends RecyclerView.Adapter<Radapter.itemviewholder>
    {
        int last=0;
        private ArrayList<Pair<String,String>> list;
        public Radapter(ArrayList<Pair<String,String>> list)
        {
            this.list=list;
            last=list.size();
        }
        public void notifyData(ArrayList<Pair<String,String>> myList) {
            Log.d("notifyData ", myList.size() + "");
            this.list = myList;
            notifyDataSetChanged();
        }


        public Radapter.itemviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.contest_entry,parent,false);
            itemviewholder v=new itemviewholder(view);
            return v;
        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }
        @Override
        public void onBindViewHolder(itemviewholder holder, int position) {
            Log.d("TAG","bind");
            holder.timeleft.setText(list.get(position).second);
            holder.contestname.setText(list.get(position).first);
        }

        public class itemviewholder extends RecyclerView.ViewHolder
        {
            private  TextView contestname;
            private  TextView timeleft;
            public itemviewholder(final View parent)
            {
                super(parent);
                contestname=(TextView)parent.findViewById(R.id.contestname);
                timeleft=(TextView)parent.findViewById(R.id.timeleft);
            }
        }
    }
}
