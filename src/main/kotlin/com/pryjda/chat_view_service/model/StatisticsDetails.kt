package com.pryjda.chat_view_service.model

data class StatisticsDetails(val inform: StatisticsPriority,
                             val code: StatisticsPriority,
                             val ask: StatisticsPriority,
                             val confirm: StatisticsPriority)