package com.pryjda.chat_view_service.controller

import com.pryjda.chat_view_service.model.Statistics
import com.pryjda.chat_view_service.model.StatisticsDetails
import com.pryjda.chat_view_service.model.StatisticsPriority
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ModelController {


    val users: List<String> = listOf("Jan", "Norbert", "Józef", "Kamil")

    val list: MutableList<Statistics> = mutableListOf(
            Statistics(
                    StatisticsDetails(
                            inform = StatisticsPriority(0, 0),
                            code = StatisticsPriority(0, 0),
                            ask = StatisticsPriority(0, 0),
                            confirm = StatisticsPriority(0, 0))))


    /*val statistics: Statistics = Statistics(
            StatisticsDetails(
                    inform = StatisticsPriority(0, 0),
                    code = StatisticsPriority(0, 0),
                    ask = StatisticsPriority(0, 0),
                    confirm = StatisticsPriority(0, 0)))*/


    @GetMapping("/show0")
    fun index() = list[0]

    @GetMapping("/show")
    fun increase(@RequestParam(value = "type") type: String, @RequestParam(value = "priority") priority: String): Statistics {

        val inform = list[0].statistics.inform
        val code = list[0].statistics.code
        val ask = list[0].statistics.ask
        val confirm = list[0].statistics.confirm

        when (type) {
            "inform" -> {
                val statistics = Statistics(
                        StatisticsDetails(
                                increaseNumber(inform, priority),
                                code,
                                ask,
                                confirm
                        ))
                list[0] = statistics
                return list[0]
            }
            "code" -> {
                val statistics = Statistics(
                        StatisticsDetails(
                                inform,
                                increaseNumber(code, priority),
                                ask,
                                confirm
                        ))
                list[0] = statistics
                return list[0]
            }
            "ask" -> {
                val statistics = Statistics(
                        StatisticsDetails(
                                inform,
                                code,
                                increaseNumber(ask, priority),
                                confirm
                        ))
                list[0] = statistics
                return list[0]
            }
            "confirm" -> {
                val statistics = Statistics(
                        StatisticsDetails(
                                inform,
                                code,
                                ask,
                                increaseNumber(confirm, priority)
                        ))
                list[0] = statistics
                return list[0]
            }
        }
        return list[0]
    }

    private fun increaseNumber(statisticsPriority: StatisticsPriority, priority: String): StatisticsPriority {
        val highNumber: Int = statisticsPriority.high
        val normalNumber: Int = statisticsPriority.normal

        when (priority) {
            "high" -> {
                return StatisticsPriority(highNumber + 1, normalNumber)
            }
            "normal" -> {
                return StatisticsPriority(highNumber, normalNumber + 1)
            }
        }
        return statisticsPriority
    }
}