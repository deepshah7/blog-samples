package com.gitshah.blog

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun shouldSearchBooks() {
        val result = testRestTemplate.getForEntity("/books/search?title=Steve",
                String::class.java)
        Assert.assertNotNull(result)
        Assert.assertEquals(HttpStatus.OK, result.statusCode)
        println(result.body)
        val books = result.body.fromJson<Array<Book>>()
        Assert.assertEquals(2, books.size)
        Assert.assertNotNull(books.find { it.title == "Steve Jobs" })
        Assert.assertNotNull(books.find { it.title == "Steve Jobs: The man who thought different" })
    }
}