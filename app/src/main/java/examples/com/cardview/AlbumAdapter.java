package examples.com.cardview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

import static android.R.attr.thumbnail;

/**
 * Created by RaoArsalan on 2/4/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder>{
    private List<Album> album;
    private Context context;
     public AlbumAdapter(List<Album> album,Context context){
         this.album=album;
         this.context=context;
     }

    @Override
    public AlbumAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
      View v= inflater.inflate(R.layout.album_card,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AlbumAdapter.MyViewHolder holder, int position) {
       // holder.thumbnail.setImageResource(album.get(position).getThumbnail());
        holder.title.setText(album.get(position).getName());
        holder.count.setText(album.get(position).getNumberOfSongs()+"");
        Glide.with(context).load(album.get(position).getThumbnail()).into(holder.thumbnail);
        holder.overflowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp(holder.overflowMenu);
            }
        });
    }

    private void showPopUp(View view) {

        PopupMenu menu = new PopupMenu(context,view);
        MenuInflater inflater = menu.getMenuInflater();
        inflater.inflate(R.menu.menu_album, menu.getMenu());
        menu.setOnMenuItemClickListener(new MenuItemclass());
        menu.show();
    }

    @Override
    public int getItemCount() {
        return album.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       public ImageView thumbnail,overflowMenu;
        public TextView title,count;
        public MyViewHolder(View itemView) {
            super(itemView);
        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail) ;
            overflowMenu = (ImageView) itemView.findViewById(R.id.overflow);
            title = (TextView) itemView.findViewById(R.id.title);
            count = (TextView) itemView.findViewById(R.id.count);
        }

    }

    private class MenuItemclass implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.action_add_favourite:
                Toast.makeText(context, "add favourite", Toast.LENGTH_SHORT).show();
                return true;
                case R.id.action_play_next:
                    Toast.makeText(context,"play next",Toast.LENGTH_SHORT).show();

            return true;
                default:
            }
            return false;
        }
    }
}
