package com.fotomama.mneumann.fotomama.Entities

import com.fotomama.mneumann.fotomama.R
import java.io.Serializable

/**
 * Created by mneumann on 12.10.2017.
 */
class MainCard : Serializable{
    public var photoId: Int = 0
    private var title: String ="Title"
    private var description: String = "Description"

    init {
        photoId = R.drawable.bremen_teerhof
        title = "Test"
        description = "description"
    }


}