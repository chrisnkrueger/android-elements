package com.placebox.androidx.sample

import com.placebox.androidx.widget.recyclerview.diff.Diffable

data class TextItem(
    val id: Long,
    val text: String
) : Diffable {

    override fun isItemTheSame(other: Any): Boolean = other is TextItem && id == other.id

    override fun isContentTheSame(other: Any): Boolean =
        other is TextItem && id == other.id && text == other.text

}
