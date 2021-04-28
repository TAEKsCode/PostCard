package com.onix.postcard.data.source.image.impl.image

import android.content.Context
import com.onix.postcard.BuildConfig
import com.onix.postcard.data.source.image.impl.AssetsImageSource

class ImplImagesSource(context: Context) : AssetsImageSource(context, BuildConfig.IMAGES_PATH)