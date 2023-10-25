package me.koapi.credit.apisystem.service.impl

import me.koapi.credit.apisystem.entity.Customer
import me.koapi.credit.apisystem.repository.CustomerRepository
import me.koapi.credit.apisystem.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow{
        throw  RuntimeException("ID $id not found")
    }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)
}