import nodes.INode

class GroupNode(name: Name, rawString: String) : INode(name, rawString) {
    override fun toMap(): Map<String, dynamic> {
        val map: MutableMap<String, dynamic> = mutableMapOf()
        map.putAll(children.first { it.nodeType == Name.TITLE}.toMap())
        map.put("items", children.filter { it.nodeType == Name.ITEM })
        return map
    }
}