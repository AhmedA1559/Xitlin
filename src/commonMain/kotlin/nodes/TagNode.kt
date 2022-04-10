import nodes.INode

class TagNode(name: Name, rawString: String) : INode(name, rawString) {
    override fun toMap(): Map<String, dynamic> {
        return mapOf("tag" to rawString)
    }
}