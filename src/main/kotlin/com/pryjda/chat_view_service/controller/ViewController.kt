package com.pryjda.chat_view_service.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController {


    val users: List<String> = listOf("Jan", "Norbert", "Józef", "Kamil")


    @GetMapping("/view")
    fun index() = "index"

    @GetMapping("/view2")
    fun index2(model: Model): String {
        model.addAttribute("atr", users)
        return "index2"
    }


}