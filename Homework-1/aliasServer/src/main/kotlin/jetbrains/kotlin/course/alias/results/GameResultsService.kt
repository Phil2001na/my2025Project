package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        if (result.isEmpty()) {
            throw IllegalArgumentException("Game result cannot be empty")
        }

        result.forEach { team ->
            if (!TeamService.teamsStorage.containsKey(team.id)) {
                throw IllegalArgumentException("Unknown team ID: ${team.id}")
            }
        }

        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> {
        return gameHistory.reversed()
    }
}