package com.example.launchmodestandart.testrecycler

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.example.launchmodestandart.R
import com.example.launchmodestandart.model.TestName
import com.example.launchmodestandart.testrecycler.adapter.NameAdapter
import kotlinx.android.synthetic.main.fragment_navigation_2.*
import kotlin.random.Random

class EnterAvatarFragment : Fragment(R.layout.fragment_navigation_2) {

    companion object {
        const val KEY_NAME = "KEY_NAME"

        fun newInstance(name: String) = EnterAvatarFragment()
            .apply {
                arguments = Bundle().apply {
                    putString(KEY_NAME, name)
                }
            }
    }

    private var callback: EnterAvatarFragmentCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = activity as? EnterAvatarFragmentCallback
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(Random.nextInt())
        val adapter = NameAdapter()
        rvRecycler.adapter = adapter
        adapter.data = generateData()


        Handler().postDelayed({
            adapter.data[3].isChecked = true
            adapter.notifyItemChanged(3, "KEY_CHECK_BOX")

            Handler().postDelayed({
                adapter.updateItemAt(3, "123123")
            }, 2000)
        }, 1000)
    }

    private fun generateData() = mutableListOf<TestName>().apply {
        for (i in 0..100) {
            add(TestName(i.toString(), false))
        }
    }
}