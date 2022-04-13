package com.example.mentalhealthdairy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class RecordFragment: Fragment() {
    private lateinit var record: Record
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var reflectedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        record = Record()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_record, container, false)

        dateButton = view.findViewById(R.id.record_date) as Button
        titleField = view.findViewById(R.id.record_title) as EditText
        reflectedCheckBox = view.findViewById(R.id.record_reflected)

        dateButton.apply {
            text = record.date.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(sequence: Editable?) {
                TODO("Not yet implemented")
            }

        }

        titleField.addTextChangedListener(titleWatcher)

        reflectedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                record.isReflected = isChecked
            }
        }
    }

}