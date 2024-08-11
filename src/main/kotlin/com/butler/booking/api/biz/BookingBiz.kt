package com.butler.booking.api.biz

import com.butler.booking.api.ui.vo.BookingVO
import com.butler.booking.api.ui.vo.ResVO

interface BookingBiz {
    fun booking (bookingVO: BookingVO) : ResVO
}