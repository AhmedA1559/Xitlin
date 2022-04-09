class Parser {
    private fun nodeVisitor(curNode: Node) {
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
            else -> {
                return
            }
        }
    }

    private fun addNodesByRegex(curNode: Node, name: Name) {
        val matches = Rules.ruleMap[name]?.find(curNode.rawString)
        if (matches != null) {
            for (match in matches.groupValues) {
                val itemNode: Node = Node(name, match)
                nodeVisitor(itemNode)
                curNode.add(itemNode)
            }
        }
    }

    fun parse(rawString: String) {
        var curNode: Node = Node(Name.ROOT, rawString); // first node is root
        nodeVisitor(curNode)
    }
}

class Rules {
    companion object {
        val ruleMap = mapOf(
            Name.GROUP to Regex.fromLiteral("((^\\w+\$)?(^.*\$)+)")
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