package com.example.help

interface RowClickListener<T> {
    fun onRowClick(pos: Int, item: T)
}