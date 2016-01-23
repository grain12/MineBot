/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minebot.pathfinding;

import java.util.Objects;
import net.minecraft.util.BlockPos;

/**
 *
 * @author leijurv
 */
public class Node {
    final BlockPos pos;
    double cost;
    Node previous;
    final Goal goal;
    final double estimatedCostToGoal;
    Action previousAction;
    public Node(BlockPos pos, Goal goal) {
        this.pos = pos;
        this.previous = null;
        this.cost = Short.MAX_VALUE;
        this.goal = goal;
        this.estimatedCostToGoal = goal.heuristic(pos);
        this.previousAction = null;
    }
    public double comparison() {
        return estimatedCostToGoal + cost;
    }
    @Override
    public int hashCode() {
        int hash = 3241;
        hash = 3457689 * hash + this.pos.getX();
        hash = 8734625 * hash + this.pos.getY();
        hash = 2873465 * hash + this.pos.getZ();
        hash = 3241543 * hash + Objects.hashCode(this.goal);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.pos, other.pos)) {
            return false;
        }
        if (!Objects.equals(this.goal, other.goal)) {
            return false;
        }
        return true;
    }
}
