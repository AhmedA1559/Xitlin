package rules

import nodes.INode
import nodes.RootNode

class RootRule : IRule
{
    override val regex: Regex = Regex.fromLiteral("")

    override fun parse(raw: String): List<INode> {
        return listOf(RootNode(GroupRule().parse(raw)))
    }

}