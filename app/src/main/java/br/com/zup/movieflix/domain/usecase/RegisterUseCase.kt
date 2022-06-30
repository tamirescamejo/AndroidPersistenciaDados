package br.com.zup.movieflix.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.movieflix.domain.model.User
import br.com.zup.movieflix.ui.viewstate.ViewState

class RegisterUseCase {

    fun registerUser(user: User): LiveData<ViewState<User>> {

        val response = MutableLiveData<ViewState<User>>()

        if (user.email.isNotEmpty() &&
            user.password.isNotEmpty() &&
            user.confirmationPassword.isNotEmpty() &&
            user.password == user.confirmationPassword
        ) {
            response.value = ViewState.Success(user)
        } else {
            response.value = ViewState.Error(Exception("Não foi possível registrar o usuário!"))
        }
        return response
    }
}