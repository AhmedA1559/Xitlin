package nodes

import Name

class CheckboxNode(name: Name, rawString: String) : INode(name, rawString) {
    val state: Status
    init {
        state = when (rawString.lowercase()[1]) {
            '@' -> Status.ONGOING
            'x' -> Status.CHECKED
            '~' -> Status.OBSOLETE
            else -> Status.OPEN
        }
    }

    override fun toMap(): Map<String, dynamic> {
        return mapOf("state" to state.name)
    }
}

enum class Status {
    OPEN,
    ONGOING,
    CHECKED,
    OBSOLETE
}