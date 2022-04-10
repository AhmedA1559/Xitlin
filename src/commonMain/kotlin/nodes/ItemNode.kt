import nodes.INode

class ItemNode(name: Name, rawString: String) : INode(name, rawString) {
    override fun toMap(): Map<String, dynamic> {
        val map: MutableMap<String, dynamic> = mutableMapOf()
        for (child in children) {
            map.putAll(child.toMap())
        }
        return map
    }
}