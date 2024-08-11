package com.butler.booking.api.biz

import com.butler.booking.api.ui.vo.BookingVO
import com.butler.booking.api.ui.vo.ResMetaVO
import com.butler.booking.api.ui.vo.ResVO
import com.butler.booking.common.exception.ButlerException
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
}