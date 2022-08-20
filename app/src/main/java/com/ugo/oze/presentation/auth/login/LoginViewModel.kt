package com.ugo.oze.presentation.auth.login

import com.ugo.oze.main.base.login.BaseLoginViewModel
import com.ugo.oze.utility.validation.UgoWierd
import com.ugo.oze.utility.validation.error.ErrorResources
import com.ugo.oze.utility.validation.local.LocalResources
import javax.inject.Inject

@Suppress("MaxLineLength", "LongParameterList")
class LoginViewModel @Inject constructor(
    ugoWierd: UgoWierd,
    errorResources: ErrorResources,
    localResources: LocalResources,
) : BaseLoginViewModel(
    ugoWierd,
    errorResources,
    localResources,
)