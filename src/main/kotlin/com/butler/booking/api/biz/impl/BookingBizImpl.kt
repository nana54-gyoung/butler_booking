package com.butler.booking.api.biz.impl

import com.butler.booking.api.biz.BookingBiz
import com.butler.booking.api.ui.vo.BookingVO
import com.butler.booking.api.ui.vo.ResMetaVO
import com.butler.booking.api.ui.vo.ResVO
import com.butler.booking.common.exception.ButlerException
import com.butler.booking.model.dto.MemberDTO
import com.butler.booking.model.entity.BookingEntity
import com.butler.booking.repository.BookingRepository
import org.springframework.stereotype.Service

@Service
class BookingBizImpl(
    private val bookingRepository: BookingRepository
) : BookingBiz {

    override fun booking(bookingVO: BookingVO): ResVO {
        return try {
            val bookingRes = bookingRepository.save(BookingEntity().apply {
                this.agentMbno = bookingVO.agentMbno
                this.reservMbno = bookingVO.reservMbno
                this.title = bookingVO.title
                this.bookingRequest = bookingVO.bookingRequest
                this.price = bookingVO.price
                this.stdt = bookingVO.stdt
                this.eddt = bookingVO.eddt
            })
            ResVO(meta = ResMetaVO(200, "ok"), data = bookingRes)
        }catch (e : ButlerException) {
            ResVO(meta = ResMetaVO(400, e.msg))
        }
    }

    override fun list(memberDTO: MemberDTO): ResVO {
        return memberDTO.mbno?.let { mbno ->
            bookingRepository.findByReservMbno(mbno)?.let { list ->
                ResVO(meta = ResMetaVO(200), data = list)
            } ?: ResVO(meta = ResMetaVO(200, "예약이 존재하지 않습니다."))

        } ?: ResVO(meta = ResMetaVO(400, "회원키를 찾을 수 없습니다."))
    }
}