package com.example.actividad01multimedia.logic

import android.util.Log
import com.example.actividad01multimedia.data.Client
import com.example.actividad01multimedia.data.ClientRepository

const val TAG = "CLIENTES"

class ClientController {
    private val clients: MutableList<Client> = ClientRepository.clients.toMutableList()
    private var nextId = (clients.maxOfOrNull { it.id } ?: 99) + 1

    fun getAll(): List<Client> = clients.toList()
    fun newId(): Int = nextId++

    fun add(id: Int, name: String) {
        clients.add(Client(id, name))
        Log.d(TAG, "El cliente con id = $id, ha sido insertado correctamente")
        Log.d(TAG, clients.toString())
    }

    fun update(id: Int, name: String) {
        val i = clients.indexOfFirst { it.id == id }
        if (i != -1) {
            clients[i] = clients[i].copy(name = name)
            Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
        }
        Log.d(TAG, clients.toString())
    }

    fun delete(id: Int) {
        if (clients.removeAll { it.id == id }) {
            Log.d(TAG, "El cliente con id = $id, ha sido eliminado correctamente")
        }
        Log.d(TAG, clients.toString())
    }
}