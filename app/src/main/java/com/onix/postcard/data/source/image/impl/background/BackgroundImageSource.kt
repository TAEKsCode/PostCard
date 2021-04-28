package com.onix.postcard.data.source.image.impl.background

import android.content.Context
import com.onix.postcard.BuildConfig
import com.onix.postcard.data.source.image.impl.AssetsImageSource

class BackgroundImageSource(context: Context): AssetsImageSource(context, BuildConfig.BACKGROUND_PATH)