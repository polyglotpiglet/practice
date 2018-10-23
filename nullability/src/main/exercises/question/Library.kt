package question

import library.*
import java.util.ArrayList

class Library(private val members: Members, private val catalogue: Catalogue, private val authors: Authors, private val loans: Loans) {

    fun borrow(membershipNumber: Int, isbn: String): Loan? =
            members.lookup(membershipNumber)?.let {
                val memberHasTooManyBooks = loans.lentTo(it).size > 1
                return if (memberHasTooManyBooks) null else lendBookToMember(isbn, it)

            }

    private fun lendBookToMember(isbn: String, member: Member): Loan? {
        val book = catalogue.lookup(isbn)
        return book?.let { loans.lend(member.id, book) }
    }

    fun popularYoungAuthors() = findYoungAuthors().let {
        if (it.isEmpty()) null
        else it
    }

    private fun findYoungAuthors(): List<Author> {
        return members.flatMap { loans.lentTo(it) }
                .map { authors.lookup(it.book.author.id) }
                .filter { it?.let { it.birthYear > 1995 } ?: false }
    }
}
