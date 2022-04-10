import nodes.INode

class DescriptionNode(name: Name, rawString: String) : INode(name, rawString) {
    override fun toMap(): Map<String, dynamic> {
        return mapOf("description" to rawString)
    }
}
