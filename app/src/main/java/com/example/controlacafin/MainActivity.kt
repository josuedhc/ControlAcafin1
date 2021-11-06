package com.example.controlacafin

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var txtmaquina:EditText?=null
    var txti17:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtmaquina=findViewById(R.id.txtmaquina)
        txti17=findViewById(R.id.txti17)

    }
    fun insertar(view: View){
        var con = SQLite(this,"ControlAca",null,1)
        var database=con.writableDatabase
        var maquina=txtmaquina?.text.toString()
        var i17=txti17?.text.toString()
        if (maquina.isEmpty()==false && i17.isEmpty()==false) {
            var registro = ContentValues()
            registro.put("maquina", maquina)
            registro.put("i17", i17)
            database.insert("maquinas", null, registro)
            txtmaquina?.setText("")
            txti17?.setText("")
            Toast.makeText(this, "Registro Exitosamente", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_LONG).show()
            }


    }
}