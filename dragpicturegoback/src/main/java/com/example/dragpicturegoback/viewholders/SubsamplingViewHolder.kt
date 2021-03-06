package com.example.dragpicturegoback.viewholders

import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.example.dragpicturegoback.ImageViewerAdapterListener
import com.example.dragpicturegoback.R
import com.example.dragpicturegoback.bean.ItemBean
import com.example.dragpicturegoback.utils.Config
import com.example.dragpicturegoback.utils.saveBitmapFile
import com.example.dragpicturegoback.utils.toast
import com.example.dragpicturegoback.widgets.SubsamplingScaleImageView2
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_imageviewer_subsampling.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class SubsamplingViewHolder(override val containerView: View, callback: ImageViewerAdapterListener) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    init {
        subsamplingView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE)
        subsamplingView.setListener(object : SubsamplingScaleImageView2.Listener {
            override fun onDrag(view: SubsamplingScaleImageView2, fraction: Float) = callback.onDrag(this@SubsamplingViewHolder, view, fraction)
            override fun onRestore(view: SubsamplingScaleImageView2, fraction: Float) = callback.onRestore(this@SubsamplingViewHolder, view, fraction)
            override fun onRelease(view: SubsamplingScaleImageView2) = callback.onRelease(this@SubsamplingViewHolder, view)
        })

        subsamplingView.setOnClickListener{
            callback.onClick(this@SubsamplingViewHolder,subsamplingView)
        }
    }

    fun bind(item: ItemBean) {
        subsamplingView.setTag(R.id.viewer_adapter_item_data, item)
        subsamplingView.setTag(R.id.viewer_adapter_item_key, item.id)
        subsamplingView.setTag(R.id.viewer_adapter_item_holder, this)

        GlobalScope.launch(Dispatchers.Main) {
            val fileMain = withContext(Dispatchers.IO){
                val fileName = "data_subsampling_${item.id}"
                val file = File(subsamplingView.context.cacheDir, fileName)
                if (!file.exists()) {
                    try {
                        val s: Bitmap = Glide.with(subsamplingView.context).asBitmap().load(item.url).submit().get()
                        saveBitmapFile(s, file)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        e.message?.let(::toast)
                    }
                }
                file
            }
            subsamplingView.setImage(ImageSource.uri(Uri.fromFile(fileMain)))
        }

    }
}


