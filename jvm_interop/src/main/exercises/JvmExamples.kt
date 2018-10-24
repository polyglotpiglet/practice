class JvmNames {

    @JvmName("copyStringList")
    fun copyList(s: List<String>): List<String> = s

    fun copyList(i: List<Int>): List<Int> = i
}