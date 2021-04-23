package com.example.ui.fragments.playlist
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Items
import com.example.model.PlayList
import com.example.extensions.loadImage
import com.example.youtubeapi.databinding.ItemPlaylistBinding

class PlaylistAdapter(
    private val listener: OnPlaylistClick,
    private val playList: PlayList
) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemPlaylistBinding.inflate(LayoutInflater.from(context), parent, false),
            context as Context
        )
    }

    override fun getItemCount() = playList.items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPhoto(playList.items[position])
        holder.itemView.setOnClickListener {
            listener.onPlaylist(playList.items[position].id)
        }
    }

    class ViewHolder(private val view: ItemPlaylistBinding, private val context: Context) :
        RecyclerView.ViewHolder(view.root) {

        fun bindPhoto(item: Items) {
            view.textTitle.text = item.snippet.title
            view.imageView.loadImage(context, item.snippet.thumbnails.default.url)
        }
    }
}