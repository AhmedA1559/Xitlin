package nodes

import Name

open class INode(val nodeType: Name, val rawString: String) {
    protected var children: MutableList<INode> = mutableListOf()

    fun add(node: INode) {
        children.add(node);
    }

    open fun toMap() : Map<String, dynamic> {
        return mapOf("groups" to children.toList().let { iNodeList -> iNodeList.map { it.toMap() } })
    }
}