package com.butler.booking.api.ui.vo

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class BookingVO(
    var mbno : Int? = null,
    var bmno : Int? = null,
    var title : String? = null,
    var bookingRequest : String? = null,
    var price : Int? = null,
    @field: JsonFormat(pattern = "yyyy-MM-dd HH:mm:00") var stdt : LocalDateTime? = null,
    @field: JsonFormat(pattern = "yyyy-MM-dd HH:mm:00") var eddt : LocalDateTime? = null
)
