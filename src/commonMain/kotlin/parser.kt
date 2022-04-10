import nodes.INode

class Parser {
    private fun nodeVisitor(curNode: INode) {
        when (curNode.nodeType) {
            Name.ROOT -> {
                // parse for groups
                addNodesByRegex(curNode, Name.GROUP)
            }
            Name.GROUP -> {
                addNodesByRegex(curNode, Name.TITLE)
                addNodesByRegex(curNode, Name.ITEM)
            }
            Name.ITEM -> {
                addNodesByRegex(curNode, Name.CHECKBOX)
                addNodesByRegex(curNode, Name.DESCRIPTION)
                addNodesByRegex(curNode, Name.PRIORITY)
                addNodesByRegex(curNode, Name.DUE_DATE)
                addNodesByRegex(curNode, Name.TAG)
            }
            else -> return
        }
    }

    private fun addNodesByRegex(curNode: INode, name: Name) {
        val matches = Rules.ruleMap[name]?.find(curNode.rawString)
        if (matches != null) {
            for (match in matches.groupValues) {
                val itemNode = INode(name, match)
                nodeVisitor(itemNode)
                curNode.add(itemNode)
            }
        }
    }

    fun parse(rawString: String): Map<String, dynamic> {
        val curNode = INode(Name.ROOT, rawString); // first node is root
        nodeVisitor(curNode)
        return curNode.toMap()
    }
}

class Rules {
    companion object {
        val ruleMap = mapOf(
            Name.GROUP to Regex.fromLiteral("((^\\w+\$)?(^.*\$)+)"),
            Name.TITLE to Regex.fromLiteral("^\\w+.*\$"),
            Name.ITEM to Regex.fromLiteral("^\\[.\\].*(\\s{5}.*)?"),
            Name.CHECKBOX to Regex.fromLiteral("^\\[(.)\\]"),
            Name.PRIORITY to Regex.fromLiteral("(?<=^\\[.\\] )[!.]+(?= )"),
            Name.TAG to Regex.fromLiteral("#([A-Za-z0-9_\\-]+(=([A-Za-z0-9_\\-])+|(['\\\"].*['\\\"]))?)")
        )
    }
}

enum class Name {
    ROOT,
    GROUP,
    TITLE,
    ITEM,
    CHECKBOX,
    PRIORITY,
    DESCRIPTION,
    DUE_DATE,
    TAG,
}