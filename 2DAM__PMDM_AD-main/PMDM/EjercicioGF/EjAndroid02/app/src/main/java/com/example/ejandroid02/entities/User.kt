package com.example.ejandroid02.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(@ColumnInfo(name = "userName_User")var userName:String,
                @ColumnInfo(name = "password_User")var password : String){
    @PrimaryKey(autoGenerate = true)
    var id = 0
    @ColumnInfo(name = "name_User")
    var name: String? = ""
    @ColumnInfo(name = "lastName_User")
    var lastName:String? = ""

    fun setNameAndLast(name: String, lastName: String){
        this.name = name
        this.lastName = lastName
    }

    override fun toString(): String {
            var str = ""
            return when ((name.isNullOrBlank()||lastName.isNullOrBlank())) {
            true -> "'${userName}' (${str})"
            false -> "'${name}' '${lastName}'"
        }
    }


}
