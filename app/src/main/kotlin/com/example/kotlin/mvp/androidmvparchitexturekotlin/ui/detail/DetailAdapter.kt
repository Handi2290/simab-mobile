package com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.detail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlin.mvp.androidmvparchitexturekotlin.R
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.model.ItemHome
import com.example.kotlin.mvp.androidmvparchitexturekotlin.databinding.ItemHomeBinding
import com.example.kotlin.mvp.androidmvparchitexturekotlin.utils.toRupiah
import com.google.gson.Gson

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

class DetailAdapter(
  private var context: Context,
  private var items: List<ItemHome>,
  private var listener: OnItemClickListener,
) :
  RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
  private lateinit var binding: ItemHomeBinding
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_home, parent, false)
    binding = ItemHomeBinding.bind(v)
    return ViewHolder(binding)

  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    holder?.bind(context, items[position], listener)


  }

  override fun getItemCount(): Int = items?.size

  class ViewHolder(binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    val id = binding.id
    val nama = binding.nama
    val jumlah = binding.jumlah
    val tanggal = binding.tanggal

    fun bind(context: Context, item: ItemHome?, listener: OnItemClickListener) {

      if (item != null) {
        id.text = item.index.toString()
        nama.text = item.cr_id_dtl.toString()
        jumlah.text = item.cr_uraian
        tanggal.text = toRupiah(item.cr_dtl_nominal ?: 0.0)

      }

      itemView.setOnClickListener { view -> listener.onItemClick(item!!) }
    }

  }

  fun setItems(items: List<ItemHome>) {
    this.items = items
    Log.i("TAG", "setItems: " + Gson().toJson(items))
    notifyDataSetChanged()
  }

  interface OnItemClickListener {

    fun onItemClick(item: ItemHome)

  }
}