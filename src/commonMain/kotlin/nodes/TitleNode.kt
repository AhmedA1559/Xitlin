package nodes

class TitleNode(override var children: List<INode>?) : INode {
    override fun toMap(): Map<String, dynamic> {
        TODO("Not yet implemented")
    }

    override fun parse(rawString: String): List<INode>? {
        TODO("Not yet implemented")
    }
}