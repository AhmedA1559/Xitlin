package rules

import nodes.INode
import nodes.TitleNode

class TitleRule : IRule {
    override val regex = Regex.fromLiteral("")
    override fun parse(raw: String): List<INode> {
        TODO("Not yet implemented")
    }


}