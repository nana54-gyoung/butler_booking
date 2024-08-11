package com.butler.booking.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "booking")
data class BookingEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)var bkno:Int? = null) {
    var agentMbno : Int? = null
    var reservMbno : Int? = null
    var title : String? = null
    @Column(name = "booking_request")var bookingRequest : String? = null
    var price : Int? = null
    var stdt : LocalDateTime? = LocalDateTime.now()
    var eddt : LocalDateTime? = LocalDateTime.now()
    var regdt : LocalDateTime? = LocalDateTime.now()
}