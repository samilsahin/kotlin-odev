package com.bekirahmetli.bitirmeprojesi.util

import android.content.Context

object FavoriManager {
    private const val PREF_NAME = "favoriler"
    private const val KEY_FAVORILER = "favoriler"

    fun getFavoriler(context: Context): MutableSet<String> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_FAVORILER, mutableSetOf()) ?: mutableSetOf()
    }

    fun favoriEkle(context: Context, yemekId: String) {
        val favoriler = getFavoriler(context)
        favoriler.add(yemekId)
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit().putStringSet(KEY_FAVORILER, favoriler).apply()
    }

    fun favoriKaldir(context: Context, yemekId: String) {
        val favoriler = getFavoriler(context)
        favoriler.remove(yemekId)
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit().putStringSet(KEY_FAVORILER, favoriler).apply()
    }

    fun isFavori(context: Context, yemekId: String): Boolean {
        return getFavoriler(context).contains(yemekId)
    }
}