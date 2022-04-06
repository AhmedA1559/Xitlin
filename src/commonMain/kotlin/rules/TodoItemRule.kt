package rules

import nodes.INode

class TodoItemRule : IRule {
    override val regex: Regex
        get() = TODO("Not yet implemented")

    override fun parse(raw: String): List<INode> {
        TODO("Not yet implemented")
    }


}