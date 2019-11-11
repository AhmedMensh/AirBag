package com.android.airbag.models

import com.squareup.moshi.Json

class ActiveUser(
        @Json(name = "code")
        var code: String? = null,

        @Json(name = "type")
        var type: String? = null
)