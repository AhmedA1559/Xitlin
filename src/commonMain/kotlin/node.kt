class Node(val nodeType: Name, val rawString: String) {
    private var children: MutableList<Node> = mutableListOf()
    var data: Map<String, dynamic> = mapOf()

    fun add(node: Node) {
        children.add(node);
    }
}