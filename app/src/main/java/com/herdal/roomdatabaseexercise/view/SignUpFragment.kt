package com.herdal.roomdatabaseexercise.view

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.herdal.roomdatabaseexercise.R
import com.herdal.roomdatabaseexercise.model.User
import com.herdal.roomdatabaseexercise.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.textViewgoToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        view.buttonSignUp.setOnClickListener {
            insertUserToDatabase()
        }

        return view
    }

    private fun insertUserToDatabase() {
        val email = editTextSignUpEmail.text.toString()
        val password = editTextSignUpPassword.text.toString()
        val userName = editTextUserName.text.toString()
        val age = editTextAge.text

        if(checkFields(email, password, userName, age)) {
            // create user
            val user = User(0, email, password,userName,Integer.parseInt(age.toString()))
            // add user to database
            userViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully created an account!",Toast.LENGTH_SHORT).show()
            // navigate to list
            findNavController().navigate(R.id.action_signUpFragment_to_userListFragment)
        }
        else {
            Toast.makeText(requireContext(),"Please fill out all fields!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFields(email: String, password: String,userName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(userName) && age.isEmpty())
    }

}