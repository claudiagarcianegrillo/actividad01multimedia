package com.example.actividad01multimedia.views

import android.util.Log
import com.example.actividad01multimedia.data.Client
import com.example.actividad01multimedia.logic.TAG

enum class Action { ADD, UPDATE, DELETE }

class ClientDialog(
    private val onAdd: (Int, String) -> Unit,
    private val onDel: (Int) -> Unit,
    private val onUpdate: (Int, String) -> Unit
) {
    fun show(action: Action, clients: List<Client>, newId: Int) {
        Log.d(TAG, "Diálogo abierto: $action")
        when (action) {
            Action.ADD -> onAdd(newId, "Cliente$newId")
            Action.UPDATE -> clients.randomOrNull()?.let { onUpdate(it.id, "CAMBIADO") }
            Action.DELETE -> clients.randomOrNull()?.let { onDel(it.id) }
        }
    }
}