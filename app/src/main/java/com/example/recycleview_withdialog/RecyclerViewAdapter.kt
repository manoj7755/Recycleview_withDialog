package com.example.recycleview_withdialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.delete_dialog.*
import kotlinx.android.synthetic.main.inputdialog.*
import kotlinx.android.synthetic.main.inputdialog.view.*
import kotlinx.android.synthetic.main.row_item.view.*
import java.util.*
import java.util.zip.Inflater

class RecyclerViewAdapter(val context: Context, val arrdata: ArrayList<ModelClass>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pro_name = itemView.name
        val pro_num = itemView.num
        val pro_imag = itemView.profile_img
        val delete_btn1 = itemView.delete_btn
        val update_btn1 = itemView.update_btn
        var row_id = itemView.row_id

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
//       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pro_imag.setImageResource(arrdata[position].Profile_path)
        holder.pro_name.text = arrdata[position].name
        holder.pro_num.text = arrdata[position].num

holder.update_btn1.setOnClickListener{
 var UpdateDialog = Dialog(context)
    UpdateDialog.setContentView(R.layout.inputdialog)
    var get_name = arrdata[position].name
    var get_num = arrdata[position].num
UpdateDialog.input_name.setText(get_name)
    UpdateDialog.input_num.setText(get_num)
    Toast.makeText(context, "you clicked on row $get_name", Toast.LENGTH_SHORT).show()
    UpdateDialog.Dialog_add_btn.setOnClickListener {
        var ud_name = UpdateDialog.input_name.text.toString()
        var ud_num = UpdateDialog.input_num.text.toString()
        val courmodelClass = ModelClass(ud_name,ud_num,arrdata[position].Profile_path)
        arrdata.set(position,courmodelClass)
notifyDataSetChanged()
UpdateDialog.dismiss()
//  UpdateDialog.input_name.text = get_name
    }
    UpdateDialog.Dialog_cancel_btn.setOnClickListener {
        UpdateDialog.dismiss()
    }
//    update_name.text = arrdata[position].num
//    var update_name = UpdateDialog.input_name
    UpdateDialog.setCancelable(false)
    UpdateDialog.show()

}
holder.delete_btn1.setOnClickListener {
    var DeleteDialog = Dialog(context)
    DeleteDialog.setCancelable(false)
    DeleteDialog.setContentView(R.layout.delete_dialog)
    DeleteDialog.delete_dialog_cancel_btn.setOnClickListener {
        DeleteDialog.dismiss()
    }
    DeleteDialog.delete_dialog_delete_btn.setOnClickListener {

    }
    DeleteDialog.show()
}
    }

    override fun getItemCount(): Int {
        return arrdata.size
    }
}