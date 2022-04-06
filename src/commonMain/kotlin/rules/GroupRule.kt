package rules

import nodes.INode
import nodes.TodoItemNode

class GroupRule : IRule {
    override val regex: Regex
        get() = Regex.fromLiteral("")

    override fun parse(raw: String): List<INode> {
        return regex.findAll(raw).toList().map { TodoItemNode(TodoItemRule().parse(it.value)) }
    }
}