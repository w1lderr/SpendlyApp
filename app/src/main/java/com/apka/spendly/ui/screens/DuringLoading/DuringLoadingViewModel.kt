package com.apka.spendly.ui.screens.DuringLoading

import androidx.lifecycle.ViewModel
import com.apka.spendly.data.repo.AuthenticationRepo

class DuringLoadingViewModel(
    private val repo: AuthenticationRepo
) : ViewModel() {
    val isLoggedIn = repo.isLoggedIn
}