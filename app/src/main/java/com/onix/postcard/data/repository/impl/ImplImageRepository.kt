package com.onix.postcard.data.repository.impl

import android.graphics.drawable.Drawable
import com.onix.postcard.data.repository.ImageRepository
import com.onix.postcard.data.source.image.ImageSource

class ImplImageRepository(
    private val imageSource: ImageSource,
    private val backgroundSource: ImageSource
) : ImageRepository {
    override fun getImage(imageName: String): Drawable {
        return imageSource.getDrawable(imageName)
    }

    override fun getBackground(backgroundName: String): Drawable {
        return backgroundSource.getDrawable(backgroundName)
    }

    fun imagesList() = imageSource.list()

    fun backgroundsList() = backgroundSource.list()
}
