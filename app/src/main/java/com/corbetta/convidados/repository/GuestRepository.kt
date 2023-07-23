package com.corbetta.convidados.repository


import android.content.Context
import com.corbetta.convidados.model.GuestModel



class GuestRepository (context: Context) {


    private var guestDataBase = GuestDataBaseHelper.guestDataBase(context).guestDAO()


    /**
     * Carrega convidado
     */
    fun get(id: Int): GuestModel {
       return guestDataBase.get(id)
    }

    /**
     * Insere convidado
     */
    fun save(guest: GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0
    }

    /**
     * Faz a listagem de todos os convidados
     */
    fun getAll(): List<GuestModel> {
        return guestDataBase.getAll()
    }

    /**
     * Faz a listagem de todos os convidados presentes
     */
    fun getPresent(): List<GuestModel> {
       return guestDataBase.getPresent()
    }

    /**
     * Faz a listagem de todos os convidados presentes
     */
    fun getAbsent(): List<GuestModel> {
       return guestDataBase.getAbsent()
    }

    /**
     * Atualiza convidado
     */
    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    /**
     * Remove convidado
     */
    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

}




