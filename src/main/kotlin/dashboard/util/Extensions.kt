package dashboard.util

fun Float.toString(digits: Int): String = "%.${digits}f".format(this)