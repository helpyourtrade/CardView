package examples.com.cardview;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Album> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();

    list = new ArrayList<>();
        prepareAlbum();
        AlbumAdapter obj= new AlbumAdapter(list,this);
        RecyclerView.LayoutManager  o = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(o);
        recyclerView.setAdapter(obj);
        Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
    }

    private void prepareAlbum() {
        int[] as = new int[]{R.drawable.album1,
        R.drawable.album2,R.drawable.album3,
        R.drawable.album4,
        R.drawable.album5,
        R.drawable.album6,
        R.drawable.album7,
        R.drawable.album8,
        R.drawable.album9,};

        Album a= new Album("Romanc",20,as[0]);
        list.add(a);
        a= new Album("Love",10,as[1]);
        list.add(a);
        a= new Album("horroe",5,as[2]);
        list.add(a); a= new Album("mysterRomanc",50,as[3]);

        
        list.add(a); a= new Album("fanstaw",40,as[4]);
        list.add(a); a= new Album("thirller",30,as[5]);
        list.add(a); a= new Album("drama",60,as[6]);
        list.add(a); a= new Album("action",40,as[7]);
        list.add(a); a= new Album("adventure",10,as[8]);
        list.add(a);




    }

    private void initCollapsingToolbar() {

        final CollapsingToolbarLayout collapsingToolbar= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
           collapsingToolbar.setTitle("Hello First");
        AppBarLayout appbar= (AppBarLayout) findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange==-1){
                    scrollRange =appBarLayout.getTotalScrollRange();
                    Log.i("scrol range","-1");
                }
                if(scrollRange+verticalOffset==0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    Log.d("scrolrange","0");
                    isShow = true;


                }else if(isShow){

                    collapsingToolbar.setTitle("Hello Second");
                    Log.d("scrol range when iftrue",isShow+"0");

                    isShow=false;
                    Log.d("scrol range",isShow+"0");
                }
            }
        });

    }


}
