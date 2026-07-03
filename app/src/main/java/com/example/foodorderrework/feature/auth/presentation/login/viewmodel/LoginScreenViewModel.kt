package com.example.foodorderrework.feature.auth.presentation.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderrework.feature.auth.domain.usecase.LoginUseCase
import com.example.foodorderrework.feature.auth.presentation.login.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface LoginEvent {
    data object NavigateToHome : LoginEvent
    data class ShowSnackBar(val message: String) : LoginEvent
}

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _event = Channel<LoginEvent>()
    val event = _event.receiveAsFlow()

    fun onEmailChange(value: String) {
        _uiState.update {
            it.copy(
                email = value
            )
        }
    }

    fun onPasswordChange(value: String) {
        _uiState.update {
            it.copy(
                password = value
            )
        }
    }

    fun onPasswordVisibilityToggle() {
        val isPasswordVisible = _uiState.value.isPasswordVisible

        _uiState.update {
            it.copy(
                isPasswordVisible = !isPasswordVisible
            )
        }
    }

    fun onLoginClick() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }

            try {
                val user = loginUseCase(_uiState.value.email, _uiState.value.password)

                if (user != null) {
                    _event.send(LoginEvent.NavigateToHome)
                } else {
                    _event.send(LoginEvent.ShowSnackBar("Tài khoản hoặc mật khẩu không đúng."))
                }
            } catch (exception: IllegalArgumentException) {
                _uiState.update {
                    it.copy(
                        errorMessage = exception.message
                    )
                }
            } finally {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                    )
                }
            }
        }
    }
}