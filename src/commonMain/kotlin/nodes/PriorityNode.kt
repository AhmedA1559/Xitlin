package nodes

import Name

class PriorityNode(name: Name, rawString: String) : INode(name, rawString) {
    val priorityLevel: Int
    init {
        priorityLevel = rawString.count { it == '!' }
    }

    override fun toMap(): Map<String, dynamic> {
        return mapOf("priority" to priorityLevel)
    }
}