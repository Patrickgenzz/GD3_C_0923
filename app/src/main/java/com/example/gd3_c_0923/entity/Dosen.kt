package com.example.guided3.entity

class Dosen (var name: String, var pengajar: String){

    companion object{
        @JvmField
        var listOfDosen = arrayOf(
            Dosen("Fidelis Brian", "Pengajar Kelas A, B, dan C"),
            Dosen("Thomas Adi", "Pengajar Kelas C")
        )
    }
}