import nodes.INode

class TitleNode(name: Name, rawString: String) : INode(name, rawString) {
    override fun toMap(): Map<String, dynamic> {
        return mapOf("title" to rawString)
    }
}
