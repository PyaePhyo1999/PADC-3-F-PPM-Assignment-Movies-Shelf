package com.pyaephyomaung.padcmyanmar.movieshelf.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.pyaephyomaung.padcmyanmar.movieshelf.Delegate.MoviesActionDelegate;
import com.pyaephyomaung.padcmyanmar.movieshelf.MoviesApp;
import com.pyaephyomaung.padcmyanmar.movieshelf.R;
import com.pyaephyomaung.padcmyanmar.movieshelf.adapters.MoviesAdapter;
import com.pyaephyomaung.padcmyanmar.movieshelf.data.models.MoviesModel;
import com.pyaephyomaung.padcmyanmar.movieshelf.events.LoadedMoviesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoviesActionDelegate {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private MoviesAdapter mMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setSupportActionBar(toolbar);
        ButterKnife.bind(this,this);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mMoviesAdapter = new MoviesAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvMovie.setLayoutManager(linearLayoutManager);
        rvMovie.setAdapter(mMoviesAdapter);
        MoviesModel.getsObjectInstance().loadMovies();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapItemView() {
        Intent intent = new Intent(getApplicationContext(),MovieDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapMovieOverView() {

    }
    @Subscribe ( threadMode = ThreadMode.MAIN)
    public void onMoviesEvent(LoadedMoviesEvent event){
        Log.d(MoviesApp.LOG_TAG ,"onMoviesLoaded"+event.getMoviesList().size());
            mMoviesAdapter.setMovies(event.getMoviesList());

    }

}
