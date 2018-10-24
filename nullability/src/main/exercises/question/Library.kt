package question

import library.*

class Library(private val members: Members, private val catalogue: Catalogue, private val authors: Authors, private val loans: Loans) {

    fun borrow(membershipNumber: Int, isbn: String): Loan? = members.lookup(membershipNumber)
            ?.takeIf { member -> loans.lentTo(member).size < 2 }
            ?.let { catalogue.lookup(isbn) }
            ?.let { book -> loans.lend(membershipNumber, book) }

    fun popularYoungAuthors() =
            members.flatMap { member -> loans.lentTo(member) }
                    .map { authors.lookup(it.book.author.id) }
                    .filter { it?.takeIf { it.birthYear > 1995 } != null }
                    .takeIf { !it.isEmpty() }

}
