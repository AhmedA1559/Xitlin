package rules

import nodes.TitleNode

class TitleRule : IRule {
    override val regex = Regex.fromLiteral("")

    override fun parse(raw: String): TitleNode {
        throw IllegalArgumentException()
    }

}