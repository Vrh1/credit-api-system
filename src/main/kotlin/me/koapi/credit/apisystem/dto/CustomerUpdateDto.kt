package me.koapi.credit.apisystem.dto

import me.koapi.credit.apisystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.adress.zipCode = customer.adress.zipCode
        customer.adress.street = customer.adress.street

        return customer
    }
}
