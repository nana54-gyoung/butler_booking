package com.butler.booking.api.ui.act

import com.butler.booking.api.biz.BookingBiz
import com.butler.booking.api.ui.vo.BookingVO
import com.butler.booking.api.ui.vo.ResVO
import com.butler.booking.common.annotation.CurrentUser
import com.butler.booking.common.exception.ButlerException
import com.butler.booking.model.dto.MemberDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/booking")
class BookingAction(
    private val bookingBiz : BookingBiz
) {
    @PostMapping("/reserv")
    fun booking(@CurrentUser member : MemberDTO, @RequestBody bookingVO : BookingVO) : ResVO {
        println("booking request "+bookingVO.bookingRequest)
        member.mbno?.let {
            bookingVO.reservMbno = it
        } ?: ButlerException("B-001", "회원을 찾을 수 없습니다.")
      return bookingBiz.booking(bookingVO)
    }

    @GetMapping("list")
    fun list(@CurrentUser member : MemberDTO) = bookingBiz.list(member)

}