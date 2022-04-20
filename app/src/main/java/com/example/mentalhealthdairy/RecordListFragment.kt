package com.example.mentalhealthdairy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "RecordListFragment"

class RecordListFragment: Fragment() {

    private lateinit var recordRecyclerView: RecyclerView
    private var adapter: RecordAdapter ?= null

    private val recordListViewModel: RecordListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total records: ${recordListViewModel.records.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_record_list, container, false)

        recordRecyclerView = view.findViewById(R.id.record_recycler_view) as RecyclerView
        recordRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private inner class RecordHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var record: Record
        private val titleTextView: TextView = itemView.findViewById(R.id.record_title)
        private val dateTextView: TextView = itemView.findViewById(R.id.record_date)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(record: Record) {
            this.record = record
            titleTextView.text = record.title
            dateTextView.text = record.date.toString()
        }

        override fun onClick(p0: View?) {
            Toast.makeText(
                context,
                "${record.title} is pressed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private inner class RecordAdapter(var records: List<Record>) : RecyclerView.Adapter<RecordHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordHolder {
            val view = layoutInflater.inflate(R.layout.list_item_record, parent, false)
            return RecordHolder(view)
        }

        override fun getItemCount(): Int {
            return records.size
        }

        override fun onBindViewHolder(holder: RecordHolder, position: Int) {
            val record = records[position]
            holder.bind(record)
        }

    }

    private fun updateUI() {
        val records = recordListViewModel.records
        adapter = RecordAdapter(records)
        recordRecyclerView.adapter = adapter
    }


    companion object {
        fun newInstance(): Fragment {
            return RecordListFragment()
        }
    }
}