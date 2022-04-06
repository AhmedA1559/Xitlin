package nodes

class ListNode(override val children: List<INode>?) : INode {
    override fun toMap(): Map<String, dynamic> {
        return mapOf('list' to )
    }
}