package jetbrains.kotlin.course.alias.util

import alias.JsCard
import alias.JsTeam
import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameJsResult
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

typealias Identifier = Int

fun Card.toJsCard(): JsCard = JsCard(this.id, this.words.map { it.word }.toTypedArray())

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)

fun List<Team>.toArrayJsTeams() = this.map { it.toJsTeam() }.toTypedArray()

fun GameJsResult.toGameResult(): GameResult = this.map {
    val team = TeamService.teamsStorage[it.id] ?: error("Internal error! Unknown team with id: ${it.id} was received!")
    team.points = it.points
    team
}
class IdentifierFactory {
    // A counter to keep track of the last unique identifier
    private var counter: Int = 0

    // Function to generate the next unique identifier by incrementing the counter
    fun uniqueIdentifier(): Identifier {
        counter += 1
        return counter
    }
}
// Step 3: Create the uniqueIdentifier function
fun uniqueIdentifier(factory: IdentifierFactory): Identifier {
    return factory.uniqueIdentifier()
}
