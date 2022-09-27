package com.example.recycleview_withdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.inputdialog.*

import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var arrData: ArrayList<ModelClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = recycle_view
        add_btn.setOnClickListener {
            var inputDialog = Dialog(this)
            inputDialog.setContentView(R.layout.inputdialog)
            inputDialog.setCancelable(false)
            inputDialog.show()
            inputDialog.Dialog_add_btn.setOnClickListener {
//        var input_name1 = inputDialog.input_name.text.toString()
//       var input_num1 = inputDialog.input_num.text.toString()
                if (inputDialog.input_name.text.toString() != "" && inputDialog.input_num.text.toString() != "") {

                    arrData.add(
                        ModelClass(
                            inputDialog.input_name.text.toString(),
                            inputDialog.input_num.text.toString(),
                            R.drawable.male_vector
                        )
                    )
                    inputDialog.dismiss()
                } else {
                    Toast.makeText(this, "Please Fill it", Toast.LENGTH_SHORT).show()
                }

            }
            inputDialog.Dialog_cancel_btn.setOnClickListener {
                inputDialog.dismiss()
            }

        }
        arrData = ArrayList<ModelClass>()
        arrData.add(ModelClass("Manoj", "7894561230", R.drawable.male_vector))
        arrData.add(ModelClass("Ritesh", "7894561230", R.drawable.male_vector))

        recycle_view.adapter = RecyclerViewAdapter(this, arrData)
        recyclerView.adapter?.notifyDataSetChanged()

        recycle_view.layoutManager = LinearLayoutManager(this)
    }
}