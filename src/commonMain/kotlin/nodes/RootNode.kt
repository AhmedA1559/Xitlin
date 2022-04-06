package nodes

class RootNode(override val children: List<INode>?) : INode {

    override fun toMap(): Map<String, dynamic> {
        return mapOf("groups" to children?.toList()?.let { iNodeList -> iNodeList.map { it.toMap() } })
    }
}