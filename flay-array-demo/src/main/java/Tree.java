package main.java;

public class Tree {

    public TreeNode root;

    private Tree(Builder builder) {
        root = builder.root;
    }

    public static class Builder {

        public TreeNode root = new TreeNode();

        public Tree create() {
            return new Tree(this);
        }

        public Builder add(String[] keys, String value) {
            TreeNode search = root;

            for (int i = 0; i < keys.length; i++) {
                TreeNode currentNode = search.getSubNode(keys[i]);
                if (currentNode == null) {
                    if (i == keys.length - 1) {
                        search = search.addSubNodeWithValue(keys[i], value);
                    } else {
                        search = search.addSubNode(keys[i]);
                    }

                } else {
                    search = currentNode;
                }
            }
            return this;
        }
    }

    public String toJson() {
        return "{" + root.getSubTreeNodes() + "}";
    }
}