package com.example.androidtictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Xml
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val array = Array(4, { IntArray(4) })
    var player: String = "X"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkin(view: View) {
        val builder = AlertDialog.Builder(this)
        val button = view as Button
        var a = view.getResources().getResourceName(view.getId());
        var length = a.length
        var i = (a.substring(length - 1)).toInt()
        var j = (a.substring(length - 2, length - 1)).toInt()
        if (player == "X") {
            button.setText("X").toString()
            array[i][j] = 1
            player = "O"
        } else {
            button.setText("O").toString()
            array[i][j] = 2
            player = "X"
        }
        if (findWiner(array) == 1) {
            builder.setMessage("Player 1 is winner")
            builder.show()
        }else if (findWiner(array) == 2) {
            builder.setMessage("Player 2 is winner")
            builder.show()
        }

    }
    fun findWiner(arr: Array<IntArray>): Int {
        var result = 0
        for (x in 1 until arr.size) {
            if (arr[x][1] == arr[x][2] && arr[x][2] == arr[x][3] &&  arr[x][3] !=0) {
                result = arr[x][1]
            }
        }
        for (x in 1 until arr.size) {
            if (arr[1][x] == arr[2][x] && arr[2][x] == arr[3][x] && arr[3][x] != 0) {
                result = arr[1][x]
            }
        }
        if(arr[1][1] == arr[2][2] && arr[1][1] == arr[3][3] && arr[1][1] != 0){
            result = arr[1][1]
        }
        if(arr[1][3] == arr[2][2] && arr[1][3] == arr[3][1] && arr[3][1] != 0){
            result = arr[1][3]
        }
        return result
    }
}

