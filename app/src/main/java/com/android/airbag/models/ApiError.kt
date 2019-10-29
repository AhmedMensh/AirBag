package sa.amaz.jaz.student.models

import com.squareup.moshi.Json

data class ApiError(
    @field:Json(name = "error")
    val error: Error?,
    @field:Json(name = "status")
    val status: Int?,
    @field:Json(name = "success")
    val success: Boolean?
)