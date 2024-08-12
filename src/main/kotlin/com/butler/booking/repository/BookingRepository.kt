package com.butler.booking.repository

import com.butler.booking.model.entity.BookingEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : CrudRepository<BookingEntity, Int> {
    fun findByMbno(mbno : Int) : List<BookingEntity>?
}