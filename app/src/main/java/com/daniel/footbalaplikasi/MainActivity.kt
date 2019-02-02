package com.daniel.footbalaplikasi

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MainActivity : AppCompatActivity() {
    private lateinit var listTeam: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var spinner: Spinner

    companion object {
        const val PARCELABLE_DATA="ItemData"
    }
    var items:MutableList<ItemData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

    }
    inner class MainActivityUI(items:List<ItemData>) :AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>): View {
            verticalLayout {
                lparams(matchParent, wrapContent)
                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context,1))
                    adapter = ClubAdapter(items){
                        startActivity<Detail>(PARCELABLE_DATA)
                    }
                }
            }
        }

    }

    private fun loadData() {
    }

}
