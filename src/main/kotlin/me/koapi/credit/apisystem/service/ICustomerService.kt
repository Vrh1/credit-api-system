package me.koapi.credit.apisystem.service

import me.koapi.credit.apisystem.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long): Unit
}