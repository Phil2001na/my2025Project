package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier

// Step 2: Create the Team data class
data class Team(
    val id: Identifier,
    var points: Int = 0
) {
    // Automatically initialize the name property
    val name: String = "Team#${id + 1}"
}
