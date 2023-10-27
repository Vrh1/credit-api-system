package me.koapi.credit.apisystem.dto

import me.koapi.credit.apisystem.entity.Credit
import me.koapi.credit.apisystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstanllment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstanllment,
         numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
