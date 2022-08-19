package com.ugo.datplace.presentation.auth.login

import com.ugo.datplace.main.base.login.BaseLoginViewModel
import com.ugo.datplace.utility.validation.UgoWierd
import com.ugo.datplace.utility.validation.error.ErrorResources
import com.ugo.datplace.utility.validation.local.LocalResources
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