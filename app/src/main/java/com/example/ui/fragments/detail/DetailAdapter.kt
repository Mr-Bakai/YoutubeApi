package com.example.ui.fragments.detail
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.loadImage
import com.example.model.playlistItems.Items
import com.example.model.playlistItems.PlayListItems
import com.example.youtubeapi.databinding.ItemPlaylistItemBinding

class DetailAdapter(
    private val listener: OnPlaylistItemClick,
    private val playListItems: PlayListItems
) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemPlaylistItemBinding.inflate(LayoutInflater.from(context), parent, false),
            context as Context
        )
    }

    override fun getItemCount() = playListItems.items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPhoto(playListItems.items[position])
    }

    class ViewHolder(private val view: ItemPlaylistItemBinding, private val context: Context):
        RecyclerView.ViewHolder(view.root) {

        fun bindPhoto(item: Items) {
            view.textTitle.text = item.snippet.title
            view.imageView.loadImage(context, item.snippet.thumbnails.default.url)
        }
    }
}