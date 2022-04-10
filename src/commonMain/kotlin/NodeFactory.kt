import nodes.CheckboxNode
import nodes.DueDateNode
import nodes.INode
import nodes.PriorityNode

class NodeFactory {
    companion object {
        fun createNode(name: Name, rawString: String) : INode {
            return when (name) {
                Name.CHECKBOX -> CheckboxNode(name, rawString)
                Name.TITLE -> TitleNode(name, rawString)
                Name.DESCRIPTION -> DescriptionNode(name, rawString)
                Name.PRIORITY -> PriorityNode(name, rawString)
                Name.DUE_DATE -> DueDateNode(name, rawString)
                Name.TAG -> TagNode(name, rawString)
                Name.ITEM -> ItemNode(name, rawString)
                Name.GROUP -> GroupNode(name, rawString)
                else -> INode(name, rawString)
            }
        }
    }
}