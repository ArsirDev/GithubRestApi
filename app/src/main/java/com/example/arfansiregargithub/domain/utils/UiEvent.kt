package com.example.arfansiregargithub.domain.utils

sealed class UiEvent {
    data class ShowSnackbar(val uiText: UiText,val type: String): UiEvent()
    data class ShowSnackbarWithCallback(val uiText: UiText,val type: String): UiEvent()
}