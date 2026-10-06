package com.example.actividad01multimedia.logic.interfaces

interface ClientCrud {
    fun clientAdd(id: Int, name: String)
    fun clientDel(id: Int)
    fun clientUpdate(id: Int, name: String)
}