package com.webmihir.IntPlusPlus.impl.impl2016.amazon;

import com.webmihir.IntPlusPlus.interfaces.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 102 (medium): Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://discuss.leetcode.com/category/110
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * For example, Given binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  return its level order traversal as:
 *  [
 *  [3],
 *  [9,20],
 *  [15,7]
 *  ]
 */
public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new LinkedList<>();
    if (root == null) return ret;

    TreeNode dummy = new TreeNode(0);
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    q.offer(dummy);

    List<Integer> cur = new ArrayList<>();
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node == dummy) {
        ret.add(cur);
        cur = new ArrayList<>();
        if (!q.isEmpty()) q.offer(dummy);
      } else {
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
        cur.add(node.val);
      }
    }
    return ret;
  }
}
