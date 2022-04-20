package com.herdal.roomdatabaseexercise.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.herdal.roomdatabaseexercise.R
import com.herdal.roomdatabaseexercise.adapter.UserAdapter
import com.herdal.roomdatabaseexercise.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.view.*


class UserListFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)

        // recyclerview
        val adapter = UserAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        // userviewmodel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.listAllUsers.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        return view
    }
}