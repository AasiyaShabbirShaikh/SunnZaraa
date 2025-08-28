package com.example.sunnzaraa.ui.registration.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunnzaraa.database.entities.UserEntity
import com.example.sunnzaraa.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel(){

    var tempEmail: String? = null
    var tempPassword: String? = null
    var tempName: String? = null
    var tempDob: String? = null
    var tempGender: String? = null

    private val _registerResult = MutableLiveData<Result<Unit>>()
    val registerResult: LiveData<Result<Unit>> = _registerResult

    private val _loginResult = MutableLiveData<Result<UserEntity>>()
    val loginResult: LiveData<Result<UserEntity>> = _loginResult

    fun register(user: UserEntity){
        viewModelScope.launch {
            _registerResult.value = repository.registerUser(user)
        }
    }

    fun login (email: String, password: String){
        viewModelScope.launch {
            _loginResult.value= repository.loginUser(email , password)
        }
    }

    fun setEmail(email: String){
        tempEmail = email
    }

    fun setPassword(password: String){
        tempPassword = password
    }

    fun setPersonalDetails(name:String, dob:String, gender:String){
        tempName = name
        tempDob = dob
        tempGender = gender
    }

    fun registerTempData(){
        val email = tempEmail
        val password = tempPassword
        val dob = tempDob
        val gender = tempGender
        val name = tempName

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            _registerResult.value = Result.failure(Exception("Email or Password is missing"))
        }

        val user = UserEntity(
            email = email ?: "",
            password = password ?: "",
            dob = dob ?: "",
            gender = gender ?: "",
            name = name ?: ""
        )
        register(user)
    }

}