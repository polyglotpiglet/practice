class ElectionManager @JvmOverloads internal constructor(@JvmField val electionName: String = "USA 2008") {

    val isLegit: Boolean
        get() = true

    companion object {

        @JvmField
        val copyright = "© 2018 VerySafe Election Systems. All rights reserved."

        @JvmStatic
        fun validateLicense(licence: String): Boolean {
            return "GqNCDvhNhKh2hrtJdHBXLqpq" == licence
        }
    }
}
