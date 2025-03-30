package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.Identifier

@Service
class TeamService {

    // Add identifierFactory property
    private val identifierFactory = IdentifierFactory()

    // Add the teamsStorage companion object
    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    // Implement the generateTeamsForOneRound method
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val generatedTeams = mutableListOf<Team>()

        for (i in 1..teamsNumber) {
            // Generate a unique ID for each team
            val id = identifierFactory.uniqueIdentifier()

            // Create a new team with the generated ID and add it to the list
            val team = Team(id)

            // Store the team in the teamsStorage map
            teamsStorage[id] = team

            // Add the team to the generated list
            generatedTeams.add(team)
        }

        return generatedTeams
    }
}
