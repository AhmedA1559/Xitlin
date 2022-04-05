package nodes

interface INode {
    var children: List<INode>?

    fun toMap(): Map<String, dynamic>

    fun parse(rawString: String): List<INode>?

}