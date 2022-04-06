package rules

import nodes.INode

interface IRule {
    val regex: Regex

    fun parse(raw: String) : List<INode>
}