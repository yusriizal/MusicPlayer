package com.android.example.musicplayer

import android.os.Environment
import java.io.File
import java.io.FilenameFilter
import java.util.*

class SongsManager {

    var MEDIA_PATH = Environment.getExternalStorageDirectory().toString()
    private val songsList = ArrayList<HashMap<String, String>>()

    fun getPlayList(): ArrayList<HashMap<String, String>> {
        val home = File(MEDIA_PATH)
        if (home.listFiles(FileExtensionFilter()).size<1) {
            for (file in home.listFiles(FileExtensionFilter())) {
                val song = HashMap<String, String>()
                song["songTitle"] = file.name.substring(0, file.name.length - 4)
                song["songPath"] = file.path
                songsList.add(song)
            }
        }
        return songsList
    }

    internal inner class FileExtensionFilter : FilenameFilter {
        override fun accept(dir: File, name: String): Boolean {
            return name.endsWith(".mp3") || name.endsWith(".MP3")
        }
    }

}