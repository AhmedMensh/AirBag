package sa.amaz.jaz.student.models

import com.squareup.moshi.Json

data class ApiResponse<T>(
    @field:Json(name = "data")
    val data: T?,
    @field:Json(name = "status")
    val status: Int?,
    @field:Json(name = "success")
    val success: Boolean?
)

//data class Error(
//    @field:Json(name = "code")
//    val code: Int?,
//    @field:Json(name = "message")
//    val message: String?
//)