package com.corbetta.convidados.view.viewholder

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.corbetta.convidados.R
import com.corbetta.convidados.databinding.RowGuestBinding
import com.corbetta.convidados.model.GuestModel
import com.corbetta.convidados.view.listener.GuestListener

class GuestViewHolder(private val item: RowGuestBinding, private val listener: GuestListener) :
    RecyclerView.ViewHolder(item.root) {

    fun bind(guest: GuestModel) {

        // Atribui valores
        item.textName.text = guest.name

        // Atribui eventos
        item.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        // Atribui eventos
        item.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()

            true
        }
    }
}