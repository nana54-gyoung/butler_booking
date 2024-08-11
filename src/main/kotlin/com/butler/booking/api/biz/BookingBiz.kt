package com.butler.booking.api.biz

import com.butler.booking.api.ui.vo.BookingVO
import com.butler.booking.api.ui.vo.ResVO
import com.butler.booking.model.dto.MemberDTO

interface BookingBiz {
    fun booking (bookingVO: BookingVO) : ResVO
    fun list (memberDTO: MemberDTO) : ResVO
}