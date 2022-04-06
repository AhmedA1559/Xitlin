package nodes

interface INode {
    val children: List<INode>?

    fun toMap(): Map<String, dynamic>

}