package com.gambit.cooki_myrecipebook.data.local_data.entities.enums

enum class SkillLevel {
    NoSkill, Beginner, Intermediate, Advanced, Expert;

    fun getHumanReadableIndex() = this.ordinal + 1

    companion object {
        private fun count() = values().size
        fun levelRange() = 1..count()

        fun getLevelFromHumanReadableIndex(index: Int) = values()[index - 1]
    }
}