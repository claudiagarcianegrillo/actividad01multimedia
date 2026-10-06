package com.example.actividad01multimedia.views

import android.util.Log
import com.example.actividad01multimedia.data.Client
import com.example.actividad01multimedia.logic.TAG
import com.example.actividad01multimedia.logic.interfaces.ClientCrud


enum class Action { ADD, UPDATE, DELETE }

class ClientDialog {
    private var listener: ClientCrud? = null

    fun setListener(listener: ClientCrud) {
        this.listener = listener
    }

    fun show(action: Action, clients: List<Client>, newId: Int) {
        Log.d(TAG, "Diálogo abierto: $action")
        when (action) {
            Action.ADD -> listener?.clientAdd(newId, "Cliente$newId")
            Action.UPDATE -> clients.randomOrNull()?.let { listener?.clientUpdate(it.id, "CAMBIADO") }
            Action.DELETE -> clients.randomOrNull()?.let { listener?.clientDel(it.id) }
        }
    }
}