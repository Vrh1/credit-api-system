package me.koapi.credit.apisystem.controller

import me.koapi.credit.apisystem.dto.CreditDto
import me.koapi.credit.apisystem.dto.CreditView
import me.koapi.credit.apisystem.dto.CreditViewList
import me.koapi.credit.apisystem.entity.Credit
import me.koapi.credit.apisystem.entity.Customer
import me.koapi.credit.apisystem.service.impl.CreditService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long) : List<CreditViewList> {
        return this.creditService.findAllByCustomer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit)  }.collect(Collectors.toList())
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID) : CreditView {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return CreditView(credit)
    }
}