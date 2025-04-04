package br.com.alexandremarcondes.walletmanager

import android.app.Application
import br.com.alexandremarcondes.walletmanager.data.Memory

class MainApp : Application() {
    companion object {
        val memory = Memory()
    }
}