package com.example.actividad01multimedia.views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.actividad01multimedia.R
import com.example.actividad01multimedia.logic.ClientController
import com.example.actividad01multimedia.logic.TAG
import com.example.actividad01multimedia.logic.interfaces.ClientCrud
class MainActivity : AppCompatActivity(), ClientCrud {
    private val controller = ClientController()
    private val dialog = ClientDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Esto es un ejemplo")
        Log.d(TAG, controller.getAll().toString())

        dialog.setListener(this)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            dialog.show(Action.ADD, controller.getAll(), controller.newId())
        }
        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            dialog.show(Action.UPDATE, controller.getAll(), 0)
        }
        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            dialog.show(Action.DELETE, controller.getAll(), 0)
        }
    }

    override fun clientAdd(id: Int, name: String) = controller.add(id, name)
    override fun clientDel(id: Int) = controller.delete(id)
    override fun clientUpdate(id: Int, name: String) = controller.update(id, name)
}