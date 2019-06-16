package com.pryjda.chat_view_service.controller

import com.pryjda.chat_view_service.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Model2Controller {

    val one1 = mutableListOf<SingleStatistics2>(
            SingleStatistics2(
                    tagName = "first tag",
                    payload = StatisticsDetails2(
                            inform = StatisticsPriority2(7, 0),
                            code = StatisticsPriority2(7, 0),
                            ask = StatisticsPriority2(7, 0),
                            confirm = StatisticsPriority2(7, 0))),
            SingleStatistics2(
                    tagName = "second tag",
                    payload = StatisticsDetails2(
                            inform = StatisticsPriority2(0, 1),
                            code = StatisticsPriority2(0, 1),
                            ask = StatisticsPriority2(0, 1),
                            confirm = StatisticsPriority2(0, 1)))
    )

    val two2 = mutableListOf<SingleStatistics2>(
            SingleStatistics2(
                    tagName = "first tag",
                    payload = StatisticsDetails2(
                            inform = StatisticsPriority2(444, 0),
                            code = StatisticsPriority2(444, 0),
                            ask = StatisticsPriority2(444, 0),
                            confirm = StatisticsPriority2(444, 0))),
            SingleStatistics2(
                    tagName = "third tag",
                    payload = StatisticsDetails2(
                            inform = StatisticsPriority2(0, 3),
                            code = StatisticsPriority2(0, 3),
                            ask = StatisticsPriority2(0, 3),
                            confirm = StatisticsPriority2(0, 3)))
    )

    val three3 = mutableListOf<SingleStatistics2>(
            SingleStatistics2(
                    tagName = "default tag",
                    payload = StatisticsDetails2(
                            inform = StatisticsPriority2(0, 0),
                            code = StatisticsPriority2(0, 0),
                            ask = StatisticsPriority2(0, 0),
                            confirm = StatisticsPriority2(0, 0))),
            SingleStatistics2(
                    tagName = "fourth tag",
                    payload = StatisticsDetails2(
                            inform = StatisticsPriority2(0, 13),
                            code = StatisticsPriority2(0, 13),
                            ask = StatisticsPriority2(0, 13),
                            confirm = StatisticsPriority2(0, 13)))
    )

    @GetMapping("/get/1")
    fun getOne() = one1

    @GetMapping("/get/2")
    fun getTwo() = two2

    @GetMapping("/get/combine")
    fun getCombined(): MutableList<SingleStatistics2> {

        val combined = mutableListOf<SingleStatistics2>()
        val startList = mutableListOf<MutableList<SingleStatistics2>>(one1, two2, three3)

        startList.forEach { it ->
            it.forEach { startSingleStatistics2 ->
                val stream = combined.filter { it.tagName == startSingleStatistics2.tagName }
                if (stream.isNotEmpty())
                    stream.map {
                        increateOccurrings(startSingleStatistics2, it)
                    }
                if (stream.isEmpty())
                    combined.add(startSingleStatistics2)
//                combined.add(singleStatistics2)
            }
        }

//        combined.forEach {
//            if (it.tagName ==)
//        }
        return combined
    }

    fun increateOccurrings(start: SingleStatistics2, combine: SingleStatistics2) {

        combine.payload.inform.high += start.payload.inform.high
        combine.payload.inform.normal += start.payload.inform.normal
        combine.payload.code.high += start.payload.code.high
        combine.payload.code.normal += start.payload.code.normal
        combine.payload.ask.high += start.payload.ask.high
        combine.payload.ask.normal += start.payload.ask.normal
        combine.payload.confirm.high += start.payload.confirm.high
        combine.payload.confirm.normal += start.payload.confirm.normal


    }

    fun rewriteOccurrings(start: SingleStatistics2, combine: SingleStatistics2) {
        combine.tagName = start.tagName
        combine.payload.inform.high = start.payload.inform.high
        combine.payload.inform.normal = start.payload.inform.normal
        combine.payload.code.high = start.payload.code.high
        combine.payload.code.normal = start.payload.code.normal
        combine.payload.ask.high = start.payload.ask.high
        combine.payload.ask.normal = start.payload.ask.normal
        combine.payload.confirm.high = start.payload.confirm.high
        combine.payload.confirm.normal = start.payload.confirm.normal
    }


    /*val size1 = startList.distinct().map {
            it.distinct().map {
                it.tagName
            }.size
        }.sum()

        val size = startList.map {
            it.size
        }.sum()



        println("size: $size")*/

    /*combined.forEach { combinedSingleStatistics2 ->
                    run {
                        if (startSingleStatistics2.tagName == combinedSingleStatistics2.tagName) {
                            increateOccurrings(startSingleStatistics2, combinedSingleStatistics2)
                        } else {
                            run {
                                combined.add(startSingleStatistics2)
                            }
                        }
                    }
                }*/

    //                combined.filter{
//                    it.tagName == startSingleStatistics2.tagName
//                }.map {combinedSingleStatistics2 ->
//                    run{
//                        increateOccurrings(startSingleStatistics2, combinedSingleStatistics2)
//                    }
//                }
}