package com.project.schedule.models

import android.widget.TextView

data class Hour (
    val hour: TextView? = null,
    val mins:Array<TextView>? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hour

        if (hour != other.hour) return false
        if (mins != null) {
            if (other.mins == null) return false
            if (!mins.contentEquals(other.mins)) return false
        } else if (other.mins != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hour?.hashCode() ?: 0
        result = 31 * result + (mins?.contentHashCode() ?: 0)
        return result
    }
}