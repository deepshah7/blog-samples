package com.gitshah.blog

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/books")
class BookController {
    private val log = LoggerFactory.getLogger(BookController::class.java)

    val books = listOf(
            Book("Instant Mock Testing with PowerMock", "Deep Shah"),
            Book("Steve Jobs", "Walter Isaacson"),
            Book("Steve Jobs: The man who thought different", "Karen Blumenthal"),
            Book("Wings of Fire: An Autobiography of Abdul Kalam", " Arun Tiwari (Author), A. P. J. Abdul Kalam")
    )

    @GetMapping("/search")
    fun search(@RequestParam("title") title: String = ""): List<Book> {
        return books.filter { it.title.contains(title, true) }.toList()
    }
}
