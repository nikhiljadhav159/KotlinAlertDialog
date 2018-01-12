package com.example.kotlinalertdialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //region Now we can directly use the id for buttons, textview..etc after onCreate method no need to findViewById
    override fun onResume() {
        super.onResume()

        initialise()
    }
    //endregion

   fun initialise(){
       //we can directly set the onclick method by function
       btnAlert.setOnClickListener({showAlert()})

       //OR we can set like this
       btnAlert.setOnClickListener({view: View? -> showAlert() })


       //also we can set onClickListner to this
       btnToast.setOnClickListener(this)
   }

    private fun showAlert() {
        val alertDialog:AlertDialog = AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("This is simple alert dialog in kotlin")
                .setPositiveButton("Ok", { dialogInterface: DialogInterface?, i: Int ->  dialogInterface?.dismiss() })
                .create()

        alertDialog.show()
    }

    private fun showToast() {
        Toast.makeText(this,"This is simple Kotlin Toast",Toast.LENGTH_SHORT).show()

    }

    override fun onClick(view: View?) {
        when(view?.id){
            btnToast.id -> {
                showToast()
            }
        }
    }
}
